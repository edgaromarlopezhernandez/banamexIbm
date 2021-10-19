package com.banamex.ibm.applyforacreditcard.client;

import com.banamex.ibm.applyforacreditcard.dto.CreditCardDTO;
import com.banamex.ibm.applyforacreditcard.dto.LocationDTO;
import com.banamex.ibm.applyforacreditcard.exception.WrongBanamexResourceException;
import com.banamex.ibm.applyforacreditcard.util.ExceptionMessages;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class AuxMethodsForClientStuff {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> requestForData(String url, HttpMethod method){
        ResponseEntity<String> response =
                restTemplate.exchange(url,
                        HttpMethod.GET,
                        null,
                        String.class);
        return response;
    }

    public String formatAsJson(String stringToFormat){
        if(stringToFormat.startsWith("{\"ok\":true,\"message\":\"Success\",\"data\":")) {
            return stringToFormat = stringToFormat.substring(38, stringToFormat.length() - 1);
        }else{
            throw new WrongBanamexResourceException(ExceptionMessages.DATA_INCONSISTENCY.getMessage());
        }
    }

    public List<CreditCardDTO> jsonStringToCreditCardDTO(String cardDTOS){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();;
        final Type cardsListType = new TypeToken<List<CreditCardDTO>>(){}.getType();
        List<CreditCardDTO> finalList = gson.fromJson(cardDTOS, cardsListType);
        return finalList;
    }

    public List<LocationDTO> jsonStringToLocationDTO(String locationDTOS){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();;
        final Type locationsListType = new TypeToken<List<LocationDTO>>(){}.getType();
        List<LocationDTO> finalList = gson.fromJson(locationDTOS, locationsListType);
        return finalList;
    }
}
