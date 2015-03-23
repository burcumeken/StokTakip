package com.stoktakip.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stoktakip.dto.SkartTip;

@Service("skartTipService")
@Transactional
public class SkartTipService {
	@Autowired
	private BaseDao baseDao;

	public void save(SkartTip s) {
		baseDao.save(s);

	}

	public void update(SkartTip s) {
		baseDao.update(s);
	}
	
	public SkartTip getById(Long id) {
		Criteria criteria=baseDao.getSession().createCriteria(SkartTip.class);
		criteria.add(Restrictions.idEq(id));
		return (SkartTip)criteria.uniqueResult();
	}

	public List<SkartTip> getAll() {
		return (List<SkartTip>)baseDao.getAll(SkartTip.class);
	}
}
