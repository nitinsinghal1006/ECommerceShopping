package com.spring.gradle.shopping.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.gradle.shopping.entity.model.UserBean;
import com.spring.gradle.shopping.service.IUserService;
import com.spring.gradle.shopping.util.MD5Encoder;
import com.spring.gradle.shopping.validator.JsonResponse;
import com.spring.gradle.shopping.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	UserValidator userValidator;

	@Autowired
	IUserService iUserService;

	@SuppressWarnings("unused")
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("userBean") UserBean userBean,
			BindingResult bindingResult, Model model) {
		userValidator.validate(userBean, bindingResult);
		if (bindingResult.hasErrors()) {
			return "/login";
		}
		System.out.println("Successfully Validated");
		try {
			userBean.setPassword(MD5Encoder.encode(userBean.getPassword()));
			Serializable id = iUserService.createUser(userBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bindingResult.rejectValue("emailId", "Something went wrong.",
					"Something went wrong.");
			return "/login";
		}
		return "/home";
	}

	@RequestMapping(value = "/user/validate", method = RequestMethod.GET)
	public @ResponseBody
	JsonResponse validateUser(@RequestParam String email,
			@RequestParam String password,
			@ModelAttribute("userBean") UserBean userBean, BindingResult result) {
		System.out.println("Email Id: " + email);
		userBean.setEmailId(email);
		userBean.setPassword(password);
		userValidator.validate(userBean, result);
		JsonResponse res = new JsonResponse();
		if (!result.hasErrors()) {
			res.setStatus("SUCCESS");
		} else {
			res.setStatus("FAIL");
			res.setResult(result.getAllErrors());
		}

		return res;
	}
}
