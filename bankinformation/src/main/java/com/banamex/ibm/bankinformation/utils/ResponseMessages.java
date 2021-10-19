package com.banamex.ibm.bankinformation.utils;

public enum ResponseMessages {
    OK("Success"),
    NO_LOCATIONS_FOUND("No se encontro ningun cajero/sucursal en el sistema, verifique la informacion o intente mas tarde");


    private final String message;
    ResponseMessages(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
