package com.banamex.ibm.creditcards.converters;

import com.banamex.ibm.creditcards.dtos.CreditCardDTO;
import com.banamex.ibm.creditcards.entities.CreditCard;
import org.springframework.stereotype.Component;

@Component
public class CreditCardsConverter extends DefinitionOfConverter<CreditCard, CreditCardDTO>{
    @Override
    public CreditCardDTO fromEntity(CreditCard entity) {
        return CreditCardDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .minimumAge(entity.getMinimumAge())
                .maximumAge(entity.getMaximumAge())
                .minimumIncome(entity.getMinimumIncome())
                .maximumIncome(entity.getMaximumIncome())
                .benefits(entity.getBenefits())
                .creditCardAnnuity(entity.getCreditCardAnnuity())
                .passions(entity.getPassions())
                .build();
    }

}
