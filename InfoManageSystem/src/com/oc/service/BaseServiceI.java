package com.oc.service;

import java.util.List;
import java.util.Map;

import com.oc.dto.DataGrid;
import com.oc.dto.Page;

public interface  BaseServiceI<T> {
	
	/**
	 * 删除一个对象
	 * 
	 * @param o
	 */
	public void delete(T o);
	
	
	/**
	 * 删除批量删除
	 * 
	 * @param o
	 */
	public void remove(Object[] ids);

	/**
	 * 执行Hql
	 * 
	 * @param o
	 */
	public void executeHql(String hql,Object[] params);

	/**
	 * 更新一个对象
	 * 
	 * @param o
	 */
	public void update(T o);

	/**
	 * 保存或更新对象
	 * 
	 * @param o
	 */
	public void saveOrUpdate(T o);
	
	
	/**
	 * 查询集合(带分页)
	 * 
	 * @param hql
	 * @param param
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<T> find(String hql, Map param, Integer page,
			Integer rows);
	
	/**
	 * select count(*) from 类
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	public Long count(String hql, Map param);

	
	public DataGrid datagrid(Page page);

}
