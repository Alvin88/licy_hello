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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tperson")
public class Tperson {
	private Integer id;//11
	private String email;//80
	private String name;//40
	private String pwd;//40
	private String QQID;//20
	private String remark;//100
	private Date cdate;
	private Date mdate;
	private TpResume tpResume;
	private Set<TpWork> tpWorkSet;
	private Set<TpLanguage> tpLanuageSet;
	private Set<TpLanCategory> tpLanCateSet;
	private Set<TpJobIntension> tpJobIntenSet;
	private Set<TpEducation> tpEduSet;
	
	
	public Tperson() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	 public Tperson(Integer id, String email, String name, String pwd,
			String qQID, String remark, Date cdate, Date mdate,
			TpResume tpResume, Set<TpWork> tpWorkSet,
			Set<TpLanguage> tpLanuageSet, Set<TpLanCategory> tpLanCateSet,
			Set<TpJobIntension> tpJobIntenSet, Set<TpEducation> tpEduSet) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.pwd = pwd;
		QQID = qQID;
		this.remark = remark;
		this.cdate = cdate;
		this.mdate = mdate;
		this.tpResume = tpResume;
		this.tpWorkSet = tpWorkSet;
		this.tpLanuageSet = tpLanuageSet;
		this.tpLanCateSet = tpLanCateSet;
		this.tpJobIntenSet = tpJobIntenSet;
		this.tpEduSet = tpEduSet;
	}





	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "email", length = 80)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "name", length = 40)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "pwd", length = 40)
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Column(name = "QQID", length = 20)
	public String getQQID() {
		return QQID;
	}
	public void setQQID(String qQID) {
		QQID = qQID;
	}
	@Column(name = "remark", length = 100)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name="cdate",length=19)
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	@Column(name="mdate",length=19)
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	
	@OneToOne(optional = true, cascade = CascadeType.ALL, mappedBy = "person")
	public TpResume getTpResume() {
		return tpResume;
	}



	public void setTpResume(TpResume tpResume) {
		this.tpResume = tpResume;
	}


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
	public Set<TpWork> getTpWorkSet() {
		return tpWorkSet;
	}



	public void setTpWorkSet(Set<TpWork> tpWorkSet) {
		this.tpWorkSet = tpWorkSet;
	}


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
	public Set<TpLanguage> getTpLanuageSet() {
		return tpLanuageSet;
	}



	public void setTpLanuageSet(Set<TpLanguage> tpLanuageSet) {
		this.tpLanuageSet = tpLanuageSet;
	}


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
	public Set<TpLanCategory> getTpLanCateSet() {
		return tpLanCateSet;
	}



	public void setTpLanCateSet(Set<TpLanCategory> tpLanCateSet) {
		this.tpLanCateSet = tpLanCateSet;
	}


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
	public Set<TpJobIntension> getTpJobIntenSet() {
		return tpJobIntenSet;
	}



	public void setTpJobIntenSet(Set<TpJobIntension> tpJobIntenSet) {
		this.tpJobIntenSet = tpJobIntenSet;
	}


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
	public Set<TpEducation> getTpEduSet() {
		return tpEduSet;
	}


	
	public void setTpEduSet(Set<TpEducation> tpEduSet) {
		this.tpEduSet = tpEduSet;
	}


	
}
