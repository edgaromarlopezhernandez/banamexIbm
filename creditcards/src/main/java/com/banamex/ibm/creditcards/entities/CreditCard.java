package com.banamex.ibm.creditcards.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "Credit_Cards")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Creation_date")
    private LocalDate creationDate;

    @Column(name = "Card_type")
    private String cardType;

    @Column(name = "Minimum_Age")
    private Integer minimumAge;

    @Column(name = "Maximum_Age")
    private Integer maximumAge;

    @Column(name = "Minimum_Income")
    private Integer minimumIncome;

    @Column(name = "Maximum_Income")
    private Integer maximumIncome;

    @Column(name = "Benefits")
    private String benefits;

    @Column(name = "Credit_Card_Annuity")
    private Integer creditCardAnnuity;

    @Column(name = "Passions")
    private String passions;
}