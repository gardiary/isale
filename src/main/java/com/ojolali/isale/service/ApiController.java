package com.ojolali.isale.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojolali.isale.dao.EmployeeDao;
import com.ojolali.isale.dao.SaleTransactionDao;
import com.ojolali.isale.model.Employee;
import com.ojolali.isale.model.SaleTransaction;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://posclient.herokuapp.com/")
public class ApiController {
	
	private final Logger logger = LoggerFactory.getLogger(ApiController.class);
	
	@Autowired
	private EmployeeDao employeeDao;
	

	@Autowired
	private SaleTransactionDao saleTransactionDao;
	
	
	@RequestMapping(value="/employee/list", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Iterable<Employee> getEmployee() {
		logger.info("Get Employee");
		Iterable<Employee>  employees=employeeDao.findAll();
		return employees;
	}



	@RequestMapping(value="/transaction/list", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Iterable<SaleTransaction> getSaleTransaction() {
		logger.info("Get SaleTransaction");
		Iterable<SaleTransaction>  saleTransaction=saleTransactionDao.findAll();
		return saleTransaction;
	}

	
	@RequestMapping(value="/transaction/create", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<SaleTransaction> create(@RequestBody SaleTransaction order) {
		logger.info("Create SaleTransaction");
		saleTransactionDao.save(order);
		return new ResponseEntity<SaleTransaction>(order, HttpStatus.OK);
	}

}
