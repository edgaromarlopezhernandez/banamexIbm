package com.banamex.ibm.creditcards.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class GeneralError extends RuntimeException {
    public GeneralError(String message){
        super(message);
    }
}
