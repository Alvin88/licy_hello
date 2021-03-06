package com.oc.service.impl;

import java.util.List;
import java.util.Map;

import com.oc.dao.BaseDaoI;
import com.oc.dto.Page;
import com.oc.service.BaseServiceI;
import com.oc.utils.system.DataGrid;

public abstract class BaseServiceImpl<T> implements BaseServiceI<T> {
	
	protected abstract BaseDaoI<T> getDao();
	
	protected abstract String getHql(Page page) ;

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
	@Override
	public DataGrid datagrid( Page page) {
		DataGrid j = new DataGrid();
		j.setTotal(this.count("select count(*) " + this.getHql(page), page.getParams()));
		j.setRows(this.find(this.getHql(page), page.getParams(), page.getPage(), page.getRows()));
		
		return j;
	}

	@Override
	public void executeHql(String hql, Object[] params) {

      getDao().executeHql(hql, params);
		
	}

}
