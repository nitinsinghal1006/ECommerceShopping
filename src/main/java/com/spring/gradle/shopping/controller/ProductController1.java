//package com.spring.gradle.shopping.controller;
//
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletContext;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.spring.gradle.shopping.entity.model.BrandBean;
//import com.spring.gradle.shopping.entity.model.CategoryBean;
//import com.spring.gradle.shopping.entity.model.OptionBean;
//import com.spring.gradle.shopping.entity.model.OptionGroupBean;
//import com.spring.gradle.shopping.entity.model.ProductBean;
//import com.spring.gradle.shopping.entity.model.ProductOptionBean;
//import com.spring.gradle.shopping.entity.model.QuantityBean;
//import com.spring.gradle.shopping.service.IProductService;
//import com.spring.gradle.shopping.util.ShoppingUtils;
//
//@Controller
//public class ProductController {
//	@Autowired
//	IProductService productService;
//	@Autowired
//	ServletContext context;
//
//	@RequestMapping(value = "/product", method = RequestMethod.GET)
//	public Object addProductList(Model model) {
//		List<OptionGroupBean> optionGroupBeansList = productService
//				.getAllOptionGroups();
//		List<OptionBean> optionsList = productService.getAllOptions();
//		List<CategoryBean> categoryList = productService.getCategories();
//		List<BrandBean> brandList = productService.getBrands();
//		System.out.println("categoryList Size: " + categoryList.size());
//		for (OptionGroupBean optionGroupBean : optionGroupBeansList) {
//			System.out.println("Option Group Id: "
//					+ optionGroupBean.getOptionGroupID());
//			System.out.println("Option Group Name: "
//					+ optionGroupBean.getOptionGroupName());
//		}
//		for (OptionBean optionBean : optionsList) {
//			System.out.println("Option Id: " + optionBean.getOptionId());
//			System.out.println("Option Group Id: "
//					+ optionBean.getOptionGroupId());
//			System.out.println("Option Name: " + optionBean.getOptionName());
//		}
//		ProductBean productBean = new ProductBean();
//		model.addAttribute(productBean);
//		model.addAttribute("optionGroupBeansList", optionGroupBeansList);
//		model.addAttribute("optionsList", optionsList);
//		model.addAttribute("categoryList", categoryList);
//		model.addAttribute("brandList", brandList);
//		return "/add_product";
//
//	}
//
//	@RequestMapping(value = "/product/getBrandByCategoryId", method = RequestMethod.GET, headers = "Accept=application/json")
//	public @ResponseBody
//	List<BrandBean> getBrandByCategoryId(
//			@RequestParam(value = "categoryId", required = true) int categoryId) {
//		System.out.println("Category Id: " + categoryId);
//		List<BrandBean> brandBeansList = productService
//				.getBrandByCategoryId(categoryId);
//		System.out.println("Brand list size: " + brandBeansList.size());
//		return brandBeansList;
//	}
//
//	@RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
//	public Object addProduct(@Valid ProductBean productBean,
//			BindingResult bindingResult, Model model,
//			@RequestParam("file") MultipartFile file,
//			@RequestParam("productQuantity") int quantity) {
//
//		if (bindingResult.hasErrors()) {
//			// LOGGER.warn("validation error={}", bindingResult.getModel());
//			System.out
//					.println("validation error={}" + bindingResult.getModel());
//			model.addAllAttributes(bindingResult.getModel());
//			return "add_product";
//		}
//		System.out.println("Product Name: " + productBean.getBrandId());
//		productBean.setQuantity(quantity);
//		String[] productOptions = productBean.getProductOptions();
//		List<ProductOptionBean> productOptionBeansList = new ArrayList<ProductOptionBean>();
//		for (int i = 0; i < productOptions.length; i++) {
//			String optionId = productOptions[i];
//			System.out.println("Option Id: " + optionId);
//			ProductOptionBean productOptionBean = new ProductOptionBean();
//			OptionBean optionBean = productService.getOptionsByOptionId(Integer
//					.parseInt(optionId));
//
//			// productOptionBean.setOptionId(Integer.parseInt(optionId));
//			// productOptionBean.setOptionGroupId(optionBean.getOptionGroupId());
//			productOptionBean.setOptionBean(optionBean);
//			OptionGroupBean bean = new OptionGroupBean();
//			bean.setOptionGroupID(optionBean.getOptionGroupId());
//			productOptionBean.setOptionGroupBean(bean);
//			productOptionBeansList.add(productOptionBean);
//		}
//		productBean.setProductOptionsBean(productOptionBeansList);
//		// Generate random filename
//		String imageName = productBean.getBrandId() + "_"
//				+ ShoppingUtils.timeStamp() + "_"
//				+ ShoppingUtils.randomNumber() + ".jpg";
//		if (!file.isEmpty()) {
//			try {
//				byte[] bytes = file.getBytes();
//
//				// Creating the directory to store file
//				String webappRoot = context.getRealPath("/");
//				String relativeFolder = File.separator + "resources"
//						+ File.separator + "images" + File.separator;
//				System.out.println("relativeFolder: " + relativeFolder);
//				String filename = webappRoot + relativeFolder
//						+ file.getOriginalFilename();
//				System.out.println("File Name: " + filename);
//				String pathArr[] = filename.split(".metadata");
//				System.out.println(pathArr[0]);
//				String imageUploadPath = pathArr[0];
//				System.out.println("imageUploadPath: " + imageUploadPath);
//				File dir = new File(imageUploadPath + File.separator
//						+ "products");
//				if (!dir.exists())
//					dir.mkdirs();
//
//				// Create the file on server
//				File serverFile = new File(dir.getAbsolutePath()
//						+ File.separator + imageName);
//				System.out.println("Path: " + dir.getAbsolutePath()
//						+ File.separator + imageName);
//				BufferedOutputStream stream = new BufferedOutputStream(
//						new FileOutputStream(serverFile));
//				stream.write(bytes);
//				stream.close();
//				System.out.println("Server File Location="
//						+ serverFile.getAbsolutePath());
//				System.out.println("You successfully uploaded file="
//						+ imageName);
//				productBean.setProductImage(serverFile.getAbsolutePath());
//				Serializable id = productService.saveProduct(productBean);
//				System.out.println("Return Id: " + id);
//			} catch (Exception e) {
//				System.out.println("You failed to upload " + imageName + " => "
//						+ e.getMessage());
//			}
//		} else {
//			System.out.println("You failed to upload " + imageName
//					+ " because the file was empty.");
//		}
//
//		// System.out.println("File Name: " + file.getName());
//
//		ModelAndView view = new ModelAndView();
//		ProductBean product = new ProductBean();
//		view.addObject(product);
//		view.setViewName("/add_product");
//		return view;
//
//	}
//
//	@RequestMapping(value = "/product/getProductByBrand/{brandId}")
//	public Object getProductByBrand(Model model,
//			@PathVariable("brandId") Integer brandId) {
//		System.out.println("Brand Id: " + brandId);
//		List<ProductBean> productBeansList = productService
//				.getProductByBrandId(brandId);
//		for (ProductBean productBean : productBeansList) {
//			System.out.println("Product Id: " + productBean.getProductId());
//			List<ProductOptionBean> productOptionBeansList = productBean
//					.getProductOptionsBean();
//			System.out.println("Size: " + productOptionBeansList.size());
//			for (ProductOptionBean productOptionBean : productOptionBeansList) {
//
//				System.out.println("Product option id: "
//						+ productOptionBean.getProductOptionId());
//				System.out.println("Product option name: "
//						+ productOptionBean.getOptionBean().getOptionName());
//				System.out.println("Product option group name: "
//						+ productOptionBean.getOptionGroupBean()
//								.getOptionGroupName());
//			}
//
//		}
//		// List<String> list = new ArrayList<String>();
//		/*
//		 * for (int i = 0; i < 15; i++) {
//		 * 
//		 * list.add(i + ""); }
//		 */
//		model.addAttribute("productBeansList", productBeansList);
//		return "/product_brand";
//	}
//
//	@RequestMapping(value = "/product/getProductByProductId/{productId}")
//	public Object getProductByProductId(Model model,
//			@PathVariable("productId") Integer productId) {
//		System.out.println("Product Id: " + productId);
//		ProductBean productBean = productService
//				.getProductByProductId(productId);
//		int quantity = productBean.getQuantity();
//		
//		List<QuantityBean> quantityList = new ArrayList<QuantityBean>();
//		for (int i = 1; i <= quantity; i++) {
//			QuantityBean quantityBean=new QuantityBean();
//			quantityBean.setQty(i);
//			quantityList.add(quantityBean);
//		}
//		System.out.println("Model Name: " + productBean.getModelName());
//		//testing file name
//		String rootPath = System.getProperty("catalina.home");
//        File dir = new File(rootPath + File.separator + "tmpFiles");
//        if (!dir.exists())
//            dir.mkdirs();
//
//        // Create the file on server
//        System.out.println("Absolute Path Name: "+dir.getAbsolutePath());
//		model.addAttribute("productBean", productBean);
//		model.addAttribute("quantityList", quantityList);
////		model.addAttribute("quantityList", quantityList);
//		return "/cart_details";
//	}
//}
