package com.oc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tp_resume")
public class TpResume {
	private int Id;//11
	private String name;// --姓名
	private int gender;// --性别：0：男；1：女
	private String yearOfBirth;//4--出生日期-年
	private String monthOfBirth;//2出生日期-月
	private String dayOfBirth;//2--出生日期-日
	private int workYear;//--工作年限
	private int cardType;//--证件类型
	private String idNumber;//--证件号
	private String location;//--居住地【Type】
	private String email;// --Email
	private int salary;//--目前年薪
	private int currType;//  --币种
	private String currSituation;//--求职状态 
	private String mobile;//--手机号码
	private String companyTel;//--公司电话
	private String homeTel;//--家庭电话
	private String hukou;//--户口【Type】
	private String resumeKey;//--关键字
	private String nationality;//--国家或地区
	private int stature;// --身高
	private int marrige;//--婚姻状况：0：未婚；1：已婚；2：保密
	private String QQID;// --QQ号
	private String zipCode;// --邮编
	private String homePage;//--个人主页
	private String address;//--地址
	private int workExperience;//--工作经验：0：有；1：无
	private Tperson person;
	
	
	
	public TpResume() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TpResume(int id, String name, int gender, String yearOfBirth,
			String monthOfBirth, String dayOfBirth, int workYear, int cardType,
			String idNumber, String location, String email, int salary,
			int currType, String currSituation, String mobile,
			String companyTel, String homeTel, String hukou, String resumeKey,
			String nationality, int stature, int marrige, String qQID,
			String zipCode, String homePage, String address,
			int workExperience,  Tperson person) {
		super();
		Id = id;
		this.name = name;
		this.gender = gender;
		this.yearOfBirth = yearOfBirth;
		this.monthOfBirth = monthOfBirth;
		this.dayOfBirth = dayOfBirth;
		this.workYear = workYear;
		this.cardType = cardType;
		this.idNumber = idNumber;
		this.location = location;
		this.email = email;
		this.salary = salary;
		this.currType = currType;
		this.currSituation = currSituation;
		this.mobile = mobile;
		this.companyTel = companyTel;
		this.homeTel = homeTel;
		this.hukou = hukou;
		this.resumeKey = resumeKey;
		this.nationality = nationality;
		this.stature = stature;
		this.marrige = marrige;
		QQID = qQID;
		this.zipCode = zipCode;
		this.homePage = homePage;
		this.address = address;
		this.workExperience = workExperience;
		this.person = person;
	}
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	@Column(name = "name", length = 20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "gender", length = 2)
	public int getGender() {
		return gender;
	}
	
	public void setGender(int gender) {
		this.gender = gender;
	}
	@Column(name = "year_birthday", length = 4)
	public String getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	@Column(name = "month_birthday", length = 2)
	public String getMonthOfBirth() {
		return monthOfBirth;
	}
	public void setMonthOfBirth(String monthOfBirth) {
		this.monthOfBirth = monthOfBirth;
	}
	@Column(name = "day_birthday", length = 2)
	public String getDayOfBirth() {
		return dayOfBirth;
	}
	public void setDayOfBirth(String dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	@Column(name = "work_year", length = 3)
	public int getWorkYear() {
		return workYear;
	}
	public void setWorkYear(int workYear) {
		this.workYear = workYear;
	}
	@Column(name = "card_type", length = 2)
	public int getCardType() {
		return cardType;
	}
	public void setCardType(int cardType) {
		this.cardType = cardType;
	}
	@Column(name = "id_number", length = 25)
	public String getIdNumber() {
		return idNumber;
	}
	
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	@Column(name = "location", length = 150)
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Column(name = "email", length = 100)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "salary", length = 8)
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Column(name = "curr_type", length = 3)
	public int getCurrType() {
		return currType;
	}
	public void setCurrType(int currType) {
		this.currType = currType;
	}
	@Column(name = "curr_situation", length = 40)
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
	@Column(name = "hukou", length = 150)
	public String getHukou() {
		return hukou;
	}
	public void setHukou(String hukou) {
		this.hukou = hukou;
	}
	@Column(name = "resume_key", length = 50)
	public String getResumeKey() {
		return resumeKey;
	}
	public void setResumeKey(String resumeKey) {
		this.resumeKey = resumeKey;
	}
	@Column(name = "nationality", length = 100)
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	@Column(name = "stature", length = 3)
	public int getStature() {
		return stature;
	}
	public void setStature(int stature) {
		this.stature = stature;
	}
	@Column(name = "marrige", length = 1)
	public int getMarrige() {
		return marrige;
	}
	public void setMarrige(int marrige) {
		this.marrige = marrige;
	}
	@Column(name = "QQID", length =20)		
	public String getQQID() {
		return QQID;
	}
	public void setQQID(String qQID) {
		QQID = qQID;
	}
	@Column(name = "zip_code", length = 10)
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Column(name = "home_page", length = 255)
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	@Column(name = "address", length = 255)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "work_experience", length = 3)
	public int getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(int workExperience) {
		this.workExperience = workExperience;
	}
	@OneToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	public Tperson getPerson() {
		return person;
	}
	public void setPerson(Tperson person) {
		this.person = person;
	}

	
}
