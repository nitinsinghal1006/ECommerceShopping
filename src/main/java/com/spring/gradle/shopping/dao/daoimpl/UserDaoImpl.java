package com.spring.gradle.shopping.dao.daoimpl;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.gradle.shopping.dao.IUserDao;
import com.spring.gradle.shopping.entity.model.UserBean;

@Repository
public class UserDaoImpl implements IUserDao {
	@Autowired
	SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@Transactional
	public Serializable createUser(UserBean userBean) {
		Serializable id = getCurrentSession().save(userBean);
		return id;

	}

	@Override
	@Transactional(readOnly = true)
	public UserBean findByUsername(String username) {
		// TODO Auto-generated method stub
		Criteria criteria = getCurrentSession().createCriteria(UserBean.class);
		criteria.add(Restrictions.eq("emailId", username));
		UserBean userBean = (UserBean) criteria.uniqueResult();
		return userBean;
	}

}
