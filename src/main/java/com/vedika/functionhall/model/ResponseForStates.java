package com.vedika.functionhall.model;

import java.util.List;

public class ResponseForStates {
	private String id;
	private CountryDetails countryDetails;
	private List<States> states;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public CountryDetails getCountryDetails() {
		return countryDetails;
	}
	public void setCountryDetails(CountryDetails countryDetails) {
		this.countryDetails = countryDetails;
	}
	public List<States> getStates() {
		return states;
	}
	public void setStates(List<States> states) {
		this.states = states;
	}



}
