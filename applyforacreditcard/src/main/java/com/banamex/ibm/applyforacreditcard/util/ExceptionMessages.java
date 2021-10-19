package com.banamex.ibm.applyforacreditcard.util;

public enum ExceptionMessages {

    INCORRECT_DATA_LOCATION("Ubicacion nula no permitida, ingresa CP o Ciudad o Estado o Longitud y Latitud"),
    ESTATE_ARE_NOT_LETTERS("El estado no debe contener numeros ni caracteres especiales, ingresa uno valido..."),
    EMPTY_ESTATE_NOT_ALLOWED("El estado esta vacio, ingresa uno valido..."),
    CITY_ARE_NOT_LETTERS("La ciudad no debe contener numeros ni caracteres especiales, ingresa una valida..."),
    EMPTY_CITY_NOT_ALLOWED("La ciudad esta vacia, ingresa una valida..."),
    INCORRECT_LENGTH_POSTAL_CODE("El codigo postal debe ser un numero de 5 digitos, ingresa uno valido..."),
    NOT_NUMERIC_POSTAL_CODE("El codigo postal debe ser un numero de 5 digitos, ingresa uno valido..."),
    EMPTY_POSTAL_CODE_NOT_ALLOWED("El codigo postal no puede estar vacio, ingresa un dato valido..."),
    NOT_NUMERIC_LONGITUDE("Longitud debe ser un valor numerio, ingresa uno valido..."),
    EMPTY_GPS_NOT_ALLOWED("Latitud y longitud no pueden estar vacios, ingresa datos validos..."),
    NOT_NUMERIC_LATITUDE("Latitude debe ser un valor numerio, ingresa uno valido..."),
    EMPTY_PASSION_NOT_ALLOWED("La pasion no puede ser vacia, ingresa una valida"),
    NULL_PASSION_NOT_ALLOWED("La pasion no puede ser nula, ingresa una valida"),
    NOT_NUMERIC_SALARY("El salario debe ser un numero no negativo, ingresa uno valido"),
    INVALID_LENGTH_PHONE("El telefono debe estar compuesto de 10 digitos"),
    NOT_NUMERIC_PHONE("El telefono solo debe contener numeros, ingresa uno valido..."),
    NOT_NUMERIC_AGE("La edad debe ser un numero, ingresa una valida..."),
    INVALID_AGE("Lo sentimos la edad ingresada no es valida"),
    NOT_A_NAME("El nombre no debe contener numeros, ingresa uno adecuadamente..."),
    EMPTY_NAME_NOT_ALLOWED("El nombre no puede estar vacio, ingresa uno..."),
    NUL_NAME_NOT_ALLOWED("El nombre no puede ser nulo, ingresa uno..."),
    DATA_PROCESSING_ERROR("Error procesando datos, intente mas tarde!!"),
    DATA_INCONSISTENCY("Banamex ha cambiado la estructura de su servicos, ya no va a funcionar SOS!!"),
    INVALID_RESOURCE("Algo salio mal comunicandose con el servicio que provee tarjetas de credito Banamex, intente mas tarde!!");


    private final String message;
    ExceptionMessages(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}