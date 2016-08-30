package com.spring.gradle.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.gradle.shopping.entity.model.UserBean;

@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	public Object login(Model model) {
		System.out.println("Login");
		UserBean user = new UserBean();
		model.addAttribute(user);
		return "/login";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public Object loginError(Model model) {
		System.out.println("Access Denied");
		model.addAttribute("error", "true");
		UserBean user = new UserBean();
		model.addAttribute(user);
		return "/login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "/home";
	}
}
