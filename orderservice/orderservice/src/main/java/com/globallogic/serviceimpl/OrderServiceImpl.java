package com.globallogic.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.dto.OrderDto;
import com.globallogic.modal.Order;
import com.globallogic.repository.OrderRepository;
import com.globallogic.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository repository;

	@Override
	public OrderDto addOrder(OrderDto orderDto) {
		Order order =new Order();
		order.setOrderid(orderDto.getOrderId());
		order.setOrderPrice(orderDto.getOrderPrice());
		repository.save(order);
		return orderDto;
	}

	@Override
	public List<OrderDto> getAllOrders() {
		List<OrderDto> responseList=new ArrayList<>();
		List<Order>  requestList=repository.findAll();
		for(Order order:requestList)
		{
			OrderDto orderDto=new OrderDto();
			orderDto.setOrderId(order.getOrderid());
			orderDto.setOrderPrice(order.getOrderPrice());
			responseList.add(orderDto);
		}
		return responseList;
	}

	@Override
	public OrderDto getOrderById(int orderId) {
		Order order=repository.findById(orderId).get();
		OrderDto orderDto=new OrderDto();
		orderDto.setOrderId(orderId);
		orderDto.setOrderPrice(order.getOrderPrice());
		return orderDto;
	}

	@Override
	public void deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderDto updataOrder(OrderDto OrderDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
