package com.ojolali.isale.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ojolali.isale.model.Product;


@Repository
public interface ProductDao extends PagingAndSortingRepository<Product, String>{
    
}
