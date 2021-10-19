package com.banamex.ibm.applyforacreditcard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataBadRequestException extends RuntimeException {
    public DataBadRequestException(String message){
        super(message);
    }
}
