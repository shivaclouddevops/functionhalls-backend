package com.vedika.functionhall.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "banksdetails")
public class Bank {

	@Id
	private String _id;

	public List<BankDetails> banks;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public List<BankDetails> getBanks() {
		return banks;
	}

	public void setBanks(List<BankDetails> banks) {
		this.banks = banks;
	}

}
