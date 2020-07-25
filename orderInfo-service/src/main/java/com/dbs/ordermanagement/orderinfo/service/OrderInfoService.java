package com.dbs.ordermanagement.orderinfo.service;

import java.util.List;

import com.dbs.ordermanagement.orderinfo.dto.OrderInfoReq;
import com.dbs.ordermanagement.orderinfo.dto.OrderInfoRes;

public interface OrderInfoService {
	
	OrderInfoRes save(OrderInfoReq itemOrder);

	List<OrderInfoRes> findAllCustomersInfo();

	OrderInfoRes findByCustomerName(String productName);

}
