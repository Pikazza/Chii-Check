package com.haochii.ws.filter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

@JWTSecured
public class JWTRequestFilter implements ContainerRequestFilter {
    
    private static final String CUSTOMER_ROLE = "CUSTOMER";
    private static final String VENDOR_ROLE = "VENDOR";
    private static final String ADMIN_ROLE = "ADMIN";
    private static final String USER_TYPE = "userType";
    private static final Logger LOGGER = LoggerFactory.getLogger(JWTRequestFilter.class);
    private Pattern tokenPattern = Pattern.compile("^Bearer$", Pattern.CASE_INSENSITIVE);
    
    @Context
    private ResourceInfo resinfo;
    
    public JWTRequestFilter() {
        LOGGER.info("JWTRequestFilter starting up ");
    }
    
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Method method = resinfo.getResourceMethod();
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        LOGGER.info("authorization Header : " + authorizationHeader);
        if (!StringUtils.isEmpty(authorizationHeader)) {
            String token = parseBearerToken(authorizationHeader);
            if (!StringUtils.isEmpty(token)) {
                JWTTokenUtil.validateJWT(token);
                RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
                Set<String> rolesSet = new HashSet<>(Arrays.asList(rolesAnnotation.value()));
                if (method.isAnnotationPresent(RolesAllowed.class) && !method.isAnnotationPresent(PermitAll.class) && !isUserAllowed(token, rolesSet)) {
                    LOGGER.info("User don't have a permission to access the Resource : " + method.getName());
                    throw new NotAuthorizedException("User don't have a permission to access the Resource : " + method.getName());
                }
            } else {
                LOGGER.info("No JWT Token is Passed");
                throw new NotAuthorizedException("Unauthorized : No JWT Token is Passed");
            }
        } else {
            LOGGER.info("No authorization Header is Passed");
            throw new NotAuthorizedException("Unauthorized : Unable to parse Bearer token");
        }
        
    }
    
    private String parseBearerToken(final String bearerToken) {
        String tokenValue = null;
        if (bearerToken != null) {
            String[] parts = bearerToken.split(" ");
            if (parts.length == 2) {
                String scheme = parts[0];
                String credentials = parts[1];
                if (tokenPattern.matcher(scheme).matches()) {
                    tokenValue = credentials;
                }
            }
        }
        return tokenValue;
    }
    
    private boolean isUserAllowed(String token, Set<String> rolesSet) {
        boolean isAllowed = false;
        DecodedJWT jwt = JWT.decode(token);
        Map<String, Claim> claims = jwt.getClaims();
        if (claims.get(USER_TYPE).asString().equalsIgnoreCase(CUSTOMER_ROLE) && rolesSet.contains(CUSTOMER_ROLE)) {
            isAllowed = true;
            LOGGER.info("The User Role Type is : " + CUSTOMER_ROLE);
        } else if (claims.get(USER_TYPE).asString().equalsIgnoreCase(VENDOR_ROLE)
                && rolesSet.contains(VENDOR_ROLE)) {
            isAllowed = true;
            LOGGER.info("The User Role Type is : " + VENDOR_ROLE);
        } else if (claims.get(USER_TYPE).asString().equalsIgnoreCase(ADMIN_ROLE) && rolesSet.contains(ADMIN_ROLE)) {
            isAllowed = true;
            LOGGER.info("The User Role Type is : " + ADMIN_ROLE);
        }
        return isAllowed;
    }
}
