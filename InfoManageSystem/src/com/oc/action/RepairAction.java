package com.oc.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.oc.action.base.BaseAction;
import com.oc.service.BaseServiceI;
import com.oc.service.RepairServiceI;

@Action("repairAction")
public class RepairAction extends BaseAction {
	private RepairServiceI repairService;

	public RepairServiceI getRepairService() {
		return repairService;
	}

	@Autowired
	public void setRepairService(RepairServiceI repairService) {
		this.repairService = repairService;
	}

	public void init(){
       repairService.repair();		
	}

	@Override
	protected BaseServiceI getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
