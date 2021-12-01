package com.vedika.functionhall.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vedika.functionhall.model.FunctionHall;
import com.vedika.functionhall.model.FunctionHallUIResponse;
import com.vedika.functionhall.model.GenericResponse;
import com.vedika.functionhall.model.Owner;
import com.vedika.functionhall.service.OwnerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class OwnerController {
	Logger logger = LoggerFactory.getLogger(OwnerController.class);

	@Autowired
	private OwnerService ownerService;

	@RequestMapping(value = "/functionhalls/", method = RequestMethod.GET)
	public ResponseEntity<GenericResponse<List<FunctionHallUIResponse>>> getAllFunctionHalls() {

		List<Owner> functionhallOwners = ownerService.findAll();
		logger.info("findAll functionhalls");
		List<FunctionHallUIResponse> functionhallsUI = new ArrayList<FunctionHallUIResponse>();

		if (null != functionhallOwners && !functionhallOwners.isEmpty()) {
			for (Owner owner : functionhallOwners) {

				List<FunctionHall> funtionhalls = owner.getFunctionhall();

				if (null != funtionhalls && !funtionhalls.isEmpty()) {

					for (FunctionHall functionHall : funtionhalls) {

						FunctionHallUIResponse response = new FunctionHallUIResponse();

						response.setName(functionHall.getName());
						response.setOwnerFirstName(owner.getFirstName());
						response.setOwnerLastName(owner.getLastName());
						response.setOwnerId(owner.getId());
						response.setCity(functionHall.getCity());
						response.setStreet(functionHall.getStreetAddress());
						response.setFunctionhalldescription(functionHall.getFunctionhalldescription());
						response.setFunctionhalltype(functionHall.getFunctionhalltype());
						response.setMaximumguest(functionHall.getMaximumguest());
						response.setFoodtype(functionHall.getFoodtype());
						response.setRoomtype(functionHall.getRoomtype());
						response.setState(functionHall.getState());
						response.setCorrelationid(functionHall.getCorrelationid());
						response.setImageUrl(functionHall.getImageUrl());
						response.setFunctionhallContactNumber(functionHall.getFunctionhallContactNumber());
						response.setOwnerContactNumber(owner.getOwnerContactNumber());

						response.setAmenities(functionHall.getAmenities());
						response.setEventType(functionHall.getAmenities());

						functionhallsUI.add(response);
					}
				}
			}
		}

		GenericResponse<List<FunctionHallUIResponse>> response = new GenericResponse<List<FunctionHallUIResponse>>();
		response.setData(functionhallsUI);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/functionhallsBy/", method = RequestMethod.GET)

	public ResponseEntity<GenericResponse<List<FunctionHallUIResponse>>> findFunctionhallByNameAndCity(
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "maximumguest", required = false) String maximumguest) {

		List<Owner> functionhallOwners = ownerService.findFunctionHallByNameAndCity(city, name, maximumguest);
		logger.info("find by name:" + name);
		List<FunctionHallUIResponse> functionhallsUI = new ArrayList<FunctionHallUIResponse>();

		if (null != functionhallOwners && !functionhallOwners.isEmpty()) {
			for (Owner owner : functionhallOwners) {

				List<FunctionHall> funtionhalls = owner.getFunctionhall();

				if (null != funtionhalls && !funtionhalls.isEmpty()) {

					for (FunctionHall functionHall : funtionhalls) {

						FunctionHallUIResponse response = new FunctionHallUIResponse();
						response.setName(functionHall.getName());
						response.setOwnerFirstName(owner.getFirstName());
						response.setOwnerLastName(owner.getLastName());
						response.setOwnerId(owner.getId());
						response.setCity(functionHall.getCity());
						response.setStreet(functionHall.getStreetAddress());
						response.setFunctionhalldescription(functionHall.getFunctionhalldescription());
						response.setFunctionhalltype(functionHall.getFunctionhalltype());
						response.setMaximumguest(functionHall.getMaximumguest());
						response.setFoodtype(functionHall.getFoodtype());
						response.setRoomtype(functionHall.getRoomtype());
						response.setState(functionHall.getState());
						response.setImageUrl(functionHall.getImageUrl());
						response.setCorrelationid(functionHall.getCorrelationid());
						response.setFunctionhallContactNumber(functionHall.getFunctionhallContactNumber());
						response.setOwnerContactNumber(owner.getOwnerContactNumber());

						functionhallsUI.add(response);
					}
				}
			}

		}

		GenericResponse<List<FunctionHallUIResponse>> response = new GenericResponse<List<FunctionHallUIResponse>>();
		response.setData(functionhallsUI);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	// @RequestMapping(value="/updatefunctionhall" ,method=RequesMethod.PUT)

}
