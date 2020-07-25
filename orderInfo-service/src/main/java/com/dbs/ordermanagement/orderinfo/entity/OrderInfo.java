package com.dbs.ordermanagement.orderinfo.entity;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_info")
public class OrderInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "shipping_address")
	private String shippingAddress;
	@Column(name = "order_items")
	private int orderItems;
	@Column(name = "order_date")
	private Date orderedDate;
	@Column(name = "total")
	private double total;

	public OrderInfo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public int getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(int orderItems) {
		this.orderItems = orderItems;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	
}
