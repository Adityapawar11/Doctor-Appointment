package com.request.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.request.model.Request;

public interface RequestRepository extends MongoRepository<Request, Integer> {
	

}
