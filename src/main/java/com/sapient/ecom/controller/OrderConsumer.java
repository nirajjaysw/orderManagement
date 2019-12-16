package com.sapient.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.sapient.ecom.model.OrderDetails;
import com.sapient.ecom.service.OrderService;

@Service
public class OrderConsumer {

	
	@Autowired
	private OrderService orderService;
	
	@KafkaListener(topics = "order_id" , groupId = "byId")
	//@RequestMapping("/byId/{id}")
	public OrderDetails getOrderDetails(String id) {
		return orderService.getOrderDetails(id);
	}
	
	@KafkaListener(topics = "order_getAll" , groupId = "getAll")
	//@RequestMapping("/getAll")
	public List<OrderDetails> getAllOrderDetails() {
		return orderService.getAllOrderDetails();
	}

	@KafkaListener(topics = "order_confirmOrder" , groupId = "confirmOrder")
	//@RequestMapping(value = "/confirmOrder", method = RequestMethod.POST)
	public void confirmOrder(OrderDetails orderDetails) {
		orderService.confirmOrder(orderDetails);
	}

	@KafkaListener(topics = "order_orderId" , groupId = "orderId")
	//@RequestMapping(value = "/cancelOrder/{id}", method = RequestMethod.PUT)
	public void cancelOrder(String orderId) {
		orderService.cancelOrder(orderId);
	}
}
