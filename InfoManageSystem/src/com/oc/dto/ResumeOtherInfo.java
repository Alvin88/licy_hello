package com.oc.dto;


public class ResumeOtherInfo {
	   private Integer otherId;
	   private String personalHobby;//个人爱好
	   private String personHonor;//个人荣誉以及奖励
	   private String partiGroup;//参加过的团体
	   private String specialSkill;//特长
	   private String otherSkill;//其他技能
	   private String evaluation;//自我评价
	   
	   private Integer resumeId;//简历ID
	public ResumeOtherInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ResumeOtherInfo(Integer otherId, String personalHobby,
			String personHonor, String partiGroup, String specialSkill,
			String otherSkill, String evaluation, Integer resumeId) {
		super();
		this.otherId = otherId;
		this.personalHobby = personalHobby;
		this.personHonor = personHonor;
		this.partiGroup = partiGroup;
		this.specialSkill = specialSkill;
		this.otherSkill = otherSkill;
		this.evaluation = evaluation;
		this.resumeId = resumeId;
	}

	public Integer getOtherId() {
		return otherId;
	}
	public void setOtherId(Integer otherId) {
		this.otherId = otherId;
	}
	public String getPersonalHobby() {
		return personalHobby;
	}
	public void setPersonalHobby(String personalHobby) {
		this.personalHobby = personalHobby;
	}
	public String getPersonHonor() {
		return personHonor;
	}
	public void setPersonHonor(String personHonor) {
		this.personHonor = personHonor;
	}
	public String getPartiGroup() {
		return partiGroup;
	}
	public void setPartiGroup(String partiGroup) {
		this.partiGroup = partiGroup;
	}
	public String getSpecialSkill() {
		return specialSkill;
	}
	public void setSpecialSkill(String specialSkill) {
		this.specialSkill = specialSkill;
	}
	public String getOtherSkill() {
		return otherSkill;
	}
	public void setOtherSkill(String otherSkill) {
		this.otherSkill = otherSkill;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public Integer getResumeId() {
		return resumeId;
	}

	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}

}
