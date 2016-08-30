package com.spring.gradle.shopping.entity.model;

import java.io.Serializable;

public class OptionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2867973027403008383L;
	private int optionId = 0;
	private int optionGroupId = 0;
	private String optionName = "";

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public int getOptionGroupId() {
		return optionGroupId;
	}

	public void setOptionGroupId(int optionGroupId) {
		this.optionGroupId = optionGroupId;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

}
