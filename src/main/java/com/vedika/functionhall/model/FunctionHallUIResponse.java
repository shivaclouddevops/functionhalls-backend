package com.vedika.functionhall.model;

import java.util.Arrays;
import java.util.List;

public class FunctionHallUIResponse {

	private String name;
	private String ownerFirstName;
	private String ownerLastName;
	private String ownerId;
	private String functionhalldescription;
	private String functionhalltype;
	private String foodtype;
	private int maximumguest;
	private String roomtype;
	private String ownerContactNumber;
	private String[] ImageUrl;
	private String street;
	private String state;
	private List<String> amenities;
	private List<String> eventType;

	private String correlationid;

	public String getFunctionhalldescription() {
		return functionhalldescription;
	}

	public List<String> getAmenities() {
		return amenities;
	}

	public void setAmenities(List<String> amenities) {
		this.amenities = amenities;
	}

	public List<String> getEventType() {
		return eventType;
	}

	public void setEventType(List<String> eventType) {
		this.eventType = eventType;
	}

	public void setFunctionhalldescription(String functionhalldescription) {
		this.functionhalldescription = functionhalldescription;
	}

	public String getFunctionhalltype() {
		return functionhalltype;
	}

	public void setFunctionhalltype(String functionhalltype) {
		this.functionhalltype = functionhalltype;
	}

	public String getFoodtype() {
		return foodtype;
	}

	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}

	public int getMaximumguest() {
		return maximumguest;
	}

	public void setMaximumguest(int maximumguest) {
		this.maximumguest = maximumguest;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getCorrelationid() {
		return correlationid;
	}

	public void setCorrelationid(String correlationid) {
		this.correlationid = correlationid;
	}

	private String city;
	private int zipcode;
	private String functionhallContactNumber;

	public String getOwnerContactNumber() {
		return ownerContactNumber;
	}

	public void setOwnerContactNumber(String ownerContactNumber) {
		this.ownerContactNumber = ownerContactNumber;
	}

	public String getFunctionhallContactNumber() {
		return functionhallContactNumber;
	}

	public void setFunctionhallContactNumber(String functionhallContactNumber) {
		this.functionhallContactNumber = functionhallContactNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String[] getImageUrl() {
		return ImageUrl;
	}

	public void setImageUrl(String[] imageUrl) {
		ImageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "FunctionHallUIResponse [name=" + name + ", ownerFirstName=" + ownerFirstName + ", ownerLastName="
				+ ownerLastName + ", ownerId=" + ownerId + ", functionhalldescription=" + functionhalldescription
				+ ", functionhalltype=" + functionhalltype + ", foodtype=" + foodtype + ", maximumguest=" + maximumguest
				+ ", roomtype=" + roomtype + ", ownerContactNumber=" + ownerContactNumber + ", ImageUrl="
				+ Arrays.toString(ImageUrl) + ", street=" + street + ", state=" + state + ", correlationid="
				+ correlationid + ", city=" + city + ", zipcode=" + zipcode + ", functionhallContactNumber="
				+ functionhallContactNumber + "]";
	}

}
