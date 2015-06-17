package com.oc.action;


import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oc.action.base.BaseAction;
import com.oc.dto.Resume;
import com.oc.dto.ResumeEducation;
import com.oc.dto.ResumeJobInten;
import com.oc.dto.ResumeLanguage;
import com.oc.dto.ResumeOtherInfo;
import com.oc.dto.ResumeProject;
import com.oc.dto.ResumeWork;
import com.oc.service.BaseServiceI;
import com.oc.service.ResumeServiceI;
import com.oc.utils.system.Json;
import com.oc.utils.system.SysConstants;
@Namespace("/")
@Action(value = "resumeAction", results = {
		//@Result(name = "roleAdd", location = "/admin/roleAdd.jsp"), 
		//@Result(name = "roleEdit", location = "/admin/roleEdit.jsp") 
		})
@SuppressWarnings("all")
public class ResumeAction extends BaseAction {//去掉了modeldriver因为本action需要用到多个实体
	private static final Logger logger = Logger.getLogger(ResumeAction.class);
	//简历id，从前台页面传递过来，用来查询简历其他信息
	private String resumeIds;//批量删除简历，前台传递过来的ids
	private String resumeWorkIds;//批量删除简历工作经历，前台传递过来的resumeWorkIds
	private String resumeEduIds;//批量删除简历教育经历，前台传递过来的resumeEduIds
	private String resumeLanIds;//批量删除简历语言水平，前台传递过来的resumeLanIds
	private String resumeProjectIds;//批量删除简历项目经验，前台传递过来的resumeProjectIds
	private String resumeJobIntenIds;//删除简历求职意向，为了以后扩展名称也以s结尾
	private String resumeOtherInfoIds;//删除简历其他信息，为了以后扩展名称也以s结尾
	
