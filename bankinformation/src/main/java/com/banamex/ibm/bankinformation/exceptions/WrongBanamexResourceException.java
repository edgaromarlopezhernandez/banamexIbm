package com.banamex.ibm.bankinformation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class WrongBanamexResourceException extends RuntimeException{
    public WrongBanamexResourceException(String message){
        super(message);
    }
}
