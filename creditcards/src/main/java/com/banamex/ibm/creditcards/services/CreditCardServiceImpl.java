package com.banamex.ibm.creditcards.services;

import com.banamex.ibm.creditcards.entities.CreditCard;
import com.banamex.ibm.creditcards.dao.h2RepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardServiceImpl implements ICreditCardService{
    @Autowired
    private h2RepositoryImpl repository;

    @Override
    public List<CreditCard> getAll() {

        return repository.findAll();
    }
}
