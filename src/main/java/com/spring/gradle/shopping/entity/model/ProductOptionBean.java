package com.spring.gradle.shopping.entity.model;

import java.io.Serializable;

public class ProductOptionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1955982254503148077L;
	private int productOptionId = 0;
	private int productId = 0;
	// private int optionId = 0;
	// private int optionGroupId = 0;
	private OptionBean optionBean;
	private OptionGroupBean optionGroupBean;

	public int getProductOptionId() {
		return productOptionId;
	}

	public void setProductOptionId(int productOptionId) {
		this.productOptionId = productOptionId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public OptionBean getOptionBean() {
		return optionBean;
	}

	public void setOptionBean(OptionBean optionBean) {
		this.optionBean = optionBean;
	}

	public OptionGroupBean getOptionGroupBean() {
		return optionGroupBean;
	}

	public void setOptionGroupBean(OptionGroupBean optionGroupBean) {
		this.optionGroupBean = optionGroupBean;
	}

}
