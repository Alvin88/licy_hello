package com.oc.model;

import java.util.Date;

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

import org.hibernate.annotations.Type;
@Entity
@Table(name = "tp_project")
public class TpProject {
    private Integer id;//ID
    private Date projectFromDate;//开始日期
    private Date projectToDate;//结束日期
    private String projectTitle;//项目名称
    private String projectDetail;//项目描述
    private String projectManager;//项目经理
    private String myAchievement;//我的贡献\职责
    private String myDeficiency;//我的不足
    private String otherMembers;//其他成员
    private Tresume resume;//个人简历
    
	public TpProject(Integer id, Date projectFromDate, Date projectToDate,
			String projectTitle, String projectDetail, String projectManager,
			String myAchievement, String myDeficiency, String otherMembers,
			Tresume resume) {
		super();
		this.id = id;
		this.projectFromDate = projectFromDate;
		this.projectToDate = projectToDate;
		this.projectTitle = projectTitle;
		this.projectDetail = projectDetail;
		this.projectManager = projectManager;
		this.myAchievement = myAchievement;
		this.myDeficiency = myDeficiency;
		this.otherMembers = otherMembers;
		this.resume = resume;
	}
	public TpProject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "project_from_date")
	public Date getProjectFromDate() {
		return projectFromDate;
	}
	public void setProjectFromDate(Date projectFromDate) {
		this.projectFromDate = projectFromDate;
	}
	@Column(name = "project_to_date")
	public Date getProjectToDate() {
		return projectToDate;
	}
	public void setProjectToDate(Date projectToDate) {
		this.projectToDate = projectToDate;
	}
	@Column(name = "project_title", length = 100)
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	@Type(type="text")
	@Column(name = "project_detail")
	public String getProjectDetail() {
		return projectDetail;
	}
	public void setProjectDetail(String projectDetail) {
		this.projectDetail = projectDetail;
	}
	@Column(name = "project_manager", length = 20)
	public String getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	@Column(name = "my_achievement", length = 500)
	public String getMyAchievement() {
		return myAchievement;
	}
	public void setMyAchievement(String myAchievement) {
		this.myAchievement = myAchievement;
	}
	@Column(name = "my_deficiency", length = 500)
	public String getMyDeficiency() {
		return myDeficiency;
	}
	public void setMyDeficiency(String myDeficiency) {
		this.myDeficiency = myDeficiency;
	}
	@Column(name = "other_members", length = 255)
	public String getOtherMembers() {
		return otherMembers;
	}
	public void setOtherMembers(String otherMembers) {
		this.otherMembers = otherMembers;
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
