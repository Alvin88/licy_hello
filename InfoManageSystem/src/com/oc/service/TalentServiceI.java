package com.oc.service;

import com.oc.dto.Talent;
import com.oc.utils.system.DataGrid;

public interface TalentServiceI {
	public DataGrid datagrid(Talent talent);//获取
	
	public boolean saveOrUpdateTalent(Talent talent);//新增简历
	
	public void deleteTalent(String ids);//删除简历
	
}
