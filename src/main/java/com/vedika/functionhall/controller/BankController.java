package com.vedika.functionhall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vedika.functionhall.model.Bank;
import com.vedika.functionhall.model.BankDetails;
import com.vedika.functionhall.model.GenericResponse;
import com.vedika.functionhall.model.Responsebank;
import com.vedika.functionhall.service.BankService;

@RestController
@RequestMapping("/api")

public class BankController {

	private static String[] mBankList;

	@Autowired
	private BankService bankservice;

	@GetMapping("/bankdetails/")
	public ResponseEntity<GenericResponse<List<Responsebank>>> getBank(@RequestParam(value = "bankname") String bank,
			@RequestParam(value = "branch") String branch) {
		List<Bank> response = bankservice.findbyBranchAndBank(bank, branch);
		List<Responsebank> functionhallsUI = new ArrayList<Responsebank>();
		if (null != response && !response.isEmpty()) {
			for (Bank owner : response) {
				List<BankDetails> funtionhalls = owner.getBanks();
				if (null != funtionhalls && !funtionhalls.isEmpty()) {
					for (BankDetails bankdetails : funtionhalls) {
						Responsebank response1 = new Responsebank();
						response1.setId(owner.get_id());
						response1.setAddress(bankdetails.getAddress());
						response1.setBankname(bankdetails.getBank());
						response1.setBranch(bankdetails.getBranch());
						response1.setCity(bankdetails.getCity());
						response1.setIfsc(bankdetails.getIfsc());
						response1.setContact(bankdetails.getContact());
						response1.setState(bankdetails.getState());
						response1.setDistrict(bankdetails.getDistrict());
						functionhallsUI.add(response1);
					}
				}
			}
		}
		GenericResponse<List<Responsebank>> bankdata = new GenericResponse<List<Responsebank>>();
		bankdata.setData(functionhallsUI);
		return new ResponseEntity<>(bankdata, HttpStatus.OK);

	}

	@GetMapping("/branches")
	public ResponseEntity<GenericResponse<Set<String>>> getBank(@RequestParam(value = "bank") String bank) {
		GenericResponse<Set<String>> response = new GenericResponse<>();
		Optional<Set<String>> branchNameList = Optional.of(new TreeSet<>());
		List<Bank> bankResponse = bankservice.findbybank(bank);
		if (null != bankResponse && !bankResponse.isEmpty()) {
			for (Bank bankdata : bankResponse) {

				List<BankDetails> banklist = bankdata.getBanks();
				if (null != banklist && !banklist.isEmpty()) {

					for (BankDetails branch : banklist) {
						if (branch.getBranch() != null && !branch.getBranch().isEmpty()
								&& !branchNameList.get().contains(branch.getBranch())) {
							branchNameList.get().add(branch.getBranch());
						}

					}

					response.setData(branchNameList.get());
				}

			}

		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/banks")
	public ResponseEntity<GenericResponse<String[]>> getBank() {
		Optional<Set<String>> bankNameList = Optional.of(new TreeSet<>());
		List<Bank> banks = bankservice.findAll();
		if (null != banks && !banks.isEmpty()) {
			for (Bank bank : banks) {
				List<BankDetails> details = bank.getBanks();

				if (null != details && !details.isEmpty()) {

					for (BankDetails bankdata : details) {
						if (bankdata.getBank() != null && !bankdata.getBank().isEmpty()
								&& !bankNameList.get().contains(bankdata.getBank())) {
							bankNameList.get().add(bankdata.getBank());
						}
					}
				}
			}

			mBankList = bankNameList.get().toArray(new String[bankNameList.get().size()]);
		}
		GenericResponse<String[]> response = new GenericResponse<>();
		response.setData(mBankList);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
