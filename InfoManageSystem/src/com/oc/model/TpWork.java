package com.oc.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "tp_work")
public class TpWork {
   private Integer id;//ID
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


   private Tresume resume;
   

public TpWork(Integer id, Date workFromDate, Date workToDate, String industry,
		String company, int companySize, int companyType, String division,
		String position, String responsiblity, String achievement,
		String leaveReason, Tresume resume) {
	super();
	this.id = id;
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
	this.resume = resume;
}
public TpWork() {
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
@Column(name = "from_date")
public Date getWorkFromDate() {
	return workFromDate;
}
public void setWorkFromDate(Date workFromDate) {
	this.workFromDate = workFromDate;
}
@Column(name = "to_date")
public Date getWorkToDate() {
	return workToDate;
}
public void setWorkToDate(Date workToDate) {
	this.workToDate = workToDate;
}

@Column(name = "company", length = 100)
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
@Column(name = "industry", length = 150)
public String getIndustry() {
	return industry;
}
public void setIndustry(String industry) {
	this.industry = industry;
}
@Column(name = "company_size", length = 8)
public int getCompanySize() {
	return companySize;
}
public void setCompanySize(int companySize) {
	this.companySize = companySize;
}
@Column(name = "company_type", length = 4)
public int getCompanyType() {
	return companyType;
}
public void setCompanyType(int companyType) {
	this.companyType = companyType;
}
@Column(name = "division", length = 50)
public String getDivision() {
	return division;
}
public void setDivision(String division) {
	this.division = division;
}
@Column(name = "position", length = 50)
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
@Type(type="text")
@Column(name = "responsiblity")
public String getResponsiblity() {
	return responsiblity;
}
public void setResponsiblity(String responsiblity) {
	this.responsiblity = responsiblity;
}
@Column(name = "leave_reason", length = 255)
public String getLeaveReason() {
	return leaveReason;
}
public void setLeaveReason(String leaveReason) {
	this.leaveReason = leaveReason;
}
@Column(name = "achievement", length = 1000)
public String getAchievement() {
	return achievement;
}
public void setAchievement(String achievement) {
	this.achievement = achievement;
}


@ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch = FetchType.LAZY)
@JoinColumn(name = "resume_id")
public Tresume getResume() {
	return resume;
}
public void setResume(Tresume resume) {
	this.resume = resume;
}
   
}
