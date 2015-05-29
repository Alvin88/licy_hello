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
   private Integer englishLevel;//--英语等级
   private String toefl;//--TOEFL
   private String gre;//--GRE--GRE
   private Integer jpLevel;// --日语等级
   private String gmat;// --GMAT
   private String ielts;//--IELTS
   private Tperson person;
public TpLanguage() {
	super();
	// TODO Auto-generated constructor stub
}
public TpLanguage(Integer id, Integer englishLevel, String toefl, String gre,
		Integer jpLevel, String gmat, String ielts, Tperson person) {
	super();
	this.id = id;
	this.englishLevel = englishLevel;
	this.toefl = toefl;
	this.gre = gre;
	this.jpLevel = jpLevel;
	this.gmat = gmat;
	this.ielts = ielts;
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
@Column(name = "english_level", length = 2)
public Integer getEnglishLevel() {
	return englishLevel;
}
public void setEnglishLevel(Integer englishLevel) {
	this.englishLevel = englishLevel;
}
@Column(name = "toefl", length = 3)
public String getToefl() {
	return toefl;
}
public void setToefl(String toefl) {
	this.toefl = toefl;
}
@Column(name = "gre", length = 3)
public String getGre() {
	return gre;
}
public void setGre(String gre) {
	this.gre = gre;
}
@Column(name = "jp_level", length = 2)
public Integer getJpLevel() {
	return jpLevel;
}
public void setJpLevel(Integer jpLevel) {
	this.jpLevel = jpLevel;
}
@Column(name = "gmat", length = 3)
public String getGmat() {
	return gmat;
}
public void setGmat(String gmat) {
	this.gmat = gmat;
}
@Column(name = "ielts", length = 4)
public String getIelts() {
	return ielts;
}
public void setIelts(String ielts) {
	this.ielts = ielts;
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
