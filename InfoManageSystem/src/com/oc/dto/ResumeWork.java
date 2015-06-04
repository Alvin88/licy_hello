package com.oc.dto;

import java.util.Date;

public class ResumeWork {
	   private Integer workId;//ID
	   private Date workFromDate;//开始日期
	   private Date workToDate;//结束日期
	   private String industry;//150  --行业
	   private String company;//100--公司名称
	   private int companySize;//5--公司规模
	   private int companyType;//  --公司性质
	   private String division;//--部门
	   private String position;//--职位
	   private String responsiblity;// --工作描述
	   private String achievement;//-主要业绩
	   private String leaveReason;//-离职原因
	   
	   private Integer resumeId;//简历ID
	public ResumeWork() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ResumeWork(Integer workId, Date workFromDate, Date workToDate,
			String industry, String company, int companySize, int companyType,
			String division, String position, String responsiblity,
			String achievement, String leaveReason, Integer resumeId) {
		super();
		this.workId = workId;
		this.workFromDate = workFromDate;
		this.workToDate = workToDate;
		this.industry = industry;
		this.company = company;
		this.companySize = companySize;
		this.companyType = companyType;
		this.division = division;
		this.position = position;
		this.responsiblity = responsiblity;
		this.achievement = achievement;
		this.leaveReason = leaveReason;
		this.resumeId = resumeId;
	}

	public Integer getWorkId() {
		return workId;
	}
	public void setWorkId(Integer workId) {
		this.workId = workId;
	}
	public Date getWorkFromDate() {
		return workFromDate;
	}
	public void setWorkFromDate(Date workFromDate) {
		this.workFromDate = workFromDate;
	}
	public Date getWorkToDate() {
		return workToDate;
	}
	public void setWorkToDate(Date workToDate) {
		this.workToDate = workToDate;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getCompanySize() {
		return companySize;
	}
	public void setCompanySize(int companySize) {
		this.companySize = companySize;
	}
	public int getCompanyType() {
		return companyType;
	}
	public void setCompanyType(int companyType) {
		this.companyType = companyType;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getResponsiblity() {
		return responsiblity;
	}
	public void setResponsiblity(String responsiblity) {
		this.responsiblity = responsiblity;
	}
	public String getAchievement() {
		return achievement;
	}
	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public Integer getResumeId() {
		return resumeId;
	}

	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}
	   
}
