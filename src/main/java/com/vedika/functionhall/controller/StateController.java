package com.vedika.functionhall.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vedika.functionhall.model.Details;
import com.vedika.functionhall.model.GenericResponse;
import com.vedika.functionhall.service.StateService;

@Controller
@RestController
@RequestMapping(value = "/api")
public class StateController {

	Logger logger = LoggerFactory.getLogger(StateController.class);

	@Autowired
	private StateService stateService;

	@GetMapping(value = "state/details")

	public ResponseEntity<GenericResponse<List<Details>>> response(
			@RequestParam(value = "country", required = false) String name) {
		List<Details> details = stateService.findByName(name);
		GenericResponse<List<Details>> response = new GenericResponse<List<Details>>();
		response.setData(details);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "city/details")

	public ResponseEntity<GenericResponse<List<Details>>> getstate(
			@RequestParam(value = "state", required = false) String name) {
		List<Details> details = stateService.findByStateName(name);
		GenericResponse<List<Details>> response = new GenericResponse<List<Details>>();
		response.setData(details);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
