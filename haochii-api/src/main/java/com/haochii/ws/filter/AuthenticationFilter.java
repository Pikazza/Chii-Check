package com.haochii.ws.filter;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.internal.util.Base64;

/**
 * Filter class for checking the authentication of the request by analyzing
 * authentication credentials in header part.
 * 
 * @author prabakaran
 *
 */
@Secured
public class AuthenticationFilter implements ContainerRequestFilter {
    
    @Context
    private ResourceInfo resourceInfo;
    
    private static final String AUTHORIZATION_PROPERTY = "Authorization";
    private static final String AUTHENTICATION_SCHEME = "Basic";
    private static final Response ACCESS_DENIED = Response.status(Response.Status.UNAUTHORIZED).entity("You cannot access this resource").build();
    
    /**
     * This method will check the logged in users authentication and return true
     * if user has an valid account credentials. Otherwise return false and make
     * the resource forbidden.
     * 
     * @param requestContext
     *            A mutable object that provides request-specific information
     *            for the filter.
     * @throws IOException
     *             It throws when unchecked IO error happens.
     * @see javax.ws.rs.container.ContainerRequestFilter#filter
     *      "javax.ws.rs.container.ContainerRequestContext".
     */
    
    @Override
    public void filter(ContainerRequestContext requestContext) {
        
        final MultivaluedMap<String, String> headers = requestContext.getHeaders();
        final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);
        if (authorization == null || authorization.isEmpty()) {
            requestContext.abortWith(ACCESS_DENIED);
            throw new NotAuthorizedException("Not authorised");
        }
        final String encodedUserPassword = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");
        String usernameAndPassword = new String(Base64.decode(encodedUserPassword.getBytes()));
        final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
        final String username = tokenizer.nextToken();
        final String password = tokenizer.nextToken();
        if (!isUserAllowed(username, password)) {
            throw new NotAuthorizedException("Not authorised");
        }
    }
    
    /**
     * This method will check the logged in users authentication and return true
     * if user has an account.
     * 
     * @param username
     *            A string as user name of party account.
     * @param password
     *            A string as password of the party account.
     * @return Return boolean value based on the party's account verification.
     */
    private boolean isUserAllowed(String username, String password) {
        boolean isAllowed = false;
        if ("Cumulonimbus".equals(username) && "H40@C#i!CuMl0P!K4ZzA9nIWBuzH40@C#i!".equals(password)) {
            isAllowed = true;
        }
        return isAllowed;
    }
}
