package com.dbs.order.management.consumer.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages= {"com.dbs.order.management.consumer.feign.interfaces"})
public class ConsumerFeignServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerFeignServiceApplication.class, args);
	}

}
