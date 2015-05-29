package com.oc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "tp_education")
public class TpEducation {
	private Integer id;
	private String fromYear;//--时间-从年
	private String fromMonth;// --时间-从月
	private String toYear;// --时间-到年
	private String toMonth;//--时间-到月
	private String schoolName;//--学校【Type】
	private String subMajor;//--专业
	private String moreMajor;// --更多专业
	private int degree;//--学历
	private String edu_detail;// --专业描述
	private int isOversea;// --海外学习经历 1:是；0：否
	private Tperson person;
	public TpEducation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TpEducation(Integer id, String fromYear, String fromMonth,
			String toYear, String toMonth, String schoolName, String subMajor,
			String moreMajor, int degree, String edu_detail, int isOversea,
			Tperson person) {
		super();
		this.id = id;
		this.fromYear = fromYear;
		this.fromMonth = fromMonth;
		this.toYear = toYear;
		this.toMonth = toMonth;
		this.schoolName = schoolName;
		this.subMajor = subMajor;
		this.moreMajor = moreMajor;
		this.degree = degree;
		this.edu_detail = edu_detail;
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
	@Column(name = "school_name", length = 100)
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	@Column(name = "sub_major", length = 100)
	public String getSubMajor() {
		return subMajor;
	}
	public void setSubMajor(String subMajor) {
		this.subMajor = subMajor;
	}
	@Column(name = "more_major", length = 100)
	public String getMoreMajor() {
		return moreMajor;
	}
	public void setMoreMajor(String moreMajor) {
		this.moreMajor = moreMajor;
	}
	@Column(name = "degree", length = 3)
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	@Type(type="text")
	@Column(name = "edu_detail")
	public String getEdu_detail() {
		return edu_detail;
	}
	public void setEdu_detail(String edu_detail) {
		this.edu_detail = edu_detail;
	}
	@Column(name = "is_oversea", length = 1)
	public int getIsOversea() {
		return isOversea;
	}
	public void setIsOversea(int isOversea) {
		this.isOversea = isOversea;
	}
	@ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch = FetchType.LAZY)
	public Tperson getPerson() {
		return person;
	}
	public void setPerson(Tperson person) {
		this.person = person;
	}

}
