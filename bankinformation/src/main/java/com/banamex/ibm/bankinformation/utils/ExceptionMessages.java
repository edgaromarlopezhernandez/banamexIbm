package com.banamex.ibm.bankinformation.utils;

public enum ExceptionMessages {
    DATA_PROCESSING_ERROR("Error procesando datos, intente mas tarde!!"),
    DATA_INCONSISTENCY("Banamex ha cambiado la estructura de su servicos, ya no va a funcionar SOS!!"),
    INVALID_RESOURCE("Algo salio mal haciendo request al servicio de Banamex, intente mas tarde!!");


    private final String message;
    ExceptionMessages(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
