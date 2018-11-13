package com.ojolali.isale.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ojolali.isale.model.Cart;


@Repository
public interface CartDao extends PagingAndSortingRepository<Cart, String>{
    
}
