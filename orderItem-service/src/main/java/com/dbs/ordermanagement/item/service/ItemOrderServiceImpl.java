package com.dbs.ordermanagement.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dbs.ordermanagement.item.dto.ItemOrderReq;
import com.dbs.ordermanagement.item.dto.ItemOrderRes;
import com.dbs.ordermanagement.item.exception.CustomErrorMessage;
import com.dbs.ordermanagement.item.exception.DataBaseException;
import com.dbs.ordermanagement.item.repository.ItemOrderRepository;
import com.dbs.ordermanagement.item.utill.ItemOrderUtility;
@Service
public class ItemOrderServiceImpl implements ItemOrderService {

	@Autowired
	private ItemOrderRepository itemOrderRepo;

	@Override
	public ItemOrderRes save(ItemOrderReq itemOrder) {
		ItemOrderRes itmOrder = null;
		try {
			
			itmOrder =ItemOrderUtility.entityToDto(itemOrderRepo.save(ItemOrderUtility.dtoToEntity(itemOrder)));
		} catch (Exception e) {
			CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.NOT_FOUND,
					" DataBase is Down or Connection Error !!! : ");
				try {
					throw new DataBaseException(errorMsg);
				} catch (DataBaseException e1) {
					e1.printStackTrace();
				}
			
		}

		return itmOrder;
	}

	@Override
	public List<ItemOrderRes> findAllOrders() {
		List<ItemOrderRes> listOrders = null;
		try {
			listOrders = ItemOrderUtility.entityToDto(itemOrderRepo.findAll());
		} catch (Exception e) {
			CustomErrorMessage errorMsg = new CustomErrorMessage(HttpStatus.NOT_FOUND,
					" DataBase is Down or Connection Error !!! : ");
				try {
					throw new DataBaseException(errorMsg);
				} catch (DataBaseException e1) {
					e1.printStackTrace();
				}
		}

		return listOrders;
	}

	@Override
	public ItemOrderRes checkProduct(String productName) throws DataBaseException {
		
	return 	ItemOrderUtility.entityToDto(itemOrderRepo.findByProductName(productName));
		
		
	}

}
