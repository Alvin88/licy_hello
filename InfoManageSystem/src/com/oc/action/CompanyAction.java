package com.oc.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oc.action.base.BaseAction;
import com.oc.dto.User;
import com.oc.model.TpCompany;
import com.oc.service.BaseServiceI;
import com.oc.service.CompanyServiceI;
import com.oc.utils.system.Json;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/")
@Action(value = "companyAction", results = {
		@Result(name = "loginSuccess", type="redirect",location = "/index.jsp"),
		@Result(name = "loginFail", location = "/login.jsp"),
		@Result(name = "userEdit", location = "/views/admin/userEdit.jsp"),
		@Result(name = "doNotNeedSession_userInfo", location = "/views/user/userInfo.jsp")})
@SuppressWarnings("all")
public class CompanyAction extends BaseAction<TpCompany> implements  ModelDriven<TpCompany> {
	
	@Autowired
	private CompanyServiceI companyService;
	
	private String text;
	
	private TpCompany tpCompany = new TpCompany();

	@Override
	protected BaseServiceI<TpCompany> getService() {
		// TODO Auto-generated method stub
		return this.companyService;
	}

	@Override
	public TpCompany getModel() {
		// TODO Auto-generated method stub
		return this.tpCompany;
	}

	
	public  void addRecord(){
	TpCompany comp = companyService.addTraceRecord(tpCompany.getId(),text);
		
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("编辑成功");
		j.setObj(comp);
		writeJson(j);
	}
	public void getRecordDatagrid() {
		super.writeJson(companyService.getRecordDatagrid(tpCompany));
	}
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
