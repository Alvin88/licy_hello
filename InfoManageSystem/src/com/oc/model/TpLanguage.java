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
@Table(name = "tp_language")
public class TpLanguage {
   private Integer id;
   private Integer languageCategory;//--语言类别
   private String languageLevel;//语言等级
   private Integer master;//--掌握程度
   private Integer rwAbility;//--读写能力
   private Integer lsAbility;// --听说能力
   private String supplement;//语言其他内容补充，例如语言类别为英语的时候，补充toefl,gre,gmat,ielts等分数

   private Tresume resume;

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
@Column(name = "language_level", length = 3)
public String getLanguageLevel() {
	return languageLevel;
}
public void setLanguageLevel(String languageLevel) {
	this.languageLevel = languageLevel;
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
@Column(name = "supplement", length = 255)
public String getSupplement() {
	return supplement;
}
public void setSupplement(String supplement) {
	this.supplement = supplement;
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
