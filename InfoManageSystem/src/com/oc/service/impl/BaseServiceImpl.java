package com.oc.service.impl;

import java.util.List;
import java.util.Map;

import com.oc.dao.BaseDaoI;
import com.oc.service.BaseServiceI;

public abstract class BaseServiceImpl<T> implements BaseServiceI<T> {
	
	protected abstract BaseDaoI<T> getDao();

	@Override
	public void delete(T o) {
		// TODO Auto-generated method stub
		getDao().delete(o);
	}

	@Override
	public void update(T o) {
		// TODO Auto-generated method stub
		getDao().update(o);
	}

	@Override
	public void saveOrUpdate(T o) {
		// TODO Auto-generated method stub
		getDao().saveOrUpdate(o);
	}

	@Override
	public List<T> find(String hql, Map params, Integer page,
			Integer rows) {
		// TODO Auto-generated method stub
		return getDao().find(hql, params, page, rows);
	}

	@Override
	public Long count(String hql, Map params) {
		// TODO Auto-generated method stub
		return getDao().count(hql, params);
	}

}
