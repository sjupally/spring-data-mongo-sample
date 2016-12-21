package com.mongo.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.sample.dao.OrderDao;
import com.mongo.sample.model.Order;

@RestController
public class OrderController {


	@Autowired
	private OrderDao orderDao;

	@RequestMapping(value = "/placeOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Order saveOrder(@RequestBody Order order) {
		orderDao.insert(order);
		return order;
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Order> getByOrderId() {
		return orderDao.findAll();
	}
}
