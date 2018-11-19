package com.ojolali.isale.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojolali.isale.dao.EmployeeDao;
import com.ojolali.isale.model.Employee;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "https://posclient.herokuapp.com/")
public class ApiController {
	
	private final Logger logger = LoggerFactory.getLogger(ApiController.class);
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping(value="/list", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Iterable<Employee> getEmployee() {
		logger.info("Get Employee");
		Iterable<Employee>  employees=employeeDao.findAll();
		return employees;
	}

	
}
