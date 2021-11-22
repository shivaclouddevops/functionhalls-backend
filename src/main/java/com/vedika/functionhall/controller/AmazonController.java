package com.vedika.functionhall.controller;

import java.io.IOException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vedika.functionhall.model.Amazonresponse;
import com.vedika.functionhall.model.GenericResponse;
import com.vedika.functionhall.service.AmazonClient;
import com.vedika.functionhall.service.OwnerService;

@RestController
@RequestMapping("/api")
public class AmazonController {

	private AmazonClient amazonClient;
	@Autowired
	private OwnerService ownerService;

	@Autowired
	AmazonController(AmazonClient amazonClient) {
		this.amazonClient = amazonClient;
	}

	@RequestMapping(value = "/image/", method = RequestMethod.POST)

	public ResponseEntity<GenericResponse<Amazonresponse>> image(@RequestParam(value = "file") MultipartFile file,
			String correlationid) throws IOException {

		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost("https://api.constantcontact.com/v2/library/files");
		httppost.addHeader("Content-type", "multipart/form-data");

		Amazonresponse response = new Amazonresponse();
		response.setMsg(" uploading request submitted successfully.");

		String imageUrl = amazonClient.uploadFile(file, correlationid);

		ownerService.update(correlationid, imageUrl);
		GenericResponse<Amazonresponse> responsedata = new GenericResponse<Amazonresponse>();
		responsedata.setData(response);

		return new ResponseEntity<GenericResponse<Amazonresponse>>(responsedata, HttpStatus.OK);
	}
}
