package com.vedika.functionhall.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

@Service
public class AmazonClient {

	private AmazonS3 s3client;

	@Value("${amazonProperties.endpointUrl}")
	private String endpointUrl;
	@Value("${amazonProperties.bucketName}")
	private String bucketName;
	@Value("${amazonProperties.accessKey}")
	private String accessKey;
	@Value("${amazonProperties.secretKey}")
	private String secretKey;

	@SuppressWarnings("deprecation")
	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
		this.s3client = new AmazonS3Client(credentials);
	}

	public String uploadFile(MultipartFile multipartFile, String corelationid) throws FileNotFoundException {
		String imageUrl = "";

		try {
			File file = convertMultiPartToFile(multipartFile, corelationid);
			String fileName = generateFileName(multipartFile);
			imageUrl = endpointUrl + "/" + bucketName + "/" + fileName;
			uploadFileTos3bucket(fileName, file);
			file.delete();

		} catch (Exception e) {
			e.printStackTrace();
			throw new FileNotFoundException(" Exception: necessary file was not present");
		}
		return imageUrl;

	}

	private File convertMultiPartToFile(MultipartFile file, String corelationid) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

	private String generateFileName(MultipartFile multiPart) {
		return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
	}

	private void uploadFileTos3bucket(String fileName, File file) {

		s3client.putObject(
				new PutObjectRequest(bucketName, fileName, file).withCannedAcl(CannedAccessControlList.PublicRead));

	}

}
