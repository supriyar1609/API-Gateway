package com.globallogic.dto;

import lombok.Data;

@Data
public class OrderDto {
 
	int orderId;
	double orderPrice;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	
	
}
