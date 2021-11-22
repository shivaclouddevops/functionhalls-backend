package com.vedika.functionhall.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;

public class FunctionHall {
	@Id
	private String id;
	private String name;
	private String ownerId;
	private String ownerFirstName;
	private String ownerLastName;
	private String functionhalldescription;
	private String functionhalltype;
	private String foodtype;
	private int maximumguest;
	private String roomtype;
	private String functionhallContactNumber;
	private String streetAddress;
	private String state;
	private String country;
	private String city;
	private String zipCode;
	private List<String> amenities;
	private List<String> eventType;
	
	

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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	private String email;
	private String[] imageUrl;
	private LocalDate date;
	private LocalTime timeSlot;
	private String Bookedby;
	private String bucketName;
	private String imageDirectoryPath;
	private String correlationid;

	
	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(LocalTime timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getBookedby() {
		return Bookedby;
	}

	public void setBookedby(String bookedby) {
		Bookedby = bookedby;
	}

	public String getFoodtype() {
		return foodtype;
	}

	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}

	public String[] getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String[] imageUrl) {
		this.imageUrl = imageUrl;
	}

	
	public FunctionHall() {
	}

	public String getFunctionhallContactNumber() {
		return functionhallContactNumber;
	}

	public void setFunctionhallContactNumber(String functionhallContactNumber) {
		this.functionhallContactNumber = functionhallContactNumber;
	}

	public FunctionHall(String id, String name, String ownerId, String ownerFirstName, String ownerLastName,
			String functionhallContactNumber, String street, String state, String city,  String email,
			String bucketName, String imageDirectoryPath, String imageUrl, String correlationid) {
		super();
		this.id = id;
		this.name = name;
		this.ownerId = ownerId;
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
		this.functionhallContactNumber = functionhallContactNumber;
		this.state = state;
		this.email = email;
		this.bucketName = bucketName;
		this.imageDirectoryPath = imageDirectoryPath;

		this.correlationid = correlationid;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
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

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getImageDirectoryPath() {
		return imageDirectoryPath;
	}

	public void setImageDirectoryPath(String imageDirectoryPath) {
		this.imageDirectoryPath = imageDirectoryPath;
	}

	public String getFunctionhalldescription() {
		return functionhalldescription;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCorrelationid() {
		return correlationid;
	}

	public void setCorrelationid(String correlationid) {
		this.correlationid = correlationid;
	}

	@Override
	public String toString() {
		return "FunctionHall [id=" + id + ", name=" + name + ", ownerId=" + ownerId + ", ownerFirstName="
				+ ownerFirstName + ", ownerLastName=" + ownerLastName + ", functionhalldescription="
				+ functionhalldescription + ", functionhalltype=" + functionhalltype + ", foodtype=" + foodtype
				+ ", maximumguest=" + maximumguest + ", roomtype=" + roomtype + ", functionhallContactNumber="
				+ functionhallContactNumber + ", streetAddress=" + streetAddress + ", state=" + state + ", country="
				+ country + ", city=" + city + ", zipCode=" + zipCode + ", email=" + email + ", imageUrl="
				+ Arrays.toString(imageUrl) + ", date=" + date + ", timeSlot=" + timeSlot + ", Bookedby=" + Bookedby
				+ ", bucketName=" + bucketName + ", imageDirectoryPath=" + imageDirectoryPath + ", correlationid="
				+ correlationid + "]";
	}	

}