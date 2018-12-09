package com.ojolali.isale.service;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojolali.isale.dao.OrderDao;
import com.ojolali.isale.model.Order;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "https://posclient.herokuapp.com/")
@RequestMapping("api")
public class OrderService {
	
	
	private final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
	
	@Autowired
	private OrderDao orderDao;




    @RequestMapping(value = "/orders", method = RequestMethod.POST, consumes = {"application/json"})
    public Order saveOrder(@RequestBody @Valid final Order order) {
        LOGGER.debug("Received request to create the {}", order);
        return orderDao.save(order);
    }

    @ApiOperation(value = "Retrieve a list of orders.",
            responseContainer = "List")
    @RequestMapping(value = "/orders", method = RequestMethod.GET, produces = {"application/json"})
    public Iterable<Order> listOrders() {
        LOGGER.debug("Received request to list all orders");
        return orderDao.findAll();
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    Order singleOrder(@PathVariable String id) {
        LOGGER.debug("Received request to list a specific order");
        Optional<Order> order= orderDao.findById(id);///(id);
        return order.orElse(null);
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable String id) {
        LOGGER.debug("Received request to delete a specific order");
        orderDao.deleteById(id);
    }

//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.CONFLICT)
//    public String handleUserAlreadyExistsException(OrderAlreadyExistsException e) {
//        return e.getMessage();
//    }

	
}
