package com.banamex.ibm.creditcards.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
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
