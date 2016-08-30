package com.spring.gradle.shopping.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.gradle.shopping.entity.model.BrandBean;
import com.spring.gradle.shopping.entity.model.CategoryBean;
import com.spring.gradle.shopping.service.IProductService;
import com.spring.gradle.shopping.util.Constants;

@Controller
public class HomeController {

	private static Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	@Autowired
	IProductService productService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Object home(Model model, HttpSession session, HttpServletRequest request) {
		List<CategoryBean> categoryList = null;
		List<BrandBean> brandList = null;
		if (session.getAttribute(Constants.CATEGORY_LIST) == null) {
			categoryList = productService.getCategories();
			System.out.println("Session is null");

		} else {
			categoryList = (ArrayList<CategoryBean>) session
					.getAttribute(Constants.CATEGORY_LIST);
			System.out.println("Session is not null");
		}
		if (session.getAttribute(Constants.BRAND_LIST) == null) {
			brandList = productService.getBrands();
			System.out.println("Session is null");
		} else {
			brandList = (ArrayList<BrandBean>) session
					.getAttribute(Constants.BRAND_LIST);
			System.out.println("Session is not null");
		}
		logger.info("Indexing");
		logger.info("Category List: " + categoryList.size());
		logger.info("Brand List: " + brandList.size());
		session.setAttribute(Constants.CATEGORY_LIST, categoryList);
		session.setAttribute(Constants.BRAND_LIST, brandList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("brandList", brandList);
		Cookie[] cookies=request.getCookies();
		if (cookies != null) {
			System.out.println("Not Null...........");
		      int i = 0;
		      boolean cookieExists = false;
		      while (!cookieExists && i < cookies.length) {
		    	  System.out.println("cookies[i].getName().........."+cookies[i].getName());
		    	  System.out.println("value1..........."+cookies[i].getValue());
		        if (cookies[i].getName().equals("remember-me")) {
		          cookieExists = true;
		         String value = cookies[i].getValue();
		         System.out.println("value..........."+value);
		        } else {
		          i++;
		        }
		      }
		    }
		return "/home";
	}
}
