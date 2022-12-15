package com.globallogic.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.globallogic.dto.OrderDto;
import com.globallogic.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/addOrder")
	ResponseEntity<OrderDto> addOrder(OrderDto orderDto)
	{
		return new ResponseEntity<OrderDto>(orderService.addOrder(orderDto),HttpStatus.CREATED);
	}
	@GetMapping("/getOrder")
	ResponseEntity<List<OrderDto>> getAllOrder()
	{
		List<OrderDto> listOfOrder=orderService.getAllOrders();
		return new ResponseEntity<List<OrderDto>>(listOfOrder,HttpStatus.OK);
	}
	@GetMapping("/getOrder/{orderId}")
	ResponseEntity<OrderDto> getProduct(@PathVariable int orderId)
	{
		return new ResponseEntity<OrderDto>(orderService.getOrderById(orderId),HttpStatus.FOUND);
	}
	
	@PostMapping(value = "/orderAddProduct")
	public String addorderProduct() {
		return restTemplate.getForObject("http://PRODUCT-SERVICE/product/addProduct",String.class);
	}
	@GetMapping("/orderGetProduct")
	public String getorderProduct()
	{
		return restTemplate.getForObject("http://PRODUCT-SERVICE/product/getProduct",String.class);
	}
}
