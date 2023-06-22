package com.mot.gml.client.domain.exceptions;

import com.mot.gml.client.domain.exceptions.constants.ExceptionsGMLConstants;
import lombok.Data;

import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data @EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException{
    private String code;
    private String param;
    private HttpStatus status;
    public BusinessException(String code, String param, HttpStatus status){
        super(ExceptionsGMLConstants.builder().message(code).param(param).build().getMessage());
        this.code = code;
        this.param = param;
        this.status = status;
    }

}