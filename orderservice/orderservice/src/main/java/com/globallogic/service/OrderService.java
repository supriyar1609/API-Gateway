package com.globallogic.service;

import java.util.List;

import com.globallogic.dto.OrderDto;

public interface OrderService {

	OrderDto addOrder(OrderDto orderDto);
	List<OrderDto> getAllOrders();
	OrderDto getOrderById(int orderId);
	void deleteOrder(int orderId);
	OrderDto updataOrder(OrderDto orderDto);
}
