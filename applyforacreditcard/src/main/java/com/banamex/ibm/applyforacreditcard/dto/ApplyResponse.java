package com.banamex.ibm.applyforacreditcard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplyResponse {
    String message;
    List<CreditCardDTO> cards;
    List<LocationDTO> atmsAndBanks;
}
