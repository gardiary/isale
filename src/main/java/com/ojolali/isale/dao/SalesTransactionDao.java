package com.ojolali.isale.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ojolali.isale.model.SalesTransaction;


@Repository
public interface SalesTransactionDao extends PagingAndSortingRepository<SalesTransaction, String>{
    
}
