package com.oc.model;

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
@Table(name = "tp_jobintension")
public class TpJobIntension {
   private Integer id;
   private Integer jobTerm;//--工作类型 0：全职；1：兼职；2：实习；3：全/兼职
   private String jobArea;// --工作地点
   private String industryType;// --行业
   private String funType;//--职能
   private Integer salary;// --期望薪水
   private Integer entryTime;//--到岗时间,以月为单位
   private String introduction;//--自我评价
   private Tperson person;//个人服务
public TpJobIntension() {
	super();
	// TODO Auto-generated constructor stub
}
public TpJobIntension(Integer id, Integer jobTerm, String jobArea,
		String industryType, String funType, Integer salary, Integer entryTime,
		String introduction,Tperson person) {
	super();
	this.id = id;
	this.jobTerm = jobTerm;
	this.jobArea = jobArea;
	this.industryType = industryType;
	this.funType = funType;
	this.salary = salary;
	this.entryTime = entryTime;
	this.introduction = introduction;
	this.person = person;
}
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
@Column(name = "job_term", length = 3)
public Integer getJobTerm() {
	return jobTerm;
}
public void setJobTerm(Integer jobTerm) {
	this.jobTerm = jobTerm;
}
@Column(name = "job_area", length = 50)
public String getJobArea() {
	return jobArea;
}
public void setJobArea(String jobArea) {
	this.jobArea = jobArea;
}
@Column(name = "industry_type", length = 50)
public String getIndustryType() {
	return industryType;
}
public void setIndustryType(String industryType) {
	this.industryType = industryType;
}
@Column(name = "fun_type", length = 50)
public String getFunType() {
	return funType;
}
public void setFunType(String funType) {
	this.funType = funType;
}
@Column(name = "salary", length = 8)
public Integer getSalary() {
	return salary;
}
public void setSalary(Integer salary) {
	this.salary = salary;
}
@Column(name = "entry_time", length = 3)
public Integer getEntryTime() {
	return entryTime;
}
public void setEntryTime(Integer entryTime) {
	this.entryTime = entryTime;
}
@Type(type="text")
@Column(name = "introduction")
public String getIntroduction() {
	return introduction;
}
public void setIntroduction(String introduction) {
	this.introduction = introduction;
}
@ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch = FetchType.LAZY)
@JoinColumn(name = "person_id")
public Tperson getPerson() {
	return person;
}
public void setPerson(Tperson person) {
	this.person = person;
}
   
   
}
