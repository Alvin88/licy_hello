package com.oc.dto;

import java.util.Date;

public class ResumeEducation {
	private Integer eduId;
	private Date eduFromDate;//开始日期
	private Date eduToDate;//结束日期
	private String schoolName;//--学校【Type】
	private String subMajor;//--专业
	private int degree;//--学历
	private String edu_detail;// --专业描述
	private String remark;//备注，或是用作他用
	
	private Integer resumeId;//简历ID
	
	
	public ResumeEducation(Integer eduId, Date eduFromDate, Date eduToDate,
			String schoolName, String subMajor, int degree, String edu_detail,
			String remark, Integer resumeId) {
		super();
		this.eduId = eduId;
		this.eduFromDate = eduFromDate;
		this.eduToDate = eduToDate;
		this.schoolName = schoolName;
		this.subMajor = subMajor;
		this.degree = degree;
		this.edu_detail = edu_detail;
		this.remark = remark;
		this.resumeId = resumeId;
	}


	public ResumeEducation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Integer getEduId() {
		return eduId;
	}
	public void setEduId(Integer eduId) {
		this.eduId = eduId;
	}
	public Date getEduFromDate() {
		return eduFromDate;
	}
	public void setEduFromDate(Date eduFromDate) {
		this.eduFromDate = eduFromDate;
	}
	public Date getEduToDate() {
		return eduToDate;
	}
	public void setEduToDate(Date eduToDate) {
		this.eduToDate = eduToDate;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSubMajor() {
		return subMajor;
	}
	public void setSubMajor(String subMajor) {
		this.subMajor = subMajor;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public String getEdu_detail() {
		return edu_detail;
	}
	public void setEdu_detail(String edu_detail) {
		this.edu_detail = edu_detail;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Integer getResumeId() {
		return resumeId;
	}


	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}

	
}
