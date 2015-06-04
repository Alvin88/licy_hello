package com.oc.action;


import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.oc.action.base.BaseAction;
import com.oc.dto.Resume;
import com.oc.dto.ResumeEducation;
import com.oc.dto.ResumeJobInten;
import com.oc.dto.ResumeLanguage;
import com.oc.dto.ResumeOtherInfo;
import com.oc.dto.ResumeProject;
import com.oc.dto.ResumeWork;
import com.oc.service.ResumeServiceI;
import com.oc.utils.system.Json;
@Namespace("/")
@Action(value = "resumeAction", results = {
		})
@SuppressWarnings("all")
public class ResumeAction extends BaseAction {//去掉了modeldriver因为本action需要用到多个实体
	private static final Logger logger = Logger.getLogger(ResumeAction.class);
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
			Integer resId = resumeService.saveOrUpdateResume(resume);
			j.setSuccess(true);
			j.setMsg("简历基本信息保存成功");
			j.setObj(resId);
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("简历基本信息保存失败");
			e.printStackTrace();
		}
		writeJson(j);
		return null;
	}
	
	//保存简历工作经历信息
	public String saveOrUpdateResumeWork(){
		return null;
	}
	
	//保存简历教育经历信息
	public String saveOrUpdateResumeEdu(){
		return null;
	}
	
	//保存简历语言水平信息
	public String saveOrUpdateResumeLan(){
		return null;
	}
	
	//保存简历项目经验信息
	public String saveOrUpdateResumeProject(){
		return null;
	}
	
	//保存简历求职意向信息
	public String saveOrUpdateResumeJobInten(){
		return null;
	}
	
	//保存简历其他信息
	public String saveOrUpdateResumeOtherInfo(){
		return null;
	}
	
	/**
	 * 查询满足条件的简历信息并进行展示
	 * */
	public void datagrid(){
		super.writeJson(resumeService.datagrid(resume));
	}
	
	/**
	 * 删除所选择的简历信息
	 * */
	public void deleteResume() {
//		resumeService.remove(user.getIds());
//		Json j = new Json();
//		j.setSuccess(true);
//		j.setMsg("删除成功");
//		writeJson(j);
	}
	
	/**
	 * 删除所选择的简历信息
	 * */
	public void deleteResumeWork() {
//		resumeService.remove(user.getIds());
//		Json j = new Json();
//		j.setSuccess(true);
//		j.setMsg("删除成功");
//		writeJson(j);
	}
	
	/**
	 * 删除所选择的简历信息
	 * */
	public void deleteResumeEdu() {
//		resumeService.remove(user.getIds());
//		Json j = new Json();
//		j.setSuccess(true);
//		j.setMsg("删除成功");
//		writeJson(j);
	}
	/**
	 * 删除所选择的简历信息
	 * */
	public void deleteResumeProject() {
//		resumeService.remove(user.getIds());
//		Json j = new Json();
//		j.setSuccess(true);
//		j.setMsg("删除成功");
//		writeJson(j);
	}
	
	/**
	 * 删除所选择的简历信息
	 * */
	public void deleteResumeLan() {
//		resumeService.remove(user.getIds());
//		Json j = new Json();
//		j.setSuccess(true);
//		j.setMsg("删除成功");
//		writeJson(j);
	}
	
	/**
	 * 删除所选择的简历信息
	 * */
	public void deleteResumeJobInten() {
//		resumeService.remove(user.getIds());
//		Json j = new Json();
//		j.setSuccess(true);
//		j.setMsg("删除成功");
//		writeJson(j);
	}
	
	/**
	 * 删除所选择的简历信息
	 * */
	public void deleteResumeOtherInfo() {
//		resumeService.remove(user.getIds());
//		Json j = new Json();
//		j.setSuccess(true);
//		j.setMsg("删除成功");
//		writeJson(j);
	}
=======
public class ResumeAction {
>>>>>>> branch 'master' of https://github.com/Alvin88/licy_hello

}
