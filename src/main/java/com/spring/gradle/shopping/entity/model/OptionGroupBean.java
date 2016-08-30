package com.spring.gradle.shopping.entity.model;

import java.io.Serializable;

public class OptionGroupBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -359479726448793221L;

	private int optionGroupID = 0;
	private String optionGroupName = "";

	public int getOptionGroupID() {
		return optionGroupID;
	}

	public void setOptionGroupID(int optionGroupID) {
		this.optionGroupID = optionGroupID;
	}

	public String getOptionGroupName() {
		return optionGroupName;
	}

	public void setOptionGroupName(String optionGroupName) {
		this.optionGroupName = optionGroupName;
	}

}
