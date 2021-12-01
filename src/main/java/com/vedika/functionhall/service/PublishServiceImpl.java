package com.vedika.functionhall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedika.functionhall.model.AccountDetails;
import com.vedika.functionhall.model.FunctionHall;
import com.vedika.functionhall.model.Owner;
import com.vedika.functionhall.model.PublishDetails;
import com.vedika.functionhall.repository.PublishRepo;

@Service
public class PublishServiceImpl implements PublishService {
	@Autowired
	private PublishRepo publishRepo;

	@Override
	public Owner saveOrUpdatepublishListing(PublishDetails publishdetails, Owner owner)
			throws IllegalArgumentException {

		owner.setId(publishdetails.getOwnerId());
		com.vedika.functionhall.model.Location location = publishdetails.getLocation();
		FunctionHall functionhalldata = publishdetails.getDetails();
		AccountDetails accountdetails = publishdetails.getAccountDetails();
		List<FunctionHall> functionhalllist = new ArrayList<FunctionHall>();
		List<AccountDetails> accountdetailslist = new ArrayList<AccountDetails>();

		if (null != functionhalldata && null != accountdetails && null != location) {
			FunctionHall functionhall = new FunctionHall();
			AccountDetails accountdata = new AccountDetails();
			functionhall.setCity(location.getCity());
			functionhall.setState(location.getState());
			functionhall.setStreetAddress(location.getStreetAddress());
			functionhall.setZipCode(location.getZipCode());
			functionhall.setCountry(location.getCountry());
			functionhall.setName(functionhalldata.getName());
			functionhall.setFunctionhalldescription(functionhalldata.getFunctionhalldescription());
			functionhall.setFoodtype(functionhalldata.getFoodtype());
			functionhall.setRoomtype(functionhalldata.getRoomtype());
			functionhall.setRoomtype(functionhalldata.getRoomtype());
			functionhall.setMaximumguest(functionhalldata.getMaximumguest());
			functionhall.setImageUrl(functionhalldata.getImageUrl());
			functionhall.setAmenities(functionhalldata.getAmenities());
			functionhall.setEventType(functionhalldata.getEventType());
			accountdata.setAccountName(accountdetails.getAccountName());
			accountdata.setAccountNumber(accountdetails.getAccountNumber());
			accountdata.setAccountType(accountdetails.getAccountType());
			accountdata.setBankName(accountdetails.getBankName());
			accountdata.setBranchName(accountdetails.getBranchName());
			accountdata.setIfscCode(accountdetails.getIfscCode());
			accountdata.setPanNumber(accountdetails.getPanNumber());
			functionhalllist.add(functionhall);
			accountdetailslist.add(accountdata);
		}
		owner.setFunctionhall(functionhalllist);
		owner.setAccountdetails(accountdetailslist);
		return publishRepo.save(owner);
	}

	/*
	 * @Override public List<PublishDetails> getAllPublishDetails() { // TODO
	 * Auto-generated method stub return publishRepo.findAll(); }
	 */
	/*
	 * if (publishdetails.getOwnerId() == null ||
	 * publishdetails.getOwnerId().isEmpty()) {
	 * 
	 * throw new IllegalArgumentException("The OwnerId should not be null."); } if
	 * (publishdetails.getCorrelationid() == null ||
	 * publishdetails.getCorrelationid().isEmpty()) { throw new
	 * IllegalArgumentException("correlationid should not be null"); } if
	 * (publishdetails.getLocation() == null) { throw new
	 * IllegalArgumentException("locationDetails should not be null"); }
	 * 
	 * 
	 * if (location.getStreetAddress() == null ||
	 * location.getStreetAddress().isEmpty()) {
	 * 
	 * throw new IllegalArgumentException("Please specify valid address"); }
	 * 
	 * FunctionHall functionhall=publishdetails.getDetails(); if
	 * (publishdetails.getDetails()==null) {
	 * 
	 * throw new IllegalArgumentException("publishDetails should not be null"); } /*
	 * if (functionhall.getOwnerFirstName()==null||functionhall.getOwnerFirstName().
	 * isEmpty()) {
	 * 
	 * throw new IllegalArgumentException("Please specify valid firstname"); }
	 */
	/*
	 * if (functionhall.getOwnerLastName()==null||functionhall.getOwnerLastName().
	 * isEmpty()) {
	 * 
	 * throw new IllegalArgumentException("Please specify valid lastname"); }
	 */
	/*
	 * if (functionhall.getCity()==null||functionhall.getCity().isEmpty()) {
	 * 
	 * throw new IllegalArgumentException("Please specify valid city"); } if
	 * (functionhall.getImageUrl()==null) {
	 * 
	 * throw new IllegalArgumentException("Please specify valid imageUrl"); }
	 * AccountDetails accountdetails=publishdetails.getPaymentDetails(); if
	 * (accountdetails.getAccountName()==null||accountdetails.getAccountName().
	 * isEmpty()) {
	 * 
	 * throw new IllegalArgumentException("Please specify valid Accountname"); } if
	 * (accountdetails.getAccountNumber()==null||accountdetails.getAccountNumber().
	 * isEmpty()) {
	 * 
	 * throw new IllegalArgumentException("Please specify valid AccountNumber"); }
	 * if (accountdetails.getAccountType()==null||accountdetails.getAccountType().
	 * isEmpty()) {
	 * 
	 * throw new IllegalArgumentException("Please specify valid AccountType"); } if
	 * (accountdetails.getPanNumber()==null||accountdetails.getPanNumber().isEmpty()
	 * ) {
	 * 
	 * throw new IllegalArgumentException("Please specify valid PanNumber"); }
	 * 
	 */
}
