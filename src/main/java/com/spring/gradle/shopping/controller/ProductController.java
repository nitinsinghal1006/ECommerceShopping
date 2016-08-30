package com.spring.gradle.shopping.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.gradle.shopping.entity.model.BrandBean;
import com.spring.gradle.shopping.entity.model.CategoryBean;
import com.spring.gradle.shopping.entity.model.ProductBean;
import com.spring.gradle.shopping.entity.model.ProductOptionBean;
import com.spring.gradle.shopping.entity.model.QuantityBean;
import com.spring.gradle.shopping.service.IProductService;
import com.spring.gradle.shopping.util.Constants;

@Controller
public class ProductController {
	@Autowired
	IProductService productService;
	@Autowired
	ServletContext context;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/product/getProductByBrand/{brandId}")
	public Object getProductByBrand(Model model,
			@PathVariable("brandId") Integer brandId, HttpSession session) {
		System.out.println("Brand Id: " + brandId);
		List<ProductBean> productBeansList = productService
				.getProductByBrandId(brandId);
		for (ProductBean productBean : productBeansList) {
			System.out.println("Product Id: " + productBean.getProductId());
			List<ProductOptionBean> productOptionBeansList = productBean
					.getProductOptionsBean();
			System.out.println("Size: " + productOptionBeansList.size());
			for (ProductOptionBean productOptionBean : productOptionBeansList) {

				System.out.println("Product option id: "
						+ productOptionBean.getProductOptionId());
				System.out.println("Product option name: "
						+ productOptionBean.getOptionBean().getOptionName());
				System.out.println("Product option group name: "
						+ productOptionBean.getOptionGroupBean()
								.getOptionGroupName());
			}

		}
		// List<String> list = new ArrayList<String>();
		/*
		 * for (int i = 0; i < 15; i++) {
		 * 
		 * list.add(i + ""); }
		 */
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
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("brandList", brandList);
		model.addAttribute("productBeansList", productBeansList);
		return "/product_list";
	}

	@RequestMapping(value = "/product/getProductByProductId/{productId}")
	public Object getProductByProductId(Model model,
			@PathVariable("productId") Integer productId) {
		System.out.println("Product Id: " + productId);
		ProductBean productBean = productService
				.getProductByProductId(productId);
		int quantity = productBean.getQuantity();

		List<QuantityBean> quantityList = new ArrayList<QuantityBean>();
		for (int i = 1; i <= quantity; i++) {
			QuantityBean quantityBean = new QuantityBean();
			quantityBean.setQty(i);
			quantityList.add(quantityBean);
		}
		System.out.println("Model Name: " + productBean.getModelName());
		/*
		 * //testing file name String rootPath =
		 * System.getProperty("catalina.home"); File dir = new File(rootPath +
		 * File.separator + "tmpFiles"); if (!dir.exists()) dir.mkdirs();
		 */

		// Create the file on server
		// System.out.println("Absolute Path Name: "+dir.getAbsolutePath());
		model.addAttribute("productBean", productBean);
		model.addAttribute("quantityList", quantityList);
		// model.addAttribute("quantityList", quantityList);
		return "/product_details";
	}

}
