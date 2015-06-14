package com.oc.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "tresume")
public class Tresume {
	private Integer id;//11
	private String code;//简历编码
	//登录相关的信息
	private String loginname;//登录名称
	private String loginpwd;//登录密码
	private String email;// 验证邮件
   
	//个人基本信息
	private String realname;// --真实姓名
	private Integer gender;// --性别：0：男；1：女
	private String jiguan;//籍贯
	private String minzu;//民族
	private Integer politicalStatus;//政治面貌
	private Integer stature;// 身高
	private Integer marrige;//婚姻状况：0：未婚；1：已婚；2：保密
	private Date birthday;//出生日期
	private Integer workYear;//工作年限
	private Integer cardType;//证件类型
	private String idNumber;//证件号
	private String location;//目前所在地
	private String zipCode;// 邮编
    private String photo;//个人照片
    private Integer highestDegree;//最高学历

	private String currSituation;//--求职状态
	
	//联系相关的信息
	private String mobile;//--手机号码
	private String companyTel;//--公司电话
	private String homeTel;//--家庭电话
	private String qqId;// --QQ号
	private String homePage;//--个人主页
	private String address;//--详细地址
	
	
	private String resumeKey;//--关键字
	
	//创建相关的信息
	private String createUserName;//创建者名称
	private String createUserId;//创建者ID
	private Date cdate;
	private Date mdate;
	
	//简历状态相关系
	private Integer auditStatus;//简历审核状态信息0表示未审核1表示审核通过，2表示审核不通过
	private Integer isPublish;//简历发布信息，0表示发布，1表示未发布
	
	//外键相关的信息
	private Set<TpWork> tpWorkSet;
	private Set<TpLanguage> tpLanuageSet;
	private Set<TpJobIntension> tpJobIntenSet;
	private Set<TpEducation> tpEduSet;
	private Set<TpProject> tpProjectSet;
	private Set<TpOtherInfo> tpOtherInfoSet;
	
	
	
	public Tresume() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	


	



