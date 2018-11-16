package com.ojolali.isale.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojolali.isale.dao.OrderDao;
import com.ojolali.isale.model.Order;

@RestController
@RequestMapping("/api")
public class OrderService {
	
	
	
	private final Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	@Autowired
	private OrderDao orderDao;
	
	@RequestMapping(value="createOrder", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Order> create(@RequestBody Order order) {
		logger.info("Create Order");
		orderDao.save(order);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

	
}
