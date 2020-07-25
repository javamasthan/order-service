package com.dbs.ordermanagement.orderinfo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.ordermanagement.orderinfo.dto.OrderInfoReq;
import com.dbs.ordermanagement.orderinfo.dto.OrderInfoRes;
import com.dbs.ordermanagement.orderinfo.entity.OrderInfo;
import com.dbs.ordermanagement.orderinfo.exception.CustomErrorMessage;
import com.dbs.ordermanagement.orderinfo.exception.DateConverstionException;
import com.dbs.ordermanagement.orderinfo.exception.OrderDetailsException;
import com.dbs.ordermanagement.orderinfo.service.OrderInfoService;
import com.dbs.ordermanagement.orderinfo.utill.OrderInfoUtility;

@RestController
public class OrderInfoController {
	private static final Logger log = LoggerFactory.getLogger(OrderInfoController.class);

	@Autowired
	private OrderInfoService orderInfoService;
	
	@PostMapping(value = "/create")
	public ResponseEntity<OrderInfoRes> createItem(@Valid @RequestBody OrderInfoReq itemOrder) throws Exception {
		log.info("[************createItem metnod begins...****************]");
		OrderInfoRes createdItemOrder = null;
		this.validateOrderInfoRequest(itemOrder);
		OrderInfoRes isOrderExist = orderInfoService.findByCustomerName(itemOrder.getCustomerName());
		if (isOrderExist == null) {
			createdItemOrder = orderInfoService.save(itemOrder);
		} else {
			log.error("[********** findByCustomerName method error ****************]");
			CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.BAD_REQUEST,
					"Order Info Alreay Exist PLease provide Differnt Customer Name !!! : "+isOrderExist.getCustomerName());
			throw new OrderDetailsException(errorMsg);
		}
		log.info("[**************createItem metnod end...************]");
		return ResponseEntity.ok(createdItemOrder);
	}

	@GetMapping(value = "/allCustomerInfo")
	public ResponseEntity<List<OrderInfoRes>> getAllItemOrders() {
		log.info("[**************getAllItemOrders metnod begin...************]");
		List<OrderInfoRes> listOrders = orderInfoService.findAllCustomersInfo();
		log.info("[**************getAllItemOrders metnod end...************]");
		return ResponseEntity.ok(listOrders);
	}
	
	public void validateOrderInfoRequest(OrderInfoReq itemOrder) {
		if (itemOrder != null) {
			if (itemOrder.getCustomerName() == null ) {
				CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.BAD_REQUEST,
						"Please Provide Customer Name!!!");
				throw new OrderDetailsException(errorMsg);
			} else if(itemOrder.getCustomerName().isEmpty()) {
				CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.BAD_REQUEST,
						"Please Provide Customer Name is Not Empty!!!");
				throw new OrderDetailsException(errorMsg);
			}
			else if (itemOrder.getShippingAddress() == null) {
				CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.BAD_REQUEST,
						"Please Provide Shipping Address!!!");
				throw new OrderDetailsException(errorMsg);
			} else if(itemOrder.getShippingAddress().isEmpty()) {
				CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.BAD_REQUEST,
						"Please Provide Shipping Address is not Empty!!!");
				throw new OrderDetailsException(errorMsg);	
			}
			else if (itemOrder.getOrderItem() == 0) {
				CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.BAD_REQUEST,
						"Please Provide order Item at least 1 !!!");
				throw new OrderDetailsException(errorMsg);
			}else if (itemOrder.getTotal()== 0) {
				CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.BAD_REQUEST,
						"Please Provide Total Amount Required !!!");
				throw new OrderDetailsException(errorMsg);
			}else if (itemOrder.getOrderDate()==null) {
				CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.BAD_REQUEST,
						"Please Provide Date MM/dd/yyyy !!!");
				throw new OrderDetailsException(errorMsg);
			}
			else if (itemOrder.getOrderDate().isEmpty()) {
				CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.BAD_REQUEST,
						"Please Provide MM/dd/yyyy format Date is not Empty!!!");
				throw new OrderDetailsException(errorMsg);
			}

		} else {
			CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.BAD_REQUEST,
					"Please Provide Item Order Details!!!");
			throw new OrderDetailsException(errorMsg);
		}

	}

}
