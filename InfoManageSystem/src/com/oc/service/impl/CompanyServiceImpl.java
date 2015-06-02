/**
 * 
 */
package com.oc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.oc.dao.BaseDaoI;
import com.oc.dao.CompanyDaoI;
import com.oc.model.TpCompany;
import com.oc.service.CompanyServiceI;

/**
 * @author Administrator
 *
 */
public class CompanyServiceImpl extends BaseServiceImpl<TpCompany> implements
		CompanyServiceI {
	

	@Autowired
	private CompanyDaoI companyDao;
	

	@Override
	protected BaseDaoI<TpCompany> getDao() {
		// TODO Auto-generated method stub
		return this.companyDao;
	}

}
