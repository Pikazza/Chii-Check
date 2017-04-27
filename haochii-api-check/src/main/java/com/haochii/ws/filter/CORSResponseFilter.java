package com.haochii.ws.filter;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haochii.ws.constants.HaoChiiErrorConstants;


/**
 * The CORSResponseFilter will check the users request and set allowable Access
 * control origins, Access control methods and header globally to any outgoing
 * response. So users can access server resources after successful
 * authentication.
 *
 */

@Provider
public class CORSResponseFilter implements ContainerResponseFilter, ContainerRequestFilter {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CORSResponseFilter.class);
    /**
     * Filter method called after a response has been provided for a request
     * (either by a request filter or by a matched resource method.
     * 
     * @param requestContext
     *            request context.
     * @param responseContext
     *            response context.
     * @throws IOException
     *             if an I/O exception occurs.
     */
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {
        
        MultivaluedMap<String, Object> headers = responseContext.getHeaders();
        
        //LOGGER.debug("Access-Control-Request-Methods from Request : "+ requestContext.getHeaderString("Access-Control-Request-Methods"));
        //LOGGER.debug("Access-Control-Request-Headers from Request : "+ requestContext.getHeaderString("Access-Control-Request-Headers"));
        
        if ("OPTIONS".equals(requestContext.getMethod())) {
            LOGGER.debug("Current Access Method : "+ requestContext.getMethod());
            if (!headers.containsKey(HaoChiiErrorConstants.ACCESS_CONTROL_CREDENTIALS))
                headers.add(HaoChiiErrorConstants.ACCESS_CONTROL_CREDENTIALS, "true");
            if (!headers.containsKey(HaoChiiErrorConstants.ACCESS_CONTROL_ORIGIN)) 
                headers.add(HaoChiiErrorConstants.ACCESS_CONTROL_ORIGIN, "*");
            if (!headers.containsKey(HaoChiiErrorConstants.ACCESS_CONTROL_METHODS)) 
                headers.add(HaoChiiErrorConstants.ACCESS_CONTROL_METHODS, "GET, POST, DELETE, PUT, OPTIONS");
            if (!headers.containsKey(HaoChiiErrorConstants.ACCESS_CONTROL_HEADERS))
                headers.add(HaoChiiErrorConstants.ACCESS_CONTROL_HEADERS,
                        "X-Application-Context, X-Requested-With, Content-Type, Authorization, Origin, Access-Control-Request-Method, Access-Control-Request-Headers");
            if (!headers.containsKey(HaoChiiErrorConstants.ACCESS_CONTROL_MAX_AGE)) 
                headers.add(HaoChiiErrorConstants.ACCESS_CONTROL_MAX_AGE, "2");
            
            responseContext.setStatus(200);
        } else {
            LOGGER.debug("Current Access Method : "+ requestContext.getMethod());
            headers.putSingle("Content-Type", "application/json;charset=UTF-8");
            if (!headers.containsKey(HaoChiiErrorConstants.ACCESS_CONTROL_CREDENTIALS))
                headers.add(HaoChiiErrorConstants.ACCESS_CONTROL_CREDENTIALS, "true");
                headers.add(HaoChiiErrorConstants.ACCESS_CONTROL_ORIGIN, "*");
            if (!headers.containsKey(HaoChiiErrorConstants.ACCESS_CONTROL_METHODS)) 
                headers.add(HaoChiiErrorConstants.ACCESS_CONTROL_METHODS, "GET, POST, DELETE, PUT, OPTIONS");
            if (!headers.containsKey(HaoChiiErrorConstants.ACCESS_CONTROL_HEADERS))
                headers.add(HaoChiiErrorConstants.ACCESS_CONTROL_HEADERS,
                        "X-Application-Context, X-Requested-With, Content-Type, Authorization, Origin, Access-Control-Request-Method, Access-Control-Request-Headers");
            if (!headers.containsKey(HaoChiiErrorConstants.ACCESS_CONTROL_MAX_AGE))
                headers.add(HaoChiiErrorConstants.ACCESS_CONTROL_MAX_AGE, "2");
        }
    }
    
    /**
     * Filter method called after a response has been provided for a request
     * (either by a request filter or by a matched resource method.
     * 
     * @param requestContext
     *            request context.
     * @throws IOException
     *             It throws when unchecked IO exception happens.
     */
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String method = requestContext.getMethod();
        if ("OPTIONS" == method)
            throw new WebApplicationException(javax.ws.rs.core.Response.Status.OK);
    }
    
}
