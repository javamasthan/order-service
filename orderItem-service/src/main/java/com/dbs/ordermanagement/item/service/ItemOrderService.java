package com.dbs.ordermanagement.item.service;

import java.util.List;

import com.dbs.ordermanagement.item.dto.ItemOrderReq;
import com.dbs.ordermanagement.item.dto.ItemOrderRes;
import com.dbs.ordermanagement.item.exception.DataBaseException;

public interface ItemOrderService {
	
	ItemOrderRes save(ItemOrderReq itemOrder);

	List<ItemOrderRes> findAllOrders();

	ItemOrderRes checkProduct(String productName) throws DataBaseException;

}
