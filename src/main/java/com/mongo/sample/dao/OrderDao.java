package com.mongo.sample.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.sample.model.Order;

@Repository
public interface OrderDao extends MongoRepository<Order, String> {


}
