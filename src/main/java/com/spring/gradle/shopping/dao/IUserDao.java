package com.spring.gradle.shopping.dao;

import java.io.Serializable;

import com.spring.gradle.shopping.entity.model.UserBean;

public interface IUserDao {
	public Serializable createUser(UserBean userBean);

	public UserBean findByUsername(String username);
}
