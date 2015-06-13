package com.oc.dto;

import java.util.Date;

public class ResumeJobInten {
	   private Integer jobIntenId;
	   private Integer jobTerm;//--工作类型 0：全职；1：兼职；2：实习；3：全/兼职
	   private String jobArea;// --工作地点
	   private String industryType;// --行业
	   private String funType;//--职能
	   private Integer salary;// --期望薪水
	   private Date entryDate;//到岗时间
	   private String introduction;//--自我评价
	   
	   private Integer resumeId;//简历ID
	   
	public ResumeJobInten() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ResumeJobInten(Integer jobIntenId, Integer jobTerm, String jobArea,
			String industryType, String funType, Integer salary,
			Date entryDate, String introduction, Integer resumeId) {
		super();
		this.jobIntenId = jobIntenId;
		this.jobTerm = jobTerm;
		this.jobArea = jobArea;
		this.industryType = industryType;
		this.funType = funType;
		this.salary = salary;
		this.entryDate = entryDate;
		this.introduction = introduction;
		this.resumeId = resumeId;
	}

	public Integer getJobIntenId() {
		return jobIntenId;
	}
	public void setJobIntenId(Integer jobIntenId) {
		this.jobIntenId = jobIntenId;
	}
	public Integer getJobTerm() {
		return jobTerm;
	}
	public void setJobTerm(Integer jobTerm) {
		this.jobTerm = jobTerm;
	}
	public String getJobArea() {
		return jobArea;
	}
	public void setJobArea(String jobArea) {
		this.jobArea = jobArea;
	}
	public String getIndustryType() {
		return industryType;
	}
	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}
	public String getFunType() {
		return funType;
	}
	public void setFunType(String funType) {
		this.funType = funType;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Integer getResumeId() {
		return resumeId;
	}
	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}

	   
}
