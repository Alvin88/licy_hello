package com.oc.dto;

import java.util.Date;

public class ResumeProject {
	 private Integer projectId;//ID
	    private Date projectFromDate;//开始日期
	    private Date projectToDate;//结束日期
	    private String projectTitle;//项目名称
	    private String projectDetail;//项目描述
	    private String projectManager;//项目经理
	    private String myAchievement;//我的贡献\职责
	    private String myDeficiency;//我的不足
	    private String otherMembers;//其他成员
	    
	    private Integer resumeId;//简历ID
		public ResumeProject() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public ResumeProject(Integer projectId, Date projectFromDate,
				Date projectToDate, String projectTitle, String projectDetail,
				String projectManager, String myAchievement,
				String myDeficiency, String otherMembers, Integer resumeId) {
			super();
			this.projectId = projectId;
			this.projectFromDate = projectFromDate;
			this.projectToDate = projectToDate;
			this.projectTitle = projectTitle;
			this.projectDetail = projectDetail;
			this.projectManager = projectManager;
			this.myAchievement = myAchievement;
			this.myDeficiency = myDeficiency;
			this.otherMembers = otherMembers;
			this.resumeId = resumeId;
		}

		public Integer getProjectId() {
			return projectId;
		}
		public void setProjectId(Integer projectId) {
			this.projectId = projectId;
		}
		public Date getProjectFromDate() {
			return projectFromDate;
		}
		public void setProjectFromDate(Date projectFromDate) {
			this.projectFromDate = projectFromDate;
		}
		public Date getProjectToDate() {
			return projectToDate;
		}
		public void setProjectToDate(Date projectToDate) {
			this.projectToDate = projectToDate;
		}
		public String getProjectTitle() {
			return projectTitle;
		}
		public void setProjectTitle(String projectTitle) {
			this.projectTitle = projectTitle;
		}
		public String getProjectDetail() {
			return projectDetail;
		}
		public void setProjectDetail(String projectDetail) {
			this.projectDetail = projectDetail;
		}
		public String getProjectManager() {
			return projectManager;
		}
		public void setProjectManager(String projectManager) {
			this.projectManager = projectManager;
		}
		public String getMyAchievement() {
			return myAchievement;
		}
		public void setMyAchievement(String myAchievement) {
			this.myAchievement = myAchievement;
		}
		public String getMyDeficiency() {
			return myDeficiency;
		}
		public void setMyDeficiency(String myDeficiency) {
			this.myDeficiency = myDeficiency;
		}
		public String getOtherMembers() {
			return otherMembers;
		}
		public void setOtherMembers(String otherMembers) {
			this.otherMembers = otherMembers;
		}

		public Integer getResumeId() {
			return resumeId;
		}

		public void setResumeId(Integer resumeId) {
			this.resumeId = resumeId;
		}
	    
}
