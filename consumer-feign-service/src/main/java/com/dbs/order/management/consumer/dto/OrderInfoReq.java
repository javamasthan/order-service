package com.dbs.order.management.consumer.dto;

import java.util.Date;

public class OrderInfoReq {
	
	private String customerName;
	private String shippingAddress;
	private double total;
	private int orderItem;
	private String orderDate;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(int orderItem) {
		this.orderItem = orderItem;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	
	
	
	
}
