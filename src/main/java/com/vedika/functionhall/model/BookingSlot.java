package com.vedika.functionhall.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "booking_slot")

public class BookingSlot {
	@Id
 private String id;
	private String date;
	private String timeSlot;

	

	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}


public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}



@Override
public String toString() {
	return "BookingSlot [id=" + id + ", date=" + date + ", timeSlot=" + timeSlot + "]";
}

 
}
