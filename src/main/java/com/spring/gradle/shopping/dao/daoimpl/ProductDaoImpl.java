package com.spring.gradle.shopping.dao.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.gradle.shopping.dao.IProductDao;
import com.spring.gradle.shopping.entity.model.BrandBean;
import com.spring.gradle.shopping.entity.model.CategoryBean;
import com.spring.gradle.shopping.entity.model.ProductBean;

@Repository
public class ProductDaoImpl implements IProductDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<CategoryBean> getCategories() {
		List<CategoryBean> categoryList = null;
		try {
			Criteria criteria = getCurrentSession().createCriteria(
					CategoryBean.class);
			categoryList = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Size: " + categoryList.size());
		return categoryList;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<BrandBean> getBrands() {
		// TODO Auto-generated method stub
		List<BrandBean> brandssList = null;
		try {
			Criteria criteria = getCurrentSession().createCriteria(
					BrandBean.class);
			brandssList = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return brandssList;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<ProductBean> getProductByBrandId(int brandId) {
		List<ProductBean> productBeanList = null;
		try {
			productBeanList = getCurrentSession()
					.createCriteria(ProductBean.class)
					.add(Restrictions.eq("brandId", brandId)).list();
			return productBeanList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return productBeanList;
		}
	}

	@Override
	@Transactional
	public ProductBean getProductByProductId(int productId) {
		ProductBean productBean = null;
		try {
			productBean = (ProductBean) getCurrentSession().get(
					ProductBean.class, productId);
		} catch (Exception e) { // TODO: handle exception
			e.printStackTrace();
		}
		return productBean;
	}

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public List<OptionGroupBean>
	 * getAllOptionGroups() { // TODO Auto-generated method stub
	 * List<OptionGroupBean> productOptionBeansList = null; try { Criteria
	 * criteria = getCurrentSession().createCriteria( OptionGroupBean.class);
	 * productOptionBeansList = criteria.list(); } catch (Exception e) { //
	 * TODO: handle exception e.printStackTrace(); } return
	 * productOptionBeansList; }
	 */

	/*
	 * @Override
	 * 
	 * @Transactional public OptionBean getOptionsByOptionId(int optionId) { //
	 * TODO Auto-generated method stub OptionBean optionBean = (OptionBean)
	 * getCurrentSession().get( OptionBean.class, optionId); return optionBean;
	 * }
	 */

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public List<OptionBean> getAllOptions() {
	 * // TODO Auto-generated method stub List<OptionBean> optionsList = null;
	 * try { Criteria criteria = getCurrentSession().createCriteria(
	 * OptionBean.class); optionsList = criteria.list(); } catch (Exception e) {
	 * // TODO: handle exception e.printStackTrace(); } return optionsList; }
	 */

	/*
	 * @Override
	 * 
	 * @Transactional public Serializable saveProduct(ProductBean productBean) {
	 * // TODO Auto-generated method stub Serializable id =
	 * getCurrentSession().save(productBean); return id; }
	 */

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public List<BrandBean>
	 * getBrandByCategoryId(int categoryId) { // List<BrandBean> brandBeanList =
	 * (List<BrandBean>) getCurrentSession() // .get(BrandBean.class,
	 * categoryId); List<BrandBean> brandBeanList = getCurrentSession()
	 * .createCriteria(BrandBean.class) .add(Restrictions.eq("categoryId",
	 * categoryId)).list(); return brandBeanList; }
	 */

}
