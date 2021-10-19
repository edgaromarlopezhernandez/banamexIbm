package com.banamex.ibm.creditcards.dao;

import com.banamex.ibm.creditcards.entities.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICreditCardRepository extends JpaRepository<CreditCard, Long> {

    public List<CreditCard> findAll();

}
