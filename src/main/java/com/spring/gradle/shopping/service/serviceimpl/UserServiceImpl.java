package com.spring.gradle.shopping.service.serviceimpl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.gradle.shopping.dao.IUserDao;
import com.spring.gradle.shopping.entity.model.UserBean;
import com.spring.gradle.shopping.service.IUserService;

@Repository
public class UserServiceImpl implements IUserService {
	@Autowired
	IUserDao userDao;

	@Override
	public Serializable createUser(UserBean userBean) {
		Serializable id = userDao.createUser(userBean);
		return id;
	}

	@Override
	public UserBean findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}

}
