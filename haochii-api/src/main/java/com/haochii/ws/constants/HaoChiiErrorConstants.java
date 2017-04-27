package com.haochii.ws.constants;

/**
 * List of error constants
 * 
 * @author prabakaran
 *
 */
public class HaoChiiErrorConstants {
    
    //Error Constants
    public static final String UNKNOWN_ERRORCODE = "HCI0001";
    public static final String JWT_CREATION_ERRORCODE = "HCI0002";
    public static final String JWT_DECODE_ERRORCODE = "HCI0003";
    public static final String INVALID_TOKEN_ERRORCODE = "HCI0004";
    public static final String NOT_AUTHORIZED_ERRORCODE= "HCI0005";
    public static final String REQUEST_PATH_NOT_FOUND_ERRORCODE = "HCI0006";
    public static final String JSON_MAPPING_ERRORCODE = "HCI0007";
    
    //CORS Filter Constants
    public static final String ACCESS_CONTROL_CREDENTIALS = "Access-Control-Allow-Credentials";
    public static final String ACCESS_CONTROL_ORIGIN = "Access-Control-Allow-Origin";
    public static final String ACCESS_CONTROL_METHODS = "Access-Control-Allow-Methods";
    public static final String ACCESS_CONTROL_HEADERS = "Access-Control-Allow-Headers";
    public static final String ACCESS_CONTROL_MAX_AGE = "Access-Control-Max-Age";
    
    private HaoChiiErrorConstants() {
    }
}