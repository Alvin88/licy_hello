package com.oc.dto;

public class ResumeLanguage {
	   private Integer lanId;
	   private Integer languageCategory;//--语言类别
	   private String languageLevel;//语言等级
	   private Integer master;//--掌握程度
	   private Integer rwAbility;//--读写能力
	   private Integer lsAbility;// --听说能力
	   private String supplement;//语言其他内容补充，例如语言类别为英语的时候，补充toefl,gre,gmat,ielts等分数
	
	   private Integer resumeId;//简历ID
	   
	public ResumeLanguage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ResumeLanguage(Integer lanId, Integer languageCategory,
			String languageLevel, Integer master, Integer rwAbility,
			Integer lsAbility, String supplement, Integer resumeId) {
		super();
		this.lanId = lanId;
		this.languageCategory = languageCategory;
		this.languageLevel = languageLevel;
		this.master = master;
		this.rwAbility = rwAbility;
		this.lsAbility = lsAbility;
		this.supplement = supplement;
		this.resumeId = resumeId;
	}

	public Integer getLanId() {
		return lanId;
	}
	public void setLanId(Integer lanId) {
		this.lanId = lanId;
	}
	public Integer getLanguageCategory() {
		return languageCategory;
	}
	public void setLanguageCategory(Integer languageCategory) {
		this.languageCategory = languageCategory;
	}
	public String getLanguageLevel() {
		return languageLevel;
	}
	public void setLanguageLevel(String languageLevel) {
		this.languageLevel = languageLevel;
	}
	public Integer getMaster() {
		return master;
	}
	public void setMaster(Integer master) {
		this.master = master;
	}
	public Integer getRwAbility() {
		return rwAbility;
	}
	public void setRwAbility(Integer rwAbility) {
		this.rwAbility = rwAbility;
	}
	public Integer getLsAbility() {
		return lsAbility;
	}
	public void setLsAbility(Integer lsAbility) {
		this.lsAbility = lsAbility;
	}
	public String getSupplement() {
		return supplement;
	}
	public void setSupplement(String supplement) {
		this.supplement = supplement;
	}

	public Integer getResumeId() {
		return resumeId;
	}

	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}
  
	   
}
