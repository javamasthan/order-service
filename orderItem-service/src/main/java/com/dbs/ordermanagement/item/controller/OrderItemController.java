package com.dbs.ordermanagement.item.controller;

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

import com.dbs.ordermanagement.item.dto.ItemOrderReq;
import com.dbs.ordermanagement.item.dto.ItemOrderRes;
import com.dbs.ordermanagement.item.exception.CustomErrorMessage;
import com.dbs.ordermanagement.item.exception.DataBaseException;
import com.dbs.ordermanagement.item.exception.OrderDetailsException;
import com.dbs.ordermanagement.item.service.ItemOrderService;

@RestController
public class OrderItemController {

	private static final Logger log = LoggerFactory.getLogger(OrderItemController.class);
	@Autowired
	private ItemOrderService itemOrderService;

	@PostMapping(value = "/create")
	public ResponseEntity<ItemOrderRes> createOrderItem(@Valid @RequestBody ItemOrderReq itemOrder) throws Exception {
		log.info("[************createOrderItem metnod begins...****************]");
		ItemOrderRes createdItemOrder = null;
		this.validateOrderItemRequest(itemOrder);
		try {
			ItemOrderRes isProductExist = itemOrderService.checkProduct(itemOrder.getProductName());
			if (isProductExist == null) {
				createdItemOrder = itemOrderService.save(itemOrder);
			} else {
				log.error("[************checkProduct metnod error...****************]");
				CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.BAD_REQUEST,
						"Product Order Alreay Exist PLease provide Differnt Product Name !!! : "
								+ isProductExist.getProductName());
				throw new OrderDetailsException(errorMsg);
			}
		} catch (DataBaseException exception) {
			CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.NOT_FOUND,
					" DataBase is Down or Connection Error !!! : ");
			throw new DataBaseException(errorMsg);
		}
		log.info("[************createOrderItem metnod end...****************]");
		return ResponseEntity.ok(createdItemOrder);
	}

	@GetMapping(value = "/allItemOrders")
	public ResponseEntity<List<ItemOrderRes>> getAllItemOrders() {
		log.info("[************getAllItemOrders metnod starts...****************]");
		List<ItemOrderRes> listOrders = itemOrderService.findAllOrders();
		log.info("[************getAllItemOrders metnod ends...****************]");
		return ResponseEntity.ok(listOrders);
	}
	
	public void validateOrderItemRequest(ItemOrderReq itemOrder) {
		if (itemOrder != null) {
			if (itemOrder.getProductName() == null) {
				CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.BAD_REQUEST,
						"Please Provide Product Name!!!");
				throw new OrderDetailsException(errorMsg);
			} else if (itemOrder.getProductName().isEmpty()) {
				CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.BAD_REQUEST,
						"Please Provide Product Name is Not Empty!!!");
				throw new OrderDetailsException(errorMsg);
			} else if (itemOrder.getProductCode() == null) {
				CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.BAD_REQUEST,
						"Please Provide Product Code!!!");
				throw new OrderDetailsException(errorMsg);
			} else if (itemOrder.getProductCode().isEmpty()) {
				CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.BAD_REQUEST,
						"Please Provide Product Code is not Empty!!!");
				throw new OrderDetailsException(errorMsg);
			} else if (itemOrder.getQuantity() == 0) {
				CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.BAD_REQUEST,
						"Please Provide Product Quantity at least 1 !!!");
				throw new OrderDetailsException(errorMsg);
			}

		} else {
			CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.BAD_REQUEST,
					"Please Provide Item Order Details!!!");
			throw new OrderDetailsException(errorMsg);
		}
	}

}
