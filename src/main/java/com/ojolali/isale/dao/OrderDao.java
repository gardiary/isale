package com.ojolali.isale.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ojolali.isale.model.Order;


@Repository
public interface OrderDao extends PagingAndSortingRepository<Order, String>{
    
}
