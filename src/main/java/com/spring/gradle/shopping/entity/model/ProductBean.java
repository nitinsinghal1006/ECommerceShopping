package com.spring.gradle.shopping.entity.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProductBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2819471162617357723L;
	private int productId = 0;
	private int categoryId = 0;
	private int brandId = 0;
	private String modelName = "";
	private Integer quantity = 0;
	private float discount = 0f;
	private float price = 0f;
	private float weight = 0f;
	private String shortDescription = "";
	private String longDescription = "";
	private String productImage;
	private Date updateDate = new Date();
	private int live = 0;
	private float stock = 0f;
	private String[] productOptions;
	private List<ProductOptionBean> productOptionsBean;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getLive() {
		return live;
	}

	public void setLive(int live) {
		this.live = live;
	}

	public float getStock() {
		return stock;
	}

	public void setStock(float stock) {
		this.stock = stock;
	}

	public String[] getProductOptions() {
		return productOptions;
	}

	public void setProductOptions(String[] productOptions) {
		this.productOptions = productOptions;
	}

	public List<ProductOptionBean> getProductOptionsBean() {
		return productOptionsBean;
	}

	public void setProductOptionsBean(List<ProductOptionBean> productOptionsBean) {
		this.productOptionsBean = productOptionsBean;
	}

}
