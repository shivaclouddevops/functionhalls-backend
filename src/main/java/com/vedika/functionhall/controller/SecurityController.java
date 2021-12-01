package com.vedika.functionhall.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vedika.functionhall.model.ResponseObject;
import com.vedika.functionhall.service.OwnerService;

@RestController
@RequestMapping("/api")
public class SecurityController {
	@Autowired
	private OwnerService ownerService;

	@RequestMapping(value = "/user/verification", method = RequestMethod.POST)
	public ResponseEntity<ResponseObject> sendOTP(@RequestParam String mobileNumber,
			@RequestBody ResponseObject response) {
		ResponseObject res = new ResponseObject();
		res.setRequestId(res.getRequestId());
		res.setMobileNumber(res.getMobileNumber());
		res.setMessage(res.getMessage());
		String twoFaCode = String.valueOf(new Random().nextInt(9999) + 1000);
		ownerService.send2FaCode(mobileNumber, twoFaCode);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "user/verification", method = RequestMethod.PUT)
	public ResponseEntity<Object> verify(@RequestParam String mobileNumber) {

		boolean isValid = true;

		if (isValid)
			return new ResponseEntity<>("otp verified successfully", HttpStatus.OK);

		return new ResponseEntity<>("otp is not verified", HttpStatus.FORBIDDEN);
	}
}
