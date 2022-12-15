package com.globallogic.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "order_detail")
public class Order {

	@Id
	int orderid;
	double orderPrice;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public Order(int orderid, double orderPrice) {
		super();
		this.orderid = orderid;
		this.orderPrice = orderPrice;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
