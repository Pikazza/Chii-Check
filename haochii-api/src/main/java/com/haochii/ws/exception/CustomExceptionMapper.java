package com.haochii.ws.exception;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.haochii.ws.constants.HaoChiiErrorConstants;
import com.haochii.ws.model.ErrorModel;

/**
 * This class used to map Java exceptions to Response.
 * 
 * @author prabakaran
 */
@Provider
public class CustomExceptionMapper implements ExceptionMapper<Exception> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionMapper.class);
    /**
     * This method will return response object which contains cause of runtime
     * failure happened to clients request. Map an exception to a Response.
     * 
     * @param exception
     *            An exception object that will have the cause of runtime
     *            failure for mapping.
     * @return a response mapped from the supplied exception
     */
    public Response toResponse(Exception exception) {
        
        ErrorModel em = new ErrorModel();
        Status status;
        if (exception instanceof org.codehaus.jackson.JsonParseException) {
            em.setCode(HaoChiiErrorConstants.JSON_MAPPING_ERRORCODE);
            status=Status.BAD_REQUEST;
        }else if (exception instanceof NotFoundException) {
            em.setCode(HaoChiiErrorConstants.REQUEST_PATH_NOT_FOUND_ERRORCODE);
            status=Status.NOT_FOUND;
        }else if (exception instanceof NotAuthorizedException) {
            em.setCode(HaoChiiErrorConstants.NOT_AUTHORIZED_ERRORCODE);
            status=Status.UNAUTHORIZED;
        }else if (exception instanceof InvalidClaimException) {
            em.setCode(HaoChiiErrorConstants.INVALID_TOKEN_ERRORCODE);
            status=Status.BAD_REQUEST;
        }else if (exception instanceof JWTDecodeException) {
            em.setCode(HaoChiiErrorConstants.JWT_DECODE_ERRORCODE);
            status=Status.BAD_REQUEST;
        }else if (exception instanceof JWTCreationException) {
            em.setCode(HaoChiiErrorConstants.JWT_CREATION_ERRORCODE);
            status=Status.BAD_REQUEST;
        }else {
            em.setCode(HaoChiiErrorConstants.UNKNOWN_ERRORCODE);
            status=Status.BAD_REQUEST;
        }
        
        em.setMessage(exception.getMessage());
        em.setStatus(exception.getClass().toString());
        LOGGER.debug("Exception Thrown on", exception);
        return Response.status(status).entity(em).build();
    }
}
