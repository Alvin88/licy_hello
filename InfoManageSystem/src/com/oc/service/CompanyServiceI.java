package com.oc.service;

import com.oc.model.TpCompany;

public interface CompanyServiceI extends BaseServiceI<TpCompany> {

	TpCompany addTraceRecord(int id, String text);

	Object getRecordDatagrid(TpCompany tpCompany);

}
