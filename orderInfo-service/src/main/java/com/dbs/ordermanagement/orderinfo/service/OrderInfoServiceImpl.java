package com.dbs.ordermanagement.orderinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dbs.ordermanagement.orderinfo.dto.OrderInfoReq;
import com.dbs.ordermanagement.orderinfo.dto.OrderInfoRes;
import com.dbs.ordermanagement.orderinfo.entity.OrderInfo;
import com.dbs.ordermanagement.orderinfo.exception.CustomErrorMessage;
import com.dbs.ordermanagement.orderinfo.exception.DataBaseException;
import com.dbs.ordermanagement.orderinfo.repository.OrderInfoRepository;
import com.dbs.ordermanagement.orderinfo.utill.OrderInfoUtility;
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

	@Autowired
	private OrderInfoRepository itemOrderRepo;

	@Override
	public OrderInfoRes save(OrderInfoReq customerOrderInfo) {
		OrderInfoRes orderInfo = OrderInfoUtility.entityToDto(itemOrderRepo.save(OrderInfoUtility.dtoToEntity(customerOrderInfo)));
		return orderInfo;
	}

	@Override
	public List<OrderInfoRes> findAllCustomersInfo() {
		List<OrderInfoRes> listOrders = OrderInfoUtility.entityToDto(itemOrderRepo.findAll());
		return listOrders;
	}

	@Override
	public OrderInfoRes findByCustomerName(String productName) {
	return 	OrderInfoUtility.entityToDto(itemOrderRepo.findByCustomerName(productName));		
	}

}
