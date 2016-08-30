package com.spring.gradle.shopping.entity.model;

import java.io.Serializable;

public class BrandBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 629846680210257078L;
	private int brandId;
	private int categoryId;
	private String brandName;

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

}
