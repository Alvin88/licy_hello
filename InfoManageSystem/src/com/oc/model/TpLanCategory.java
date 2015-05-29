package com.oc.model;

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

@Entity
@Table(name = "tp_lancategory")
public class TpLanCategory {
   private Integer id;
   private Integer languageCategory;//--语言类别
   private Integer master;//--掌握程度
   private Integer rwAbility;//--读写能力
   private Integer lsAbility;// --听说能力
   private Tperson person;//
public TpLanCategory() {
	super();
	// TODO Auto-generated constructor stub
}
public TpLanCategory(Integer id, Integer languageCategory, Integer master,
		Integer rwAbility, Integer lsAbility, Tperson person) {
	super();
	this.id = id;
	this.languageCategory = languageCategory;
	this.master = master;
	this.rwAbility = rwAbility;
	this.lsAbility = lsAbility;
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
@Column(name = "language_category", length = 3)
public Integer getLanguageCategory() {
	return languageCategory;
}
public void setLanguageCategory(Integer languageCategory) {
	this.languageCategory = languageCategory;
}
@Column(name = "master", length = 2)
public Integer getMaster() {
	return master;
}
public void setMaster(Integer master) {
	this.master = master;
}
@Column(name = "rw_ability", length = 2)
public Integer getRwAbility() {
	return rwAbility;
}
public void setRwAbility(Integer rwAbility) {
	this.rwAbility = rwAbility;
}
@Column(name = "ls_ability", length = 2)
public Integer getLsAbility() {
	return lsAbility;
}
public void setLsAbility(Integer lsAbility) {
	this.lsAbility = lsAbility;
}
@ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch = FetchType.LAZY)
@JoinColumn(name = "person_id")
public Tperson getPerson() {
	return person;
}
public void setPerson(Tperson person) {
	this.person = person;
}
   
}
