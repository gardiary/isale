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
import com.ojolali.isale.dao.OrderDao;
import com.ojolali.isale.model.Employee;
import com.ojolali.isale.model.Order;
import com.ojolali.isale.model.OrderDto;

import io.swagger.annotations.ApiOperation;

@RestController
	@CrossOrigin(origins = "https://posclient.herokuapp.com/")
@RequestMapping("api")
public class OrderService {
	
	
	private final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
	
	@Autowired
	private OrderDao orderDao;


	@Autowired
	private EmployeeDao employeeDao;


	@PostMapping(value = "/orders",  consumes = {"application/json"})
    public Order saveOrder(@RequestBody @Valid final OrderDto orderdto) {
		LOGGER.debug("Received request to create the {}", orderdto);
		Order order=new Order();
		String employeId=orderdto.getEmployeeId();
		Optional<Employee> employee=null;
		try {
		employee = employeeDao.findById(employeId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			BeanUtils.copyProperties(order, orderdto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		order.setEmployee(employee.orElse(null));
         return orderDao.save(order);
    }

    @ApiOperation(value = "Retrieve a list of orders.",
            responseContainer = "List")
    @GetMapping(value = "/orders",  produces = {"application/json"})
    public Iterable<Order> listOrders() {
        LOGGER.debug("Received request to list all orders");
        return orderDao.findAll();
    }

    @GetMapping(value = "/orders/{id}",  produces = {"application/json"})
    public @ResponseBody
    Order singleOrder(@PathVariable String id) {
        LOGGER.debug("Received request to list a specific order");
        Optional<Order> order= orderDao.findById(id);
        return order.orElse(null);
    }

    @DeleteMapping(value = "/orders/{id}")
    public void deleteOrder(@PathVariable String id) {
        LOGGER.debug("Received request to delete a specific order");
        orderDao.deleteById(id);
    }
	
}
