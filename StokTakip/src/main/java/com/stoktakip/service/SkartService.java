package com.stoktakip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stoktakip.dto.Skart;

@Service("skartService")
@Transactional
public class SkartService {

	@Autowired
	private BaseDao baseDao;

	public void save(Skart s) {
		baseDao.save(s);

	}

	public void update(Skart s) {
		baseDao.update(s);
	}

	@SuppressWarnings("unchecked")
	public List<Skart> getAll() {
		return (List<Skart>)baseDao.getAll(Skart.class);
	}

}
