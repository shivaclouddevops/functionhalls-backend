package com.vedika.functionhall.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vedika.functionhall.model.Bank;

@Service
public interface BankService {

	List<Bank> findbybank(String bank);

	List<Bank> findbyBranchAndBank(String bank, String branch);

	List<Bank> findAll();
}
