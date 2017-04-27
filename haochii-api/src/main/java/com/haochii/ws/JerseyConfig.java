package com.haochii.ws;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.haochii.ws.exception.CustomExceptionMapper;
import com.haochii.ws.filter.AuthenticationFilter;
import com.haochii.ws.filter.CORSResponseFilter;
import com.haochii.ws.filter.JWTRequestFilter;

/**
 * Jersey Configuration class with register all api endpoints and binds
 * exception mappers in Jersey level
 * 
 * @author prabakaran
 */
@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("com.haochii.ws.apiendpoint");
        register(JWTRequestFilter.class);
        register(AuthenticationFilter.class);
        register(CORSResponseFilter.class);
        register(CustomExceptionMapper.class);
        register(JacksonJsonProvider.class);
    }
}
