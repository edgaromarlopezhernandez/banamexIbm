package com.banamex.ibm.applyforacreditcard.client;

import com.banamex.ibm.applyforacreditcard.dto.CreditCardDTO;
import com.banamex.ibm.applyforacreditcard.exception.WrongBanamexResourceException;
import com.banamex.ibm.applyforacreditcard.util.ExceptionMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreditCardClientImpl implements ICreditCardsClient{
    @Autowired
    private AuxMethodsForClientStuff auxMethods;

    @Override
    public List<CreditCardDTO> getAllCreditCards() {
        String url = "http://localhost:8082/api/v1/creditCards";
        ResponseEntity<String> response = auxMethods.requestForData(url, HttpMethod.GET);
        if(response.getStatusCode().equals(HttpStatus.OK)){
            String  cardDTOS = response.getBody();
            cardDTOS = auxMethods.formatAsJson(cardDTOS);
            return auxMethods.jsonStringToCreditCardDTO(cardDTOS);
        }
        else{
            throw new WrongBanamexResourceException(ExceptionMessages.INVALID_RESOURCE.getMessage());
        }
    }
}