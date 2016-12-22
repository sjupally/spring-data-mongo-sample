package com.mongo.sample.dao;

import com.mongo.sample.model.Website;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WebsiteDao extends MongoRepository<Website, String> {


}
