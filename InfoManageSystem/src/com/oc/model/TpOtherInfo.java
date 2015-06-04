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
@Table(name = "tp_otherinfo")
public class TpOtherInfo {
   private Integer id;
   private String personalHobby;//个人爱好
   private String personHonor;//个人荣誉以及奖励
   private String partiGroup;//参加过的团体
   private String specialSkill;//特长
   private String otherSkill;//其他技能
   private String evaluation;//自我评价
   private Tresume resume;

public TpOtherInfo() {
	super();
	// TODO Auto-generated constructor stub
}
public TpOtherInfo(Integer id, String personalHobby, String personHonor,
		String partiGroup, String specialSkill, String otherSkill,
		String evaluation, Tresume resume) {
	super();
	this.id = id;
	this.personalHobby = personalHobby;
	this.personHonor = personHonor;
	this.partiGroup = partiGroup;
	this.specialSkill = specialSkill;
	this.otherSkill = otherSkill;
	this.evaluation = evaluation;
	this.resume = resume;
}
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
@Column(name = "personal_hobby", length = 255)
public String getPersonalHobby() {
	return personalHobby;
}
public void setPersonalHobby(String personalHobby) {
	this.personalHobby = personalHobby;
}
@Column(name = "personal_honor", length = 500)
public String getPersonHonor() {
	return personHonor;
}
public void setPersonHonor(String personHonor) {
	this.personHonor = personHonor;
}
@Column(name = "parti_group", length = 255)
public String getPartiGroup() {
	return partiGroup;
}
public void setPartiGroup(String partiGroup) {
	this.partiGroup = partiGroup;
}
@Column(name = "special_skill", length = 1000)
public String getSpecialSkill() {
	return specialSkill;
}
public void setSpecialSkill(String specialSkill) {
	this.specialSkill = specialSkill;
}
@Column(name = "other_skill", length = 500)
public String getOtherSkill() {
	return otherSkill;
}
public void setOtherSkill(String otherSkill) {
	this.otherSkill = otherSkill;
}
@Column(name = "evaluation", length = 1000)
public String getEvaluation() {
	return evaluation;
}
public void setEvaluation(String evaluation) {
	this.evaluation = evaluation;
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
