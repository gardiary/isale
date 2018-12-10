package com.ojolali.isale.service;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojolali.isale.dao.EmployeeDao;
import com.ojolali.isale.model.Employee;
import com.ojolali.isale.model.EmployeeDto;

import io.swagger.annotations.ApiOperation;

@RestController
	@CrossOrigin(origins = "https://posclient.herokuapp.com/")
@RequestMapping("api/employees")
public class EmployeeService {
	
	
	private final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	

	@Autowired
	private EmployeeDao employeeDao;


	@PostMapping(  consumes = {"application/json"})
    public Employee saveEmployee(@RequestBody @Valid final EmployeeDto employeeDto) {
		LOGGER.debug("Received request to create the {}", employeeDto);
		Employee employee=new Employee();
		try {
			BeanUtils.copyProperties(employee, employeeDto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
         return employeeDao.save(employee);
    }

    @ApiOperation(value = "Retrieve a list of employees.",
            responseContainer = "List")
    @GetMapping(  produces = {"application/json"})
    public Iterable<Employee> listEmployees() {
        LOGGER.debug("Received request to list all employees");
        return employeeDao.findAll();
    }

    @GetMapping(value = "/{id}",  produces = {"application/json"})
    public @ResponseBody
    Employee singleEmployee(@PathVariable String id) {
        LOGGER.debug("Received request to list a specific employee");
        Optional<Employee> employee= employeeDao.findById(id);
        return employee.orElse(null);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEmployee(@PathVariable String id) {
        LOGGER.debug("Received request to delete a specific employee");
        employeeDao.deleteById(id);
    }
	
}
