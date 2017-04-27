package com.haochii.ws.filter;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JWTTokenUtil {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(JWTTokenUtil.class);
    
    private JWTTokenUtil() {
    }
    
    public static String buildJWT(String secketKey) throws UnsupportedEncodingException {
        
        String token = null;
        Date dNow = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dNow);
        cal.add(Calendar.MINUTE, 5);
        dNow = cal.getTime();
        Algorithm algorithm = Algorithm.HMAC256(secketKey);
        token = JWT.create().withIssuer("auth0").withClaim("userType", "Vendor").withClaim("fname", "prabakaran").withClaim("lname", "mathi")
                .withIssuedAt(new Date()).withExpiresAt(dNow).sign(algorithm);
        LOGGER.info("Building JWT : " + token);
        return token;
    }
    
    public static void verifyJWT(String token) throws UnsupportedEncodingException {
        LOGGER.info("Verifying Token : " + token);
        Algorithm algorithm1 = Algorithm.HMAC256("secketKey");
        JWTVerifier verifier = JWT.require(algorithm1).withIssuer("auth0").build();
        verifier.verify(token);
    }
    
    public static void validateJWT(String token) throws UnsupportedEncodingException {
        LOGGER.info("Validating Token : " + token);
        Algorithm algorithm2 = Algorithm.HMAC256("secketKey");
        JWTVerifier verifier = JWT.require(algorithm2).withIssuer("auth0").withClaim("fname", "prabakaran")
                .withClaim("lname", "mathi").build();
        verifier.verify(token);
        LOGGER.info("Validating Token Success");
    }
}
