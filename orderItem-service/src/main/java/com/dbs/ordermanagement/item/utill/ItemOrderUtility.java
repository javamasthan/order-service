package com.dbs.ordermanagement.item.utill;

import java.util.ArrayList;
import java.util.List;

import com.dbs.ordermanagement.item.dto.ItemOrderReq;
import com.dbs.ordermanagement.item.dto.ItemOrderRes;
import com.dbs.ordermanagement.item.entity.ItemOrder;

public class ItemOrderUtility {
	
	
	
	public static ItemOrder dtoToEntity(ItemOrderReq itemOrderDto) {
		ItemOrder itmOrder=new ItemOrder();
			itmOrder.setProductCode(itemOrderDto.getProductCode());
			itmOrder.setProductName(itemOrderDto.getProductName());
			itmOrder.setQuantity(itemOrderDto.getQuantity());
			return itmOrder;
	}

	public static ItemOrderRes entityToDto(ItemOrder itemOrderEntity) {
		ItemOrderRes itmOrderRes=null;
		if(itemOrderEntity!=null) {
			itmOrderRes=new ItemOrderRes();
		itmOrderRes.setProductCode(itemOrderEntity.getProductCode());
		itmOrderRes.setProductName(itemOrderEntity.getProductName());
		itmOrderRes.setQuantity(itemOrderEntity.getQuantity());
		itmOrderRes.setId(itemOrderEntity.getId());
			
		}
		return itmOrderRes;
	}
	
	public static List<ItemOrderRes> entityToDto(List<ItemOrder> listOfItemOrders) {
		List<ItemOrderRes> listRes=new ArrayList<ItemOrderRes>();
		if(listOfItemOrders!=null && listOfItemOrders.size()>0) {
			listOfItemOrders.forEach(itemOrder->{
				ItemOrderRes itmOrderRes=new ItemOrderRes();
				itmOrderRes.setProductCode(itemOrder.getProductCode());
				itmOrderRes.setProductName(itemOrder.getProductName());
				itmOrderRes.setQuantity(itemOrder.getQuantity());
				itmOrderRes.setId(itemOrder.getId());
				listRes.add(itmOrderRes);
			});	
		}
		
		return listRes;	
	}
}
