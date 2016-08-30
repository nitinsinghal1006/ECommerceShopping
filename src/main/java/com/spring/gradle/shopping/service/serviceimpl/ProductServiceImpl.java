package com.spring.gradle.shopping.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.gradle.shopping.dao.IProductDao;
import com.spring.gradle.shopping.entity.model.BrandBean;
import com.spring.gradle.shopping.entity.model.CategoryBean;
import com.spring.gradle.shopping.entity.model.ProductBean;
import com.spring.gradle.shopping.service.IProductService;

@Repository
public class ProductServiceImpl implements IProductService {
	@Autowired
	IProductDao productDao;

	@Override
	public List<CategoryBean> getCategories() {
		// TODO Auto-generated method stub
		return productDao.getCategories();
	}

	@Override
	public List<BrandBean> getBrands() {
		// TODO Auto-generated method stub
		return productDao.getBrands();
	}

	@Override
	public List<ProductBean> getProductByBrandId(int brandId) { //
		return productDao.getProductByBrandId(brandId);
	}

	@Override
	public ProductBean getProductByProductId(int productId) { //
		return productDao.getProductByProductId(productId);
	}

	/*
	 * @Override public List<OptionGroupBean> getAllOptionGroups() { // TODO
	 * Auto-generated method stub List<OptionGroupBean> optionGroupBeansList =
	 * productDao .getAllOptionGroups(); return optionGroupBeansList; }
	 */

	/*
	 * @Override public OptionBean getOptionsByOptionId(int optionId) { // TODO
	 * Auto-generated method stub return
	 * productDao.getOptionsByOptionId(optionId); }
	 */

	/*
	 * @Override public List<OptionBean> getAllOptions() { // TODO
	 * Auto-generated method stub List<OptionBean> optionsList =
	 * productDao.getAllOptions(); return optionsList; }
	 */

	/*
	 * @Override public Serializable saveProduct(ProductBean productBean) { //
	 * TODO Auto-generated method stub return
	 * productDao.saveProduct(productBean); }
	 */

	/*
	 * @Override public List<BrandBean> getBrandByCategoryId(int categoryId) {
	 * // TODO Auto-generated method stub return
	 * productDao.getBrandByCategoryId(categoryId); }
	 */

}
