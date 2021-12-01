package com.vedika.functionhall.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AllStates")
public class Details {
	private String id;
	private CountryDetails countryDetails;
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
	@Override
	public String toString() {
		return "Details [id=" + id + ", countryDetails=" + countryDetails + "]";
	}

}
