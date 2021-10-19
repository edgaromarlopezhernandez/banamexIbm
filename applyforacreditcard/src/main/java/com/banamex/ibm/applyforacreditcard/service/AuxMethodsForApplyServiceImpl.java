package com.banamex.ibm.applyforacreditcard.service;

import com.banamex.ibm.applyforacreditcard.dto.ApplyRequest;
import com.banamex.ibm.applyforacreditcard.dto.CreditCardDTO;
import com.banamex.ibm.applyforacreditcard.dto.LocationDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuxMethodsForApplyServiceImpl {

    public List<CreditCardDTO> selectCreditCards(List<CreditCardDTO> creditCards, ApplyRequest payload){
        creditCards = creditCards.stream()
                .filter(creditCardDTO -> creditCardDTO.getPassions().contains(payload.getYourPassion()))
                .filter(creditCardDTO -> creditCardDTO.getMinimumIncome() <= Integer.parseInt(payload.getMonthlySalary()))
                .filter(creditCardDTO -> creditCardDTO.getMinimumAge() <= Integer.parseInt(payload.getAge()))
                .collect(Collectors.toList());
        return creditCards;
    }

    public List<LocationDTO> selectAtmsAndBanks(List<LocationDTO> locationDTOS, ApplyRequest payload){
        if(payload.getPostalCode() != null){
            locationDTOS = locationDTOS.stream()
                    .filter(locationDTO -> locationDTO.getLocation().contains(payload.getPostalCode()))
                    .distinct()
                    .collect(Collectors.toList());
        }
        return locationDTOS;
    }
}