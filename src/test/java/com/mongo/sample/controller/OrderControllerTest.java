package com.mongo.sample.controller;

import com.mongo.sample.model.Order;
import com.mongo.sample.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;

/**
 * Created by srikanth on 22/12/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    @Test
    public void saveOrder() throws Exception {
        Order order = new Order();
        Mockito.doNothing().when(orderService).saveOrder(order);
        orderController.saveOrder(order);
        Mockito.verify(orderService, times(1)).saveOrder(order);
    }

    @Test
    public void getAllOrders() throws Exception {
        List<Order> list = new ArrayList<>();
        Order order = new Order();
        order.set_id(123L);
        list.add(order);
        order = new Order();
        order.set_id(124L);
        list.add(order);
        Mockito.when(orderService.getAllOrders()).thenReturn(list);
        List orderList = orderController.getAllOrders();
        Mockito.verify(orderService, times(1)).getAllOrders();
        assertEquals(orderList.size(), 2);
    }

    @Test
    public void getByOrderId() throws Exception {
        Order order = new Order();
        order.set_id(123L);
        Mockito.when(orderService.getByOrderId(any())).thenReturn(order);
        Order orderResponse = orderController.getByOrderId(123L);
        Mockito.verify(orderService, times(1)).getByOrderId(123L);
    }

}