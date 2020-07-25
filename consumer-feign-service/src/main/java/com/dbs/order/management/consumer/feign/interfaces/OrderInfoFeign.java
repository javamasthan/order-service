package com.dbs.order.management.consumer.feign.interfaces;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dbs.order.management.consumer.dto.OrderInfoReq;
import com.dbs.order.management.consumer.dto.OrderInfoRes;



@FeignClient(name="order-info-service",url="localhost:8082/order")
public interface OrderInfoFeign {
	@PostMapping(value = "/create")
	public ResponseEntity<OrderInfoRes> createItem(@Valid @RequestBody OrderInfoReq itemOrder) throws Exception;
	
	@GetMapping(value = "/allCustomerInfo")
	public ResponseEntity<List<OrderInfoRes>> getAllItemOrders() ;

}