	public Tresume(Integer id, String code, String loginname, String loginpwd,
			String email, String realname, Integer gender, String jiguan,
			String minzu, Integer politicalStatus, Integer stature,
			Integer marrige, Date birthday, Integer workYear, Integer cardType,
			String idNumber, String location, String zipCode, String photo,
			Integer highestDegree, String currSituation, String mobile,
			String companyTel, String homeTel, String qqId, String homePage,
			String address, String resumeKey, String createUserName,
			String createUserId, Date cdate, Date mdate, Integer auditStatus,
			Integer isPublish, Set<TpWork> tpWorkSet,
			Set<TpLanguage> tpLanuageSet, Set<TpJobIntension> tpJobIntenSet,
			Set<TpEducation> tpEduSet, Set<TpProject> tpProjectSet,
			Set<TpOtherInfo> tpOtherInfoSet) {
		super();
		this.id = id;
		this.code = code;
		this.loginname = loginname;
		this.loginpwd = loginpwd;
		this.email = email;
		this.realname = realname;
		this.gender = gender;
		this.jiguan = jiguan;
		this.minzu = minzu;
		this.politicalStatus = politicalStatus;
		this.stature = stature;
		this.marrige = marrige;
		this.birthday = birthday;
		this.workYear = workYear;
		this.cardType = cardType;
		this.idNumber = idNumber;
		this.location = location;
		this.zipCode = zipCode;
		this.photo = photo;
		this.highestDegree = highestDegree;
		this.currSituation = currSituation;
		this.mobile = mobile;
		this.companyTel = companyTel;
		this.homeTel = homeTel;
		this.qqId = qqId;
		this.homePage = homePage;
		this.address = address;
		this.resumeKey = resumeKey;
		this.createUserName = createUserName;
		this.createUserId = createUserId;
		this.cdate = cdate;
		this.mdate = mdate;
		this.auditStatus = auditStatus;
		this.isPublish = isPublish;
		this.tpWorkSet = tpWorkSet;
		this.tpLanuageSet = tpLanuageSet;
		this.tpJobIntenSet = tpJobIntenSet;
		this.tpEduSet = tpEduSet;
		this.tpProjectSet = tpProjectSet;
		this.tpOtherInfoSet = tpOtherInfoSet;
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
	@Column(name = "login_name", length = 40)
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	@Column(name = "login_pwd", length = 40)
	public String getLoginpwd() {
		return loginpwd;
	}
	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}
	@Column(name = "email", length = 100)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "real_name", length = 20)
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	@Column(name = "gender", length = 1)
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	@Column(name = "jiguan", length = 40)
	public String getJiguan() {
		return jiguan;
	}
	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}
	@Column(name = "minzu", length = 30)
	public String getMinzu() {
		return minzu;
	}
	public void setMinzu(String minzu) {
		this.minzu = minzu;
	}
	@Column(name = "political_status", length = 2)
	public Integer getPoliticalStatus() {
		return politicalStatus;
	}
	public void setPoliticalStatus(Integer politicalStatus) {
		this.politicalStatus = politicalStatus;
	}
	@Column(name = "stature", length = 3)
	public Integer getStature() {
		return stature;
	}
	public void setStature(Integer stature) {
		this.stature = stature;
	}
	@Column(name = "marriage", length = 3)
	public Integer getMarrige() {
		return marrige;
	}
	public void setMarrige(Integer marrige) {
		this.marrige = marrige;
	}
	@Column(name = "birthday")
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Column(name = "work_year", length = 2)
	public Integer getWorkYear() {
		return workYear;
	}
	public void setWorkYear(Integer workYear) {
		this.workYear = workYear;
	}
	@Column(name = "card_type", length = 2)
	public Integer getCardType() {
		return cardType;
	}
	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}
	@Column(name = "card_number", length = 50)
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	@Column(name = "location", length = 50)
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	@Column(name = "zipcode", length = 10)
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Column(name = "photo", length = 100)
	public String getPhoto() {
		return photo;
	}
	@Column(name = "highestDegree", length = 2)
	public Integer getHighestDegree() {
		return highestDegree;
	}
	public void setHighestDegree(Integer highestDegree) {
		this.highestDegree = highestDegree;
	}




	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Column(name = "cur_situation", length = 20)
	public String getCurrSituation() {
		return currSituation;
	}
	public void setCurrSituation(String currSituation) {
		this.currSituation = currSituation;
	}
	@Column(name = "mobile", length = 20)
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Column(name = "company_tel", length = 20)
	public String getCompanyTel() {
		return companyTel;
	}
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	@Column(name = "home_tel", length = 20)
	public String getHomeTel() {
		return homeTel;
	}
	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}
	@Column(name = "qq_id", length = 30)
	public String getQqId() {
		return qqId;
	}
	public void setQqId(String qqId) {
		this.qqId = qqId;
	}
	@Column(name = "home_page", length = 120)
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	@Column(name = "address", length = 100)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "resume_key", length = 255)
	public String getResumeKey() {
		return resumeKey;
	}
	public void setResumeKey(String resumeKey) {
		this.resumeKey = resumeKey;
	}
	@Column(name = "create_user_name", length = 50)
	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	@Column(name = "create_user_id", length = 36)
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	@Column(name = "cdate")
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	@Column(name = "mdate")
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	@Column(name = "audit_status", length = 255)
	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	@Column(name = "is_publish", length = 255)
	public Integer getIsPublish() {
		return isPublish;
	}

	public void setIsPublish(Integer isPublish) {
		this.isPublish = isPublish;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "resume")
	public Set<TpWork> getTpWorkSet() {
		return tpWorkSet;
	}
	public void setTpWorkSet(Set<TpWork> tpWorkSet) {
		this.tpWorkSet = tpWorkSet;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "resume")
	public Set<TpLanguage> getTpLanuageSet() {
		return tpLanuageSet;
	}
	public void setTpLanuageSet(Set<TpLanguage> tpLanuageSet) {
		this.tpLanuageSet = tpLanuageSet;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "resume")
	public Set<TpJobIntension> getTpJobIntenSet() {
		return tpJobIntenSet;
	}

	public void setTpJobIntenSet(Set<TpJobIntension> tpJobIntenSet) {
		this.tpJobIntenSet = tpJobIntenSet;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "resume")
	public Set<TpEducation> getTpEduSet() {
		return tpEduSet;
	}
	public void setTpEduSet(Set<TpEducation> tpEduSet) {
		this.tpEduSet = tpEduSet;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "resume")
	public Set<TpProject> getTpProjectSet() {
		return tpProjectSet;
	}
	public void setTpProjectSet(Set<TpProject> tpProjectSet) {
		this.tpProjectSet = tpProjectSet;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "resume")
	public Set<TpOtherInfo> getTpOtherInfoSet() {
		return tpOtherInfoSet;
	}

	public void setTpOtherInfoSet(Set<TpOtherInfo> tpOtherInfoSet) {
		this.tpOtherInfoSet = tpOtherInfoSet;
	}

	
	
}
