package com.dbs.ordermanagement.orderinfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.ordermanagement.orderinfo.entity.OrderInfo;

@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {
	List<OrderInfo> findAll();

	OrderInfo save(OrderInfo itemOrder);
	
	OrderInfo findByCustomerName(String productName);
	
	

}
