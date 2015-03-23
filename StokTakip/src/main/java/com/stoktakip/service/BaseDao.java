package com.stoktakip.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("baseDao")
@Transactional
public class BaseDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly=false)
	public void save(Object o) {
		getSession().save(o);

	}

	@Transactional(readOnly=false)
	public void update(Object o) {
		getSession().update(o);
	}

	@Transactional(readOnly=false)
	public void delete(Object o) {
		getSession().delete(o); 
	}

	@SuppressWarnings("rawtypes")
	public List getAll(Class cls) {
		Criteria criteria=getSession().createCriteria(cls);
		criteria.setCacheable(false);
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
