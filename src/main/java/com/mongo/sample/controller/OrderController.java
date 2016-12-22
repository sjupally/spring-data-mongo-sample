package com.mongo.sample.controller;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.sample.model.Order;
import com.mongo.sample.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/placeOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Order saveOrder(@RequestBody Order order) {
		orderService.saveOrder(order);
		return order;
	}

	@RequestMapping(value = "/getAllOrders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@RequestMapping(value = "/getByOrderId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Order getByOrderId(@QueryParam("orderId") Long orderId) {
		return orderService.getByOrderId(orderId);
	}
}
