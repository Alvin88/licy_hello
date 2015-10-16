package com.oc.dto;

public class TalentRecord {
	   private Integer recordId;//记录id
	   private Integer talentId;//跟进的人才id
	   private String record;//跟进的记录
	   private String traceDate;//跟进时间
	   private String traceUserId;//跟进人才的用户id
	   private String traceUserName;//跟进人才的用户名称
	   private String remark;//备注
	   
	   
	   
	public TalentRecord(Integer recordId, Integer talentId, String record,
			String traceDate, String traceUserId, String traceUserName,
			String remark) {
		super();
		this.recordId = recordId;
		this.talentId = talentId;
		this.record = record;
		this.traceDate = traceDate;
		this.traceUserId = traceUserId;
		this.traceUserName = traceUserName;
		this.remark = remark;
	}
	public TalentRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
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
	public String getTraceDate() {
		return traceDate;
	}
	public void setTraceDate(String traceDate) {
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
