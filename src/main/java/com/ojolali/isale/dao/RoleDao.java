package com.ojolali.isale.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ojolali.isale.model.Role;


@Repository
public interface RoleDao extends PagingAndSortingRepository<Role, String>{
    
}
