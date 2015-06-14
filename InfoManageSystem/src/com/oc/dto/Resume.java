package com.oc.dto;

import java.util.Date;
import java.util.List;

public class Resume {
	//分页基本信息
	private Integer page;
	private Integer rows;
	private String sort;
	private String order;
	
	//简历基本信息
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
	
	
	//附带的其他简历信息
	private List<ResumeWork>  workList;//工作经历
	private List<ResumeEducation> eduList;//教育经历
	private List<ResumeProject> projectList;//项目经验
	private List<ResumeLanguage> lanList;//语言水平
	private ResumeOtherInfo otherInfo;//其他信息
	private ResumeJobInten jobInten;//求职意向
	
	
	public Resume() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Integer getIsPublish() {
		return isPublish;
	}

	public void setIsPublish(Integer isPublish) {
		this.isPublish = isPublish;
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


	public String getLoginname() {
		return loginname;
	}


	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}


	public String getLoginpwd() {
		return loginpwd;
	}


	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRealname() {
		return realname;
	}


	public void setRealname(String realname) {
		this.realname = realname;
	}


	public Integer getGender() {
		return gender;
	}


	public void setGender(Integer gender) {
		this.gender = gender;
	}


	public String getJiguan() {
		return jiguan;
	}


	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}


	public String getMinzu() {
		return minzu;
	}


	public void setMinzu(String minzu) {
		this.minzu = minzu;
	}


	public Integer getPoliticalStatus() {
		return politicalStatus;
	}


	public void setPoliticalStatus(Integer politicalStatus) {
		this.politicalStatus = politicalStatus;
	}


	public Integer getStature() {
		return stature;
	}


	public void setStature(Integer stature) {
		this.stature = stature;
	}


	public Integer getMarrige() {
		return marrige;
	}


	public void setMarrige(Integer marrige) {
		this.marrige = marrige;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public Integer getWorkYear() {
		return workYear;
	}


	public void setWorkYear(Integer workYear) {
		this.workYear = workYear;
	}


	public Integer getCardType() {
		return cardType;
	}


	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}


	public String getIdNumber() {
		return idNumber;
	}


	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public Integer getHighestDegree() {
		return highestDegree;
	}


	public void setHighestDegree(Integer highestDegree) {
		this.highestDegree = highestDegree;
	}


	public String getCurrSituation() {
		return currSituation;
	}


	public void setCurrSituation(String currSituation) {
		this.currSituation = currSituation;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getCompanyTel() {
		return companyTel;
	}


	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}


	public String getHomeTel() {
		return homeTel;
	}


	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}

	public String getQqId() {
		return qqId;
	}

	public void setQqId(String qqId) {
		this.qqId = qqId;
	}





	public String getHomePage() {
		return homePage;
	}


	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getResumeKey() {
		return resumeKey;
	}


	public void setResumeKey(String resumeKey) {
		this.resumeKey = resumeKey;
	}


	public String getCreateUserName() {
		return createUserName;
	}


	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}


	public String getCreateUserId() {
		return createUserId;
	}


	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}


	public Date getCdate() {
		return cdate;
	}


	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}


	public Date getMdate() {
		return mdate;
	}


	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}


	public List<ResumeWork> getWorkList() {
		return workList;
	}


	public void setWorkList(List<ResumeWork> workList) {
		this.workList = workList;
	}


	public List<ResumeEducation> getEduList() {
		return eduList;
	}


	public void setEduList(List<ResumeEducation> eduList) {
		this.eduList = eduList;
	}


	public List<ResumeProject> getProjectList() {
		return projectList;
	}


	public void setProjectList(List<ResumeProject> projectList) {
		this.projectList = projectList;
	}


	public List<ResumeLanguage> getLanList() {
		return lanList;
	}


	public void setLanList(List<ResumeLanguage> lanList) {
		this.lanList = lanList;
	}


	public ResumeOtherInfo getOtherInfo() {
		return otherInfo;
	}


	public void setOtherInfo(ResumeOtherInfo otherInfo) {
		this.otherInfo = otherInfo;
	}


	public ResumeJobInten getJobInten() {
		return jobInten;
	}


	public void setJobInten(ResumeJobInten jobInten) {
		this.jobInten = jobInten;
	}
	
	
	
}
