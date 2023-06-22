package com.mot.gml.client.infrastructure.transversal.exceptions;

import com.mot.gml.client.domain.exceptions.constants.ExceptionsGMLConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(callSuper = false)
public class RequestException extends RuntimeException{
    private String code;
    public RequestException(String code){
        super(ExceptionsGMLConstants.builder().message(code).build().getMessage());
        this.code = code;
    }
}
