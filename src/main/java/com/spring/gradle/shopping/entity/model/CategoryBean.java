package com.spring.gradle.shopping.entity.model;

import java.io.Serializable;

public class CategoryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8599878317669881771L;
	private int categoryId = 0;
	private String categoryName = "";

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
