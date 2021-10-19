package com.banamex.ibm.creditcards.dao;

import com.banamex.ibm.creditcards.entities.CreditCard;

import java.util.List;

public interface h2RepositoryImpl extends ICreditCardRepository{
    @Override
    public List<CreditCard> findAll();
}