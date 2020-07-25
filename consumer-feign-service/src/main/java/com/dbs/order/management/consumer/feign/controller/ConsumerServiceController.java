package com.dbs.order.management.consumer.feign.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dbs.order.management.consumer.dto.ItemOrderReq;
import com.dbs.order.management.consumer.dto.ItemOrderRes;
import com.dbs.order.management.consumer.dto.OrderInfoReq;
import com.dbs.order.management.consumer.dto.OrderInfoRes;
import com.dbs.order.management.consumer.feign.interfaces.ItemOrderFeign;
import com.dbs.order.management.consumer.feign.interfaces.OrderInfoFeign;



@Controller
public class ConsumerServiceController {
	
	@Autowired
	private ItemOrderFeign itemOrderFeign;
	
	@Autowired
	private OrderInfoFeign orderInfoFeign;
	
	@PostMapping("/order/create")
	public ResponseEntity createOrder(@RequestBody ItemOrderReq orderReq) throws Exception {
		ResponseEntity<ItemOrderRes> res=itemOrderFeign.createItem(orderReq);
		return res;
		
	};
	
	@GetMapping("/order/allOrders")
	public ResponseEntity fetchAllOrders() throws Exception {
		ResponseEntity<List<ItemOrderRes>> res=itemOrderFeign.getAllItemOrders();
		return res;
		
	};
	
	
	@PostMapping("/orderInfo/create")
	public ResponseEntity createOrderInfo(@Valid @RequestBody OrderInfoReq itemOrder) throws Exception {
		ResponseEntity<OrderInfoRes> res=orderInfoFeign.createItem(itemOrder);
		return res;
		
	};
	
	@GetMapping("/orderInfo/allOrdersInfo")
	public ResponseEntity fetchAllOrderInfo() throws Exception {
		ResponseEntity<List<OrderInfoRes>> res=orderInfoFeign.getAllItemOrders();
		return res;
		
	};
	

}
