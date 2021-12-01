package com.vedika.functionhall.service;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;

import com.vedika.functionhall.model.Details;
import com.vedika.functionhall.model.States;

public interface StateService {

	List<Details> findByName(String name);

	List<Details> findByStateName(String name);

	List<Details> findAll();

}