package com.banamex.ibm.applyforacreditcard.service;

import com.banamex.ibm.applyforacreditcard.client.BankInformationClientImpl;
import com.banamex.ibm.applyforacreditcard.client.CreditCardClientImpl;
import com.banamex.ibm.applyforacreditcard.dto.ApplyRequest;
import com.banamex.ibm.applyforacreditcard.dto.ApplyResponse;
import com.banamex.ibm.applyforacreditcard.dto.CreditCardDTO;
import com.banamex.ibm.applyforacreditcard.dto.LocationDTO;
import com.banamex.ibm.applyforacreditcard.util.ApplyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyServiceImpl implements IApplyService {

    @Autowired
    private ApplyValidator validator;
    @Autowired
    private AuxMethodsForApplyServiceImpl auxMethodsService;
    @Autowired
    private CreditCardClientImpl creditCardClient;
    @Autowired
    private BankInformationClientImpl bankInformationClient;

    @Override
    public ApplyResponse applyForACreditCard(ApplyRequest payload) {
        //1) Validate payload
        validator.validate(payload);
        //2) Request for credit cards
        List<CreditCardDTO> cards = creditCardClient.getAllCreditCards();
        //3) Logic to select credit cards that match
        cards = auxMethodsService.selectCreditCards(cards, payload);
        //4) Request for bank information
        List<LocationDTO> locations = bankInformationClient.getAllLocations();
        //5) Logic to select atm's & banks
        locations = auxMethodsService.selectAtmsAndBanks(locations, payload);
        //6) Return response
        ApplyResponse response = ApplyResponse.builder()
                .message("Felicidades " + payload.getName() + " hemos analizado tus datos y podrias disfrutar de las tarjetas de la siguiente lista y podrias pasar a tramitarla a cualquiera de las sucursales que se enlistan.")
                .cards(cards)
                .atmsAndBanks(locations)
                .build();

        return response;
    }
}