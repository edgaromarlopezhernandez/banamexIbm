package com.banamex.ibm.creditcards.utils;

public enum ResponseMessages {
    OK("Success"),
    NO_CREDIT_CARDS_FOUND("No se encontro ninguna tarjeta de credito en el sistema, verifique la informacion o intente mas tarde");


    private final String message;
    ResponseMessages(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
