package com.vedika.functionhall.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.vedika.functionhall.model.Bank;

@Repository
public interface BankRespository extends MongoRepository<Bank, String> {

	@Query(value = " {'banks.bank': ?0}")
	List<Bank> findbybank(String bank);

	@Query(value = "{'banks.bank' : ?0,'banks.branch':?1}", fields = "{'banks.$':1}")

	List<Bank> findbyBranchAndBank(String bank, String branch);

	List<Bank> findAll();

}
