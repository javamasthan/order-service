package com.dbs.ordermanagement.orderinfo.utill;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.dbs.ordermanagement.orderinfo.dto.OrderInfoReq;
import com.dbs.ordermanagement.orderinfo.dto.OrderInfoRes;
import com.dbs.ordermanagement.orderinfo.entity.OrderInfo;

public class OrderInfoUtility {

	public static OrderInfo dtoToEntity(OrderInfoReq orderInfoDto) {
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setCustomerName(orderInfoDto.getCustomerName());
		orderInfo.setShippingAddress(orderInfoDto.getShippingAddress());
		orderInfo.setTotal(orderInfoDto.getTotal());
		orderInfo.setOrderItems(orderInfoDto.getOrderItem());
		orderInfo.setOrderedDate(OrderInfoUtility.stringToDateConversion(orderInfoDto.getOrderDate()));
		return orderInfo;

	}

	public static OrderInfoRes entityToDto(OrderInfo orderEntity) {
		OrderInfoRes orderInfo = null;
		if (orderEntity != null) {
			orderInfo = new OrderInfoRes();
			orderInfo.setCustomerName(orderEntity.getCustomerName());
			orderInfo.setShippingAddress(orderEntity.getShippingAddress());
			orderInfo.setTotal(orderEntity.getTotal());
			orderInfo.setOrderItem(orderEntity.getOrderItems());
			orderInfo.setId(orderEntity.getId());
			orderInfo.setOrderDate(OrderInfoUtility.DateToString(orderEntity.getOrderedDate()));
		}
		return orderInfo;

	}
	
	public static List<OrderInfoRes> entityToDto(List<OrderInfo> listOfItemOrders) {
		List<OrderInfoRes> listRes=new ArrayList<OrderInfoRes>();
		if(listOfItemOrders!=null && listOfItemOrders.size()>0) {
			listOfItemOrders.forEach(itemOrder->{
				OrderInfoRes orderInfo = new OrderInfoRes();
				orderInfo.setCustomerName(itemOrder.getCustomerName());
				orderInfo.setShippingAddress(itemOrder.getShippingAddress());
				orderInfo.setTotal(itemOrder.getTotal());
				orderInfo.setOrderItem(itemOrder.getOrderItems());
				orderInfo.setId(itemOrder.getId());
				orderInfo.setOrderDate(OrderInfoUtility.DateToString(itemOrder.getOrderedDate()));
				listRes.add(orderInfo);
			});	
		}
		
		return listRes;	
	}
	
	public static Date stringToDateConversion(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate dateTime = LocalDate.parse(date, formatter);
		return Date.valueOf(dateTime);
		
	}
	
	public static String DateToString(Date date) {
		return date.toLocaleString();
	}

}
