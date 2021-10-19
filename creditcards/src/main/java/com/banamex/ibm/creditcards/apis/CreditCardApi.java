package com.banamex.ibm.creditcards.apis;

import com.banamex.ibm.creditcards.converters.CreditCardsConverter;
import com.banamex.ibm.creditcards.exceptions.GeneralError;
import com.banamex.ibm.creditcards.utils.CustomResponse;
import com.banamex.ibm.creditcards.entities.CreditCard;
import com.banamex.ibm.creditcards.services.CreditCardServiceImpl;
import com.banamex.ibm.creditcards.utils.ResponseMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/creditCards")
public class CreditCardApi {

    @Autowired
    private CreditCardServiceImpl service;
    @Autowired
    private CreditCardsConverter converter;

    @GetMapping
    public ResponseEntity<CustomResponse<List<CreditCard>>> getCreditCards (){


        List<CreditCard> creditCards = service.getAll();
        if(creditCards.isEmpty()){
            return new CustomResponse(true, ResponseMessages.NO_CREDIT_CARDS_FOUND.getMessage(), null).createResponse(HttpStatus.NOT_FOUND);
        }
        else {
            return new CustomResponse(true, ResponseMessages.OK.getMessage(), converter.fromEntity(creditCards)).createResponse();
        }
    }
}