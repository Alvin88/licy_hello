package com.oc.dto;

import java.util.Date;

public class Talent {
	    //分页基本信息
		private Integer page;
		private Integer rows;
		private String sort;
		private String order;
		
		  private Integer id;//人才id
		   private String code;//人才编号
		   private String name;//人才名称
		   private Integer gender;//人才性别 0表示男，1表示女
		   private String sbArea;//社保所在地区
		   private String mobile;//电话号码
		   private String email;//电子邮箱或QQ
		   private String address;//详细地址
		   private String qq;//QQ号码
		   private String certificateType;//证书类型
		   private String profession;//专业（建筑工程，机电等）
		   private String registerResult;//注册情况
		   private String remark;//备注信息
		   private String traceRecord;//跟进记录
		   private Date expireDate;//人才证书过期日期
		   private Integer isPublish;//人才显示状态，0表示只能录入业务员查看，1表示其他业务员都可以查看
		  
		   private Date birthday;//生日，暂时无用，保留
		   private Integer highestDegree;//最高学历，暂时无用，保留
		   private Integer auditStatus;//审核状态，暂时没用，后续保留
		   
		   
		   
		public Talent() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Talent(Integer page, Integer rows, String sort, String order,
				Integer id, String code, String name, Integer gender,
				String sbArea, String mobile, String email, String address,
				String qq, String certificateType, String profession,
				String registerResult, String remark, String traceRecord,
				Date expireDate, Integer isPublish, Date birthday,
				Integer highestDegree, Integer auditStatus) {
			super();
			this.page = page;
			this.rows = rows;
			this.sort = sort;
			this.order = order;
			this.id = id;
			this.code = code;
			this.name = name;
			this.gender = gender;
			this.sbArea = sbArea;
			this.mobile = mobile;
			this.email = email;
			this.address = address;
			this.qq = qq;
			this.certificateType = certificateType;
			this.profession = profession;
			this.registerResult = registerResult;
			this.remark = remark;
			this.traceRecord = traceRecord;
			this.expireDate = expireDate;
			this.isPublish = isPublish;
			this.birthday = birthday;
			this.highestDegree = highestDegree;
			this.auditStatus = auditStatus;
		}
		public Integer getPage() {
			return page;
		}
		public void setPage(Integer page) {
			this.page = page;
		}
		public Integer getRows() {
			return rows;
		}
		public void setRows(Integer rows) {
			this.rows = rows;
		}
		public String getSort() {
			return sort;
		}
		public void setSort(String sort) {
			this.sort = sort;
		}
		public String getOrder() {
			return order;
		}
		public void setOrder(String order) {
			this.order = order;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getGender() {
			return gender;
		}
		public void setGender(Integer gender) {
			this.gender = gender;
		}
		public String getSbArea() {
			return sbArea;
		}
		public void setSbArea(String sbArea) {
			this.sbArea = sbArea;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getQq() {
			return qq;
		}
		public void setQq(String qq) {
			this.qq = qq;
		}
		public String getCertificateType() {
			return certificateType;
		}
		public void setCertificateType(String certificateType) {
			this.certificateType = certificateType;
		}
		public String getProfession() {
			return profession;
		}
		public void setProfession(String profession) {
			this.profession = profession;
		}
		public String getRegisterResult() {
			return registerResult;
		}
		public void setRegisterResult(String registerResult) {
			this.registerResult = registerResult;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public String getTraceRecord() {
			return traceRecord;
		}
		public void setTraceRecord(String traceRecord) {
			this.traceRecord = traceRecord;
		}
		public Date getExpireDate() {
			return expireDate;
		}
		public void setExpireDate(Date expireDate) {
			this.expireDate = expireDate;
		}
		public Integer getIsPublish() {
			return isPublish;
		}
		public void setIsPublish(Integer isPublish) {
			this.isPublish = isPublish;
		}
		public Date getBirthday() {
			return birthday;
		}
		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
		public Integer getHighestDegree() {
			return highestDegree;
		}
		public void setHighestDegree(Integer highestDegree) {
			this.highestDegree = highestDegree;
		}
		public Integer getAuditStatus() {
			return auditStatus;
		}
		public void setAuditStatus(Integer auditStatus) {
			this.auditStatus = auditStatus;
		}
		   
		   
}
