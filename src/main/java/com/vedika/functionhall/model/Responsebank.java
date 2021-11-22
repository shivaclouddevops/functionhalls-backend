package com.vedika.functionhall.model;

public class Responsebank {
	private String id;

	private String bankname;
	private String ifsc;
	private String branch;
	private String address;
	private String contact;
	private String state;
	private String city;
	private String district;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Responsebank [id=" + id + ", bankname=" + bankname + ", ifsc=" + ifsc + ", branch=" + branch
				+ ", address=" + address + ", contact=" + contact + ", state=" + state + ", city=" + city
				+ ", district=" + district + "]";
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

}
