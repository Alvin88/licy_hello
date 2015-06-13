/**
 * 
 */
package com.oc.service.impl;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
		String hql = " from  TpCompany company where 1=1 ";
		Map<String,String> params = page.getParams();
		if(params!=null){
		if(params.get("name")!=null){
			params.put("name", '%'+params.get("name")+'%');
			hql=hql+" and  company.name like :name ";
		}
			
		if(params.get("mail")!=null)
			params.put("mail", '%'+params.get("mail")+'%');
			hql=hql+" and  company.mail like :mail ";
		}
		return hql;
	}

   @Override
 	public void remove(Object[] ids) {
		// TODO Auto-generated method stub
		getDao().executeHql("delete TpCompany t where t.id in  ?", ids);
		
	}


	


	

}
