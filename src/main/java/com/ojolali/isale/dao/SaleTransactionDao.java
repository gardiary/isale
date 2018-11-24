package com.ojolali.isale.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ojolali.isale.model.SaleTransaction;


@Repository
public interface SaleTransactionDao extends PagingAndSortingRepository<SaleTransaction, String>{
    
}
