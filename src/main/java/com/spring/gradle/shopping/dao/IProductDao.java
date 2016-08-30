package com.spring.gradle.shopping.dao;

import java.util.List;

import com.spring.gradle.shopping.entity.model.BrandBean;
import com.spring.gradle.shopping.entity.model.CategoryBean;
import com.spring.gradle.shopping.entity.model.ProductBean;

public interface IProductDao {
	public List<CategoryBean> getCategories();

	public List<BrandBean> getBrands();

	public List<ProductBean> getProductByBrandId(int brandId);

	public ProductBean getProductByProductId(int productId);

	/*
	 * public List<OptionGroupBean> getAllOptionGroups();
	 * 
	 * public List<OptionBean> getAllOptions();
	 * 
	 * public OptionBean getOptionsByOptionId(int optionId);
	 * 
	 * public List<BrandBean> getBrandByCategoryId(int categoryId);
	 * 
	 * public Serializable saveProduct(ProductBean productBean);
	 * 
	 * public List<ProductBean> getProductByBrandId(int brandId);
	 */
}
