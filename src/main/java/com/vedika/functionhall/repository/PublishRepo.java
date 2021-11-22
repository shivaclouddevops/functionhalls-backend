package com.vedika.functionhall.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vedika.functionhall.model.Owner;

@Repository
public interface PublishRepo extends MongoRepository<Owner, String> {

	@SuppressWarnings("unchecked")
	Owner save(Owner owner);

}
