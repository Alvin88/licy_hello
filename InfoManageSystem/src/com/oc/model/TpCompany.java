package com.oc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.oc.dto.Page;

@Entity
@Table(name = "tp_company")
public class TpCompany extends Page {
	private int id;//11

	/**
	 * 公司全名
	 */
	private String name;
	
	/**
	 * 联系人
	 */
	private String contactMan;
	
	/**
	 * 联系电话
	 */
	private String contactMobile;
	
	/**
	 * 座机
	 */
	private String phone;
	
	/**
	 * 手机
	 */
	private String mobilePhone;
	
	/**
	 * 
	 */
	private String mail;
	
	/**
	 * 公司简介
	 */
	private String description;
	
	/**要证情况
	 * 
	 */
	private String requireCertificate;
	
	/**跟踪记录
	 * 
	 */
	private String traceState;
	
	private int level ;
	
	private  int traceDateCount;
	
	

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactMan() {
		return contactMan;
	}

	public void setContactMan(String contactMan) {
		this.contactMan = contactMan;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequireCertificate() {
		return requireCertificate;
	}

	public void setRequireCertificate(String requireCertificate) {
		this.requireCertificate = requireCertificate;
	}

	public String getTraceState() {
		return traceState;
	}

	public void setTraceState(String traceState) {
		this.traceState = traceState;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getTraceDateCount() {
		return traceDateCount;
	}

	public void setTraceDateCount(int traceDateCount) {
		this.traceDateCount = traceDateCount;
	}
	
	

	
}
