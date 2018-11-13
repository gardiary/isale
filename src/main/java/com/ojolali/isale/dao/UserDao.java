package com.ojolali.isale.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ojolali.isale.model.User;

public interface UserDao extends PagingAndSortingRepository<User, String>{

}
