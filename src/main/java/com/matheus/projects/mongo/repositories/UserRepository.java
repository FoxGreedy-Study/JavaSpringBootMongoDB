package com.matheus.projects.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.matheus.projects.mongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	
	
}
