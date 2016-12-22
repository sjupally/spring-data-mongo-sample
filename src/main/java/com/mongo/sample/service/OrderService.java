package com.mongo.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.MatcherConfigurer;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import static org.springframework.data.domain.ExampleMatcher.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.mongo.sample.dao.OrderDao;
import com.mongo.sample.model.Order;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;

	@Autowired
	private MongoOperations mongoTemplate;

	public void saveOrder(Order order) {
		orderDao.insert(order);
	}

	public List<Order> getAllOrders() {
		return orderDao.findAll();
	}

	public Order getByOrderId(Long orderId) {
		return mongoTemplate.findOne(query(where("_id").is(orderId)), Order.class);
	}
}
