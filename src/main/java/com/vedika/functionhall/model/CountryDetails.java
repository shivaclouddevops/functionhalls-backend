package com.vedika.functionhall.model;

import java.util.List;

public class CountryDetails {

	private String name;
	private List<States> states;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<States> getStates() {
		return states;
	}
	public void setStates(List<States> states) {
		this.states = states;
	}
	@Override
	public String toString() {
		return "Data [name=" + name + ", states=" + states + "]";
	}


}
