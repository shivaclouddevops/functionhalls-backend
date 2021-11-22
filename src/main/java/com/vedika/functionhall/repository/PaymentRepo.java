package com.vedika.functionhall.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vedika.functionhall.model.Payment;

@Repository
public interface PaymentRepo extends MongoRepository <Payment,String> {

    Payment findByTxnId(String txnId);
    List<Payment> findAll();
}