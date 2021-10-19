package com.banamex.ibm.applyforacreditcard.client;

import com.banamex.ibm.applyforacreditcard.dto.CreditCardDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface ICreditCardsClient {

    public List<CreditCardDTO> getAllCreditCards();
}
