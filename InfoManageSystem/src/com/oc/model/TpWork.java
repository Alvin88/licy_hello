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
@Table(name = "tp_work")
public class TpWork {
   private Integer id;
   private String fromYear;//--时间-从年
   private String fromMonth;//--时间-从月
   private String toYear;// --时间-到年  -当前年份
   private String toMonth;//--时间-到月  -当前月份    
   private String company;//100--公司名称
   private String industry;//150  --行业
   private int companySize;//5--公司规模
   private int companyType;//  --公司性质
   private String division;//--部门
   private String subFunction;//--职位
   private String position;//--其他职位
   private String responsiblity;// --工作描述
   private String reportLine;//--汇报对象
   private int subordinate;// --下属人数
   private String reference;// --证明人
   private String leaveReason;//-离职原因
   private String achievement;//-主要业绩
   private int isOversea;//--海外工作经历 1：是；0：否
   private Tperson person;
public TpWork() {
	super();
	// TODO Auto-generated constructor stub
}
public TpWork(Integer id, String fromYear, String fromMonth, String toYear,
		String toMonth, String company, String industry, int companySize,
		int companyType, String division, String subFunction, String position,
		String responsiblity, String reportLine, int subordinate,
		String reference, String leaveReason, String achievement,
		int isOversea, Tperson person) {
	super();
	this.id = id;
	this.fromYear = fromYear;
	this.fromMonth = fromMonth;
	this.toYear = toYear;
	this.toMonth = toMonth;
	this.company = company;
	this.industry = industry;
	this.companySize = companySize;
	this.companyType = companyType;
	this.division = division;
	this.subFunction = subFunction;
	this.position = position;
	this.responsiblity = responsiblity;
	this.reportLine = reportLine;
	this.subordinate = subordinate;
	this.reference = reference;
	this.leaveReason = leaveReason;
	this.achievement = achievement;
	this.isOversea = isOversea;
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
@Column(name = "from_year", length = 4)
public String getFromYear() {
	return fromYear;
}
public void setFromYear(String fromYear) {
	this.fromYear = fromYear;
}
@Column(name = "from_month", length = 2)
public String getFromMonth() {
	return fromMonth;
}
public void setFromMonth(String fromMonth) {
	this.fromMonth = fromMonth;
}
@Column(name = "to_year", length = 4)
public String getToYear() {
	return toYear;
}
public void setToYear(String toYear) {
	this.toYear = toYear;
}
@Column(name = "to_month", length = 2)
public String getToMonth() {
	return toMonth;
}
public void setToMonth(String toMonth) {
	this.toMonth = toMonth;
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
@Column(name = "sub_function", length=50)
public String getSubFunction() {
	return subFunction;
}
public void setSubFunction(String subFunction) {
	this.subFunction = subFunction;
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
@Column(name = "report_line", length = 50)
public String getReportLine() {
	return reportLine;
}
public void setReportLine(String reportLine) {
	this.reportLine = reportLine;
}
@Column(name = "subordinate", length = 5)
public int getSubordinate() {
	return subordinate;
}
public void setSubordinate(int subordinate) {
	this.subordinate = subordinate;
}
@Column(name = "reference", length = 50)
public String getReference() {
	return reference;
}
public void setReference(String reference) {
	this.reference = reference;
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
@Column(name = "is_oversea", length = 1)
public int getIsOversea() {
	return isOversea;
}
public void setIsOversea(int isOversea) {
	this.isOversea = isOversea;
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
