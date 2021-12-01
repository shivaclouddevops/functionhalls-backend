package com.vedika.functionhall.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.MongoException;
import com.mongodb.client.result.UpdateResult;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.vedika.functionhall.config.TwilioConfiguration;
import com.vedika.functionhall.model.Owner;
import com.vedika.functionhall.repository.OwnerRepository;
import com.vedika.functionhall.service.OwnerService;

@Service("twilio")
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(OwnerServiceImpl.class);

	private final TwilioConfiguration twilioConfiguration;

	@Autowired
	public OwnerServiceImpl(TwilioConfiguration twilioConfiguration) {
		this.twilioConfiguration = twilioConfiguration;
	}

	public boolean send2FaCode(String mobileNumber, String twoFaCode) {

		Message.creator(new PhoneNumber(mobileNumber), new PhoneNumber(twilioConfiguration.getTrialNumber()),
				"Your Two Factor Authentication code is: " + twoFaCode).create();

		return true;

	}

	@Override
	public List<Owner> sendOTP(String mobileNumber) {
		return ownerRepository.sendOTP(mobileNumber);
	}

	@Override
	public List<Owner> findAll() {
		return ownerRepository.findAll();
	}

	@Override

	public Owner saveOrUpdateOwner(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public List<Owner> findFunctionHallByNameAndCity(String city, String name, String maximumguest) {
		return ownerRepository.findFunctionHallByNameAndCity(city, name, maximumguest);
	}

	@Override
	public void update(String correlationid, String imageUrl) throws FileNotFoundException, RuntimeException {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("functionhall.correlationid").is(correlationid));
			Owner ownerref = mongoTemplate.findOne(query, Owner.class);
			System.out.println(ownerref);
			UpdateResult update = mongoTemplate.updateMulti(query,
					new Update().addToSet("functionhall.$.imageUrl", imageUrl), Owner.class);
			System.out.println(update);
		} catch (MongoException e) {
			System.out.println("nessary file not present" + e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
