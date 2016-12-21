package com.mongo.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.sample.model.User;

@RestController
public class HelloController {

	@Autowired
	private MongoOperations mongoTemplate;

	@RequestMapping("/get")
	public User index() {
		Query searchUserQuery = new Query(Criteria.where("username").is("mkyong"));

		// find the saved user again.
		User savedUser = mongoTemplate.findOne(searchUserQuery, User.class);

		return savedUser;
	}
}