	public String getResumeWorkIds() {
		return resumeWorkIds;
	}
	public void setResumeWorkIds(String resumeWorkIds) {
		this.resumeWorkIds = resumeWorkIds;
	}
	public String getResumeEduIds() {
		return resumeEduIds;
	}
	public void setResumeEduIds(String resumeEduIds) {
		this.resumeEduIds = resumeEduIds;
	}
	public String getResumeLanIds() {
		return resumeLanIds;
	}
	public void setResumeLanIds(String resumeLanIds) {
		this.resumeLanIds = resumeLanIds;
	}
	public String getResumeProjectIds() {
		return resumeProjectIds;
	}
	public void setResumeProjectIds(String resumeProjectIds) {
		this.resumeProjectIds = resumeProjectIds;
	}
	public String getResumeJobIntenIds() {
		return resumeJobIntenIds;
	}
	public void setResumeJobIntenIds(String resumeJobIntenIds) {
		this.resumeJobIntenIds = resumeJobIntenIds;
	}
	public String getResumeOtherInfoIds() {
		return resumeOtherInfoIds;
	}
	public void setResumeOtherInfoIds(String resumeOtherInfoIds) {
		this.resumeOtherInfoIds = resumeOtherInfoIds;
	}
	public String getResumeIds() {
		return resumeIds;
	}
	public void setResumeIds(String resumeIds) {
		this.resumeIds = resumeIds;
	}
	private Integer resumeId;//前台传递过来
	public Integer getResumeId() {
		return resumeId;
	}
	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}
	Resume resume = new Resume();//简历基本信息实体
	ResumeWork  resumeWork = new ResumeWork();//简历工作经历实体
	ResumeProject resumeProject = new ResumeProject();//简历项目经验实体
	ResumeEducation resumeEdu = new ResumeEducation();//简历教育经历实体
	ResumeLanguage resumeLan = new ResumeLanguage();//简历语言水平实体
	ResumeJobInten resumeJobInten =new ResumeJobInten();//简历工作意向实体
	ResumeOtherInfo resumeOtherInfo = new ResumeOtherInfo();//简历其他信息实体
	 public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public ResumeWork getResumeWork() {
		return resumeWork;
	}

	public void setResumeWork(ResumeWork resumeWork) {
		this.resumeWork = resumeWork;
	}

	public ResumeProject getResumeProject() {
		return resumeProject;
	}

	public void setResumeProject(ResumeProject resumeProject) {
		this.resumeProject = resumeProject;
	}

	public ResumeEducation getResumeEdu() {
		return resumeEdu;
	}

	public void setResumeEdu(ResumeEducation resumeEdu) {
		this.resumeEdu = resumeEdu;
	}

	public ResumeLanguage getResumeLan() {
		return resumeLan;
	}

	public void setResumeLan(ResumeLanguage resumeLan) {
		this.resumeLan = resumeLan;
	}

	public ResumeJobInten getResumeJobInten() {
		return resumeJobInten;
	}

	public void setResumeJobInten(ResumeJobInten resumeJobInten) {
		this.resumeJobInten = resumeJobInten;
	}

	public ResumeOtherInfo getResumeOtherInfo() {
		return resumeOtherInfo;
	}

	public void setResumeOtherInfo(ResumeOtherInfo resumeOtherInfo) {
		this.resumeOtherInfo = resumeOtherInfo;
	}

	@Autowired
	private ResumeServiceI resumeService;
	public ResumeServiceI getResumeService() {
		return resumeService;
	}

	public void setResumeService(ResumeServiceI resumeService) {
		this.resumeService = resumeService;
	}
	 
	//保存简历基本信息
	public String saveOrUpdateResume(){
		Json j = new Json();
		try {
			boolean result = resumeService.saveOrUpdateResume(resume);
			if(result){
				j.setSuccess(true);
				j.setMsg("简历基本信息保存成功");
				j.setObj(resume.getId());//新增后的实体id
			}else{
				if(resume!=null){
					j.setSuccess(false);
					j.setMsg("数据库中已经存在该登录名称的用户，不能再次添加");
				}else{
					j.setSuccess(false);
					j.setMsg("简历基本信息保存失败");
				}
			}
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("简历基本信息保存失败");
		}
		writeJson(j);
		return null;
	}
	
	//保存简历工作经历信息
	public String saveOrUpdateResumeWork(){
		Json j = new Json();
		try {
			boolean result = resumeService.saveOrUpdateResumeWork(resumeWork);
			if(result){
				j.setSuccess(true);
				j.setMsg("简历工作经历保存成功");
				j.setObj(resumeWork.getWorkId());
			}else{
				if(resumeWork!=null && resumeWork.getResumeId()!=null){
					j.setSuccess(false);
					j.setMsg("该工作经历已经存在，不能再次添加");
				}else{
					j.setSuccess(false);
					j.setMsg("简历工作经历保存失败");
				}
			}
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("简历工作经历保存失败");
		}
		writeJson(j);
		return null;
	}
	
	//保存简历教育经历信息
	public String saveOrUpdateResumeEdu(){
		Json j = new Json();
		try {
			boolean  result = resumeService.saveOrUpdateResumeEducation(resumeEdu);
			if(result){
				j.setSuccess(true);
				j.setMsg("简历教育经历保存成功");
				j.setObj(resumeEdu.getEduId());
				
			}else{
				if(resumeEdu!=null  && resumeEdu.getResumeId()!=null){
					j.setSuccess(false);
					j.setMsg("该教育经历已经存在，不能再次添加");
				}else{
					j.setSuccess(false);
					j.setMsg("简历教育经历保存失败");
				}
			}
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("简历教育经历保存失败");
		}
		writeJson(j);
		return null;
	}
	
	//保存简历语言水平信息
	public String saveOrUpdateResumeLan(){
		Json j = new Json();
		try {
			boolean result = resumeService.saveOrUpdateResumeLanguage(resumeLan);
			if(result){
				j.setSuccess(true);
				j.setMsg("简历语言水平保存成功");
				j.setObj(resumeLan.getLanId());
			}else{
				if(resumeLan!=null && resumeLan.getResumeId()!=null){
					j.setSuccess(false);
					j.setMsg("该语言水平已经存在，不能再次添加");
				}else{
					j.setSuccess(false);
					j.setMsg("简历语言水平保存失败");
				}
			}
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("简历语言水平保存失败");
		}
		writeJson(j);
		return null;
	}
	
	//保存简历项目经验信息
	public String saveOrUpdateResumeProject(){
		Json j = new Json();
		try {
			boolean result = resumeService.saveOrUpdateResumeProject(resumeProject);
			if(result){
				j.setSuccess(true);
				j.setMsg("简历项目经验保存成功");
				j.setObj(resumeProject.getProjectId());
				
			}else{
				if(resumeProject!=null && resumeProject.getResumeId()!=null){
					j.setSuccess(false);
					j.setMsg("该项目经验已经存在，不能再次添加");
				}else{
					j.setSuccess(false);
					j.setMsg("简历项目经验保存失败");
				}
			}
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("简历项目经验保存失败");
			e.printStackTrace();
		}
		writeJson(j);
		return null;
	}
	
	//保存简历求职意向信息
	public String saveOrUpdateResumeJobInten(){
		Json j = new Json();
		try {
			boolean result = resumeService.saveOrUpdateResumeJobInten(resumeJobInten);
			if(result){
				j.setSuccess(true);
				j.setMsg("简历求职意向信息保存成功");
				j.setObj(resumeJobInten.getJobIntenId());
			}else{
				j.setSuccess(false);
				j.setMsg("该求职意向信息保存失败");
			}
			
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("简历求职意向信息保存失败");
		}
		writeJson(j);
		return null;
	}
	
	//保存简历其他信息
	public String saveOrUpdateResumeOtherInfo(){
		Json j = new Json();
		try {
			boolean result = resumeService.saveOrUpdateResumeOtherInfo(resumeOtherInfo);
			if(result){
				j.setSuccess(true);
				j.setMsg("简历其他信息保存成功");
				j.setObj(resumeOtherInfo.getOtherId());
				
			}else{
				j.setSuccess(false);
				j.setMsg("简历其他信息保存失败");
			}	
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("简历其他信息保存失败");
			e.printStackTrace();
		}
		writeJson(j);
		return null;
	}
	
	/**
	 * 查询满足条件的简历信息并进行展示
	 * */
	public void datagrid(){
		
		super.writeJson(resumeService.datagrid(resume));
	}
	
	/**
	 * 根据简历id获取满足条件的工作经历列表
	 * */
	public void workdatagrid(){
		if(resumeId!=null){
			super.writeJson(resumeService.getResumeWorkList(resumeId));
		}
	}
	
	/**
	 * 根据简历id获取满足条件的教育经历列表
	 * */
	public void edudatagrid(){
		if(resumeId!=null){
			super.writeJson(resumeService.getResumeEduList(resumeId));
		}
	}
	
	/**
	 * 根据简历id获取满足条件的项目经历列表
	 * */
	public void projectdatagrid(){
		if(resumeId!=null){
			super.writeJson(resumeService.getResumeProjectList(resumeId));
		}
	}
	
	/**
	 * 根据简历id获取满足条件的语言水平列表
	 * */
	public void landatagrid(){
		if(resumeId!=null){
			super.writeJson(resumeService.getResumeLanList(resumeId));
		}
	}
	
	/**
	 * 根据简历id获取满足条件的求职意向
	 * */
	public void jobintendatagrid(){
		if(resumeId!=null){
			super.writeJson(resumeService.getResumeJobInten(resumeId));
		}
		
	}
	
	/**
	 * 根据简历id获取满足条件的求职意向
	 * */
	public void otherinfodatagrid(){
		if(resumeId!=null){
			super.writeJson(resumeService.getResumeOtherInfo(resumeId));
		}
	}
	
	/**
	 * 删除所选择的简历信息
	 * */
	public void deleteResume() {
		resumeService.deleteResume(resumeIds);
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("删除成功");
		writeJson(j);
	}
	
	/**
	 * 删除所选择的简历信息
	 * */
	public void deleteResumeWork() {
		resumeService.deleteResumeWork(resumeWorkIds);
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("删除成功");
		writeJson(j);
	}
	
	/**
	 * 删除所选择的简历信息
	 * */
	public void deleteResumeEdu() {
		resumeService.deleteResumeEducation(resumeEduIds);
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("删除成功");
		writeJson(j);
	}
	/**
	 * 删除所选择的简历信息
	 * */
	public void deleteResumeProject() {
		resumeService.deleteResumeProject(resumeProjectIds);
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("删除成功");
		writeJson(j);
	}
	
	/**
	 * 删除所选择的简历信息
	 * */
	public void deleteResumeLan() {
		resumeService.deleteResumeLanguage(resumeLanIds);
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("删除成功");
		writeJson(j);
	}
	
	/**
	 * 删除所选择的简历信息
	 * */
	public void deleteResumeJobInten() {
		resumeService.deleteResumeJobInten(resumeJobIntenIds);
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("删除成功");
		writeJson(j);
	}
	
	/**
	 * 删除所选择的简历信息
	 * */
	public void deleteResumeOtherInfo() {
		resumeService.deleteResumeOtherInfo(resumeOtherInfoIds);
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("删除成功");
		writeJson(j);
	}

	@Override
	protected BaseServiceI getService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
