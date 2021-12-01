package com.vedika.functionhall.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vedika.functionhall.model.Owner;

@Service
public interface OwnerService {

	List<Owner> findAll();

	Owner saveOrUpdateOwner(Owner owner);

	List<Owner> findFunctionHallByNameAndCity(String city, String name, String maximumguest);

	void update(String correlationid, String imageUrl) throws FileNotFoundException, RuntimeException;

	List<Owner> sendOTP(String mobileNumber);

	boolean send2FaCode(String mobileNumber, String twoFaCode);

}