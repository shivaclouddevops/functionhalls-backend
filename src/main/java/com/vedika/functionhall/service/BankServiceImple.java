package com.vedika.functionhall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.vedika.functionhall.model.Bank;
import com.vedika.functionhall.repository.BankRespository;

@Service
public class BankServiceImple implements BankService {

	@Autowired
	BankRespository bankrepository;
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Bank> findbybank(String bank) {

		return bankrepository.findbybank(bank);
	}

	@Override
	public List<Bank> findAll() {

		return bankrepository.findAll();
	}

	@Override
	public List<Bank> findbyBranchAndBank(String bank, String branch) {
		// TODO Auto-generated method stub
		return bankrepository.findbyBranchAndBank(bank, branch);
	}

}
