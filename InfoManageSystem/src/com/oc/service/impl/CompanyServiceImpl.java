/**
 * 
 */
package com.oc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oc.dao.BaseDaoI;
import com.oc.dao.CompanyDaoI;
import com.oc.dto.Page;
import com.oc.model.TpCompany;
import com.oc.service.CompanyServiceI;

/**
 * @author Administrator
 *
 */
@Service("companyService")
public class CompanyServiceImpl extends BaseServiceImpl<TpCompany> implements
		CompanyServiceI {
	

	@Autowired
	private CompanyDaoI companyDao;
	

	@Override
	protected BaseDaoI<TpCompany> getDao() {
		// TODO Auto-generated method stub
		return this.companyDao;
	}


	@Override
	protected String getHql(Page page) {
		// TODO Auto-generated method stub
		String hql = " from  TpCompany ";
		return hql;
	}


	

}
