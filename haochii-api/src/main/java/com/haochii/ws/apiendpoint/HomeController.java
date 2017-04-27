package com.haochii.ws.apiendpoint;

import java.io.UnsupportedEncodingException;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haochii.ws.filter.JWTSecured;
import com.haochii.ws.filter.JWTTokenUtil;
import com.haochii.ws.filter.Secured;


@Controller
@Path("/home")
public class HomeController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    

    @GET
    @Secured
    @Path("/welcome")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    @ResponseBody
    public JSONObject message() throws UnsupportedEncodingException {
        LOGGER.info("Coming to welcome api");
        String ss = JWTTokenUtil.buildJWT("secketKey");
        JSONObject welcome = new JSONObject();
        welcome.put("home", ss);
        return welcome;
    }
    
    @GET
    @JWTSecured
    @Path("/welcomeback")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"ADMIN","CUSTOMER"})
    @ResponseBody
    public JSONObject welcomeback(HttpServletRequest servletRequest) {
        LOGGER.info("Coming to welcomeback api");
        //String authorizationHeader = servletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        //JWTTokenUtil.validateJWT(token);
        JSONObject welcomeback = new JSONObject();
        welcomeback.put("home", "Welcome Back to Haochii API");
        return welcomeback;
    }
}
