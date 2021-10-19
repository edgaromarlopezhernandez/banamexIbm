package com.banamex.ibm.applyforacreditcard.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCardDTO implements Serializable {

    private Long id;
    private String name;
    private Integer minimumAge;
    private Integer maximumAge;
    private Integer minimumIncome;
    private Integer maximumIncome;
    private String benefits;
    private Integer creditCardAnnuity;
    private String passions;
}
