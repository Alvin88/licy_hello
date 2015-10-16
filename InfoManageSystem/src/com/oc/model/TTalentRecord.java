package com.oc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_talent_record")
public class TTalentRecord {
   private Integer id;//记录id
   private Integer talentId;//跟进的人才id
   private String record;//跟进的记录
   private Date traceDate;//跟进时间
   private String traceUserId;//跟进人才的用户id
   private String traceUserName;//跟进人才的用户名称
   private String remark;//备注
   
   
   
public TTalentRecord(Integer id, Integer talentId, String record,
		Date traceDate, String traceUserId, String traceUserName,
		String remark) {
	super();
	this.id = id;
	this.talentId = talentId;
	this.record = record;
	this.traceDate = traceDate;
	this.traceUserId = traceUserId;
	this.traceUserName = traceUserName;
	this.remark = remark;
}
public TTalentRecord() {
	super();
	// TODO Auto-generated constructor stub
}
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getTalentId() {
	return talentId;
}
public void setTalentId(Integer talentId) {
	this.talentId = talentId;
}
public String getRecord() {
	return record;
}
public void setRecord(String record) {
	this.record = record;
}
public Date getTraceDate() {
	return traceDate;
}
public void setTraceDate(Date traceDate) {
	this.traceDate = traceDate;
}
public String getTraceUserId() {
	return traceUserId;
}
public void setTraceUserId(String traceUserId) {
	this.traceUserId = traceUserId;
}
public String getTraceUserName() {
	return traceUserName;
}
public void setTraceUserName(String traceUserName) {
	this.traceUserName = traceUserName;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
   
   
}
