package com.sapient.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.ecom.model.OrderDetails;
import com.sapient.ecom.service.OrderService;

@RestController
@RequestMapping("/orderDetails")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/byId/{id}")
	public OrderDetails getOrderDetails(@PathVariable String id) {
		return orderService.getOrderDetails(id);
	}

	@RequestMapping("/getAll")
	public List<OrderDetails> getAllOrderDetails() {
		return orderService.getAllOrderDetails();
	}

	@RequestMapping(value = "/confirmOrder", method = RequestMethod.POST)
	public void confirmOrder(OrderDetails orderDetails) {
		orderService.confirmOrder(orderDetails);
	}

	@RequestMapping(value = "/cancelOrder/{id}", method = RequestMethod.PUT)
	public void cancelOrder(@PathVariable String orderId) {
		orderService.cancelOrder(orderId);
	}

}
