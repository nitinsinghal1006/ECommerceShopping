package com.spring.gradle.shopping.service.serviceimpl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.gradle.shopping.entity.model.UserBean;
import com.spring.gradle.shopping.service.IUserService;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	IUserService iUserService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserBean userBean;
		// TODO Auto-generated method stub
		try {
			userBean = iUserService.findByUsername(username);
			// Cookie cookie = new Cookie("userId", userBean.getUserId() + "");
			// cookie.setMaxAge(0);
			// response.addCookie(cookie);
			System.out.println("Email Id: " + userBean.getEmailId());
			System.out.println("Password: " + userBean.getPassword());
		} catch (Exception e) {
			// TODO: handle exception
			throw new UsernameNotFoundException("Database error: " + e);
		}
		Collection authorities = new ArrayList();
		return new User(userBean.getEmailId(), userBean.getPassword(), true,
				true, true, true, authorities);
	}
}
