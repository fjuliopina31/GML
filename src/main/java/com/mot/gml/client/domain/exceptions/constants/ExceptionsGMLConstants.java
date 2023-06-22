package com.mot.gml.client.domain.exceptions.constants;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionsGMLConstants {
    public static final String GML_CLIENT_NOT_FOUND = "Invalid Client Shared Key";
    public static final String REQUEST_NOT_VALID = "Request not valid";
    public static final String GML_SHARED_KEY_ALREADY_EXIST = "The Client with shared key already exists";
    public static final String INVALID_EMAIL = "Invalid email";
    public static final String INVALID_EMAIL_NULL = "Invalid Email must not be empty";
    public static final String INVALID_NAME_NULL = "Invalid field Name, must not be empty or null";
    public static final String INVALID_SHARED_KEY_NULL = "Invalid field Shared key, must not be empty or null";

    private String message;
    private String param;
    public ExceptionsGMLConstants(String code, String param){
        this.message = this.HandlerStatusErrorCode(code,param);
        System.out.println(message);
    }

    public String HandlerStatusErrorCode(String code,String param){
        switch (code){
            case "R-400":
                return REQUEST_NOT_VALID;
            case "R-402":
                return INVALID_EMAIL_NULL;
            case "R-403":
                return INVALID_EMAIL;
            case "R-404":
                return INVALID_NAME_NULL;
            case "R-406":
                return INVALID_SHARED_KEY_NULL;
            case "R-405":
                return GML_SHARED_KEY_ALREADY_EXIST;
            case "B-304":
                return GML_CLIENT_NOT_FOUND;
        }
        return code;
    }
}
