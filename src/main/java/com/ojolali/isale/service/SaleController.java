package com.ojolali.isale.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojolali.isale.dao.SaleTransactionDao;
import com.ojolali.isale.model.SaleTransaction;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "https://posclient.herokuapp.com/")
@RequestMapping("api/transactions")
public class SaleController {
	
	private final Logger logger = LoggerFactory.getLogger(SaleController.class);
	

	@Autowired
	private SaleTransactionDao saleTransactionDao;
	
	
//	@RequestMapping(value="", method = RequestMethod.GET, produces = {"application/json"})
//	public Iterable<Employee> getEmployee() {
//		logger.info("Get Employee");
//		Iterable<Employee>  employees=employeeDao.findAll();
//		return employees;
//	}


	
	@ApiOperation(value = "Retrieve a list of transaction.",
			responseContainer = "List")
	@RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Iterable<SaleTransaction> getSaleTransaction() {
		logger.info("Get SaleTransaction");
		Iterable<SaleTransaction>  saleTransaction=saleTransactionDao.findAll();
		return saleTransaction;
	}

	
	@RequestMapping(method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<SaleTransaction> create(@RequestBody SaleTransaction order) {
		logger.info("Create SaleTransaction");
		saleTransactionDao.save(order);
		return new ResponseEntity<SaleTransaction>(order, HttpStatus.OK);
	}
	
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    SaleTransaction singleOrder(@PathVariable String id) {
    	logger.debug("Received request to list a specific order");
        Optional<SaleTransaction> transaction= saleTransactionDao.findById(id);///(id);
        return transaction.orElse(null);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable String id) {
    	logger.debug("Received request to delete a specific order");
    	saleTransactionDao.deleteById(id);
    }



}
