package com.oc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ttalent")
public class Ttalent {
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
   private Date createDate;//人才录入时间
   private Date modifyDate;//人才信息修改时间
   private String createUserId;//录入业务员id
   private String createUserName;//录入业务员名称
   private Date traceRecordModifyDate;//跟进记录修改时间(为了记录那个7天限制)
   private Integer isPublish;//人才显示状态，0表示只能录入业务员查看，1表示其他业务员都可以查看
  
   private Date birthday;//生日，暂时无用，保留
   private Integer highestDegree;//最高学历，暂时无用，保留
   private Integer auditStatus;//审核状态，暂时没用，后续保留
public Ttalent() {
	super();
	// TODO Auto-generated constructor stub
}
public Ttalent(Integer id, String code, String name, Integer gender,
		String sbArea, String mobile, String email, String address, String qq,
		String certificateType, String profession, String registerResult,
		String remark, String traceRecord, Date expireDate, Date createDate,
		Date modifyDate, String createUserId, String creatUserName,
		Date traceRecordModifyDate, Integer isPublish, Date birthday,
		Integer highestDegree, Integer auditStatus) {
	super();
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
	this.createDate = createDate;
	this.modifyDate = modifyDate;
	this.createUserId = createUserId;
	this.createUserName = creatUserName;
	this.traceRecordModifyDate = traceRecordModifyDate;
	this.isPublish = isPublish;
	this.birthday = birthday;
	this.highestDegree = highestDegree;
	this.auditStatus = auditStatus;
}

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}

@Column(name = "code", length = 36)
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
@Column(name = "name", length = 20)
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Column(name = "gender", length = 1)
public Integer getGender() {
	return gender;
}
public void setGender(Integer gender) {
	this.gender = gender;
}
@Column(name = "sb_area", length = 100)
public String getSbArea() {
	return sbArea;
}
public void setSbArea(String sbArea) {
	this.sbArea = sbArea;
}
@Column(name = "mobile", length = 20)
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
@Column(name = "email", length = 100)
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Column(name = "address", length = 255)
public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}
@Column(name = "qq", length = 30)
public String getQq() {
	return qq;
}
public void setQq(String qq) {
	this.qq = qq;
}
@Column(name = "certificate_type", length = 50)
public String getCertificateType() {
	return certificateType;
}
public void setCertificateType(String certificateType) {
	this.certificateType = certificateType;
}
@Column(name = "profession", length = 50)
public String getProfession() {
	return profession;
}
public void setProfession(String profession) {
	this.profession = profession;
}
@Column(name = "register_result", length = 20)
public String getRegisterResult() {
	return registerResult;
}
public void setRegisterResult(String registerResult) {
	this.registerResult = registerResult;
}
@Column(name = "remark", length = 255)
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
@Column(name = "trace_record", length = 100)
public String getTraceRecord() {
	return traceRecord;
}
public void setTraceRecord(String traceRecord) {
	this.traceRecord = traceRecord;
}
@Column(name = "expire_date")
public Date getExpireDate() {
	return expireDate;
}
public void setExpireDate(Date expireDate) {
	this.expireDate = expireDate;
}
@Column(name = "create_date")
public Date getCreateDate() {
	return createDate;
}
public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}
@Column(name = "modify_date")
public Date getModifyDate() {
	return modifyDate;
}
public void setModifyDate(Date modifyDate) {
	this.modifyDate = modifyDate;
}
@Column(name = "create_user_id" , length = 36)
public String getCreateUserId() {
	return createUserId;
}
public void setCreateUserId(String createUserId) {
	this.createUserId = createUserId;
}
@Column(name = "create_user_name" , length = 36)
public String getCreateUserName() {
	return createUserName;
}
public void setCreateUserName(String createUserName) {
	this.createUserName = createUserName;
}
@Column(name = "trace_record_modifydate" )
public Date getTraceRecordModifyDate() {
	return traceRecordModifyDate;
}
public void setTraceRecordModifyDate(Date traceRecordModifyDate) {
	this.traceRecordModifyDate = traceRecordModifyDate;
}
@Column(name = "is_publish" , length = 1)
public Integer getIsPublish() {
	return isPublish;
}
public void setIsPublish(Integer isPublish) {
	this.isPublish = isPublish;
}
@Column(name = "birthday")
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
@Column(name = "highest_degree" , length = 2)
public Integer getHighestDegree() {
	return highestDegree;
}
public void setHighestDegree(Integer highestDegree) {
	this.highestDegree = highestDegree;
}
@Column(name = "audit_status" , length = 2)
public Integer getAuditStatus() {
	return auditStatus;
}
public void setAuditStatus(Integer auditStatus) {
	this.auditStatus = auditStatus;
}
   
   
}
