package com.dbs.order.management.consumer.feign.interfaces;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dbs.order.management.consumer.dto.ItemOrderReq;
import com.dbs.order.management.consumer.dto.ItemOrderRes;




@FeignClient(name="order-item-service",url="localhost:8081/item")
public interface ItemOrderFeign {
	@PostMapping(value = "/create")
	public ResponseEntity<ItemOrderRes> createItem(@Valid @RequestBody ItemOrderReq itemOrder) throws Exception;
	@GetMapping(value = "/allItemOrders")
	public ResponseEntity<List<ItemOrderRes>> getAllItemOrders();
}
