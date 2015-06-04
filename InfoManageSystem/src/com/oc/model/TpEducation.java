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
@Table(name = "tp_education")
public class TpEducation {
	private Integer id;
	private Date eduFromDate;//开始日期
	private Date eduToDate;//结束日期

	private String schoolName;//--学校【Type】
	private String subMajor;//--专业
	private int degree;//--学历
	private String edu_detail;// --专业描述

	private String remark;//备注，或是用作他用
	private Tresume resume;//所属简历
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "edu_from_date")
	public Date getEduFromDate() {
		return eduFromDate;
	}
	public void setEduFromDate(Date eduFromDate) {
		this.eduFromDate = eduFromDate;
	}
	@Column(name = "edu_to_date")
	public Date getEduToDate() {
		return eduToDate;
	}
	public void setEduToDate(Date eduToDate) {
		this.eduToDate = eduToDate;
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
	@Column(name = "remark", length = 255)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
