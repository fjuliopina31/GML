package com.mot.gml.client.infrastructure.transversal.exceptions;

import com.mot.gml.client.infrastructure.transversal.exceptions.constants.TechnicalExceptionConstants;

public class TechnicalException extends RuntimeException{
    private String code;
    private String param;
    public TechnicalException(String code, String param){
        super(TechnicalExceptionConstants.builder().message(code).param(param).build().getMessage());
        this.code = code;
    }
}
