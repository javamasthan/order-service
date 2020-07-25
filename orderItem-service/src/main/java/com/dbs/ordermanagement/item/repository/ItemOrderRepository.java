package com.dbs.ordermanagement.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.ordermanagement.item.entity.ItemOrder;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long> {
	List<ItemOrder> findAll();

	ItemOrder save(ItemOrder itemOrder);
	
	ItemOrder findByProductName(String productName);
	
	

}
