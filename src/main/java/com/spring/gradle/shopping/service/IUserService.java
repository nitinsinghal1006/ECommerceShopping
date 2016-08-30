package com.spring.gradle.shopping.service;

import java.io.Serializable;

import com.spring.gradle.shopping.entity.model.UserBean;

public interface IUserService {
	public Serializable createUser(UserBean userBean);

	public UserBean findByUsername(String username);

}
