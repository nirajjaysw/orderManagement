package com.sapient.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.ecom.doa.OrderRepository;
import com.sapient.ecom.model.OrderDetails;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	public OrderDetails getOrderDetails(String id) {
		return orderRepository.findById(id).get();
	}

	public List<OrderDetails> getAllOrderDetails() {
		return (List<OrderDetails>) orderRepository.findAll();
	}

	public Object confirmOrder(OrderDetails orderDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	public void cancelOrder(String orderId) {
		// TODO Auto-generated method stub
		
	}

}
