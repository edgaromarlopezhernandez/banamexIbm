package com.banamex.ibm.creditcards.utils;

public enum ErrorMessages {
    FATAL_ERROR("ERROR FATAL, ALGO SALIO MUY MAL!!!!!!!!!");

    private final String message;
    ErrorMessages(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}