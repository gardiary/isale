package com.ojolali.isale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojolali.isale.dao.UserDao;
import com.ojolali.isale.model.User;

@RestController
public class ApiController {
	
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="api/inserUser", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User getDate() {
		User user=new User();
		user.setUsername("Test");
		userDao.save(user);
		return user;
	}

	
}
