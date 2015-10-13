/**
 * 
 */
package com.oc.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oc.dao.BaseDaoI;
import com.oc.dao.CompanyDaoI;
import com.oc.dto.Page;
import com.oc.model.TTraceRecord;
import com.oc.model.TpCompany;
import com.oc.service.CompanyServiceI;
import com.oc.utils.system.DataGrid;

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


@Override
public TpCompany addTraceRecord(int id, String text)  {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date endTime =new Date();
	TpCompany temp = getDao().get(TpCompany.class, id);
	TTraceRecord e = new TTraceRecord();
	e.setText(text);
	e.setDtime(format.format(endTime));
    e.setCompany(temp);
	List<TTraceRecord> records = temp.getTraceRecords();
	records.add(e);
	TTraceRecord start = records.get(0);
	Date startDate=null;
	try {
		startDate = format.parse(start.getDtime());
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	

	temp.setTraceDateCount(differDays(endTime,startDate));
	
	 getDao().save(temp);
	// TODO Auto-generated method stub
	return temp;
}
private static int differDays(Date endDate,Date startDate){
Calendar c = Calendar.getInstance();
Calendar d = Calendar.getInstance();
c.setTime(startDate);
d.setTime(endDate);
return d.get(Calendar.DAY_OF_YEAR)-c.get(Calendar.DAY_OF_YEAR);
}


@Override
public DataGrid getRecordDatagrid(TpCompany tpCompany) {
	// TODO Auto-generated method stub
	String hql = " from  TTraceRecord  where pid= :pid ";
	Map params = new HashMap<String, String>();
	 List<TTraceRecord> listD = new ArrayList<TTraceRecord>();
	params.put("pid", tpCompany.getId());
	tpCompany.setParams(params);
	DataGrid j = new DataGrid();
	  List list =this.find(hql, tpCompany.getParams(), tpCompany.getPage(), tpCompany.getRows());
	  for (int i=0;i<list.size(); i++) {
		  TTraceRecord district = (TTraceRecord)list.get(i);
		  district.setCompany(null);
          listD.add(district);
      }
	j.setTotal(this.count("select count(*) " + hql, tpCompany.getParams()));
	j.setRows(listD);
	
	return j;
}

	


	

}
