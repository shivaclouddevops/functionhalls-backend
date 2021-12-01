
package com.vedika.functionhall.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "functionhall_reference_data")
public class Owner {
	@Id
	private String id;
	private String name;

	private String firstName;

	private String lastName;
	private String functionhallname;
	private String city;

	private String state;

	private String zipcode;
	private String ownerContactNumber;

	/* db ref */

	private List<FunctionHall> functionhall;

   private List<AccountDetails> accountdetails;
	
	public List<AccountDetails> getAccountdetails() {
	return accountdetails;
}

public void setAccountdetails(List<AccountDetails> accountdetails) {
	this.accountdetails = accountdetails;
}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFunctionhallname() {
		return functionhallname;
	}

	public void setFunctionhallname(String functionhallname) {
		this.functionhallname = functionhallname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getOwnerContactNumber() {
		return ownerContactNumber;
	}

	public void setOwnerContactNumber(String ownerContactNumber) {
		this.ownerContactNumber = ownerContactNumber;
	}

	public List<FunctionHall> getFunctionhall() {
		return functionhall;
	}

	public void setFunctionhall(List<FunctionHall> functionhall) {
		this.functionhall = functionhall;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", functionhallname=" + functionhallname + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + ", ownerContactNumber=" + ownerContactNumber + ",  functionhall=" + functionhall + "]";
	}

}