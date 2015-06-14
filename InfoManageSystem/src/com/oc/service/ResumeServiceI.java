package com.oc.service;

import com.oc.dto.Resume;
import com.oc.dto.ResumeEducation;
import com.oc.dto.ResumeJobInten;
import com.oc.dto.ResumeLanguage;
import com.oc.dto.ResumeOtherInfo;
import com.oc.dto.ResumeProject;
import com.oc.dto.ResumeWork;
import com.oc.utils.system.DataGrid;

public interface ResumeServiceI {
	public DataGrid datagrid(Resume resume);//获取简历
	public DataGrid getResumeWorkList(Integer resumeId);//获取简历的工作经历列表
	public DataGrid getResumeEduList(Integer resumeId);//获取简历的教育经历列表
	public DataGrid getResumeProjectList(Integer resumeId);//获取简历的项目经验列表
	public DataGrid getResumeLanList(Integer resumeId);//获取简历的语言水平列表
	public ResumeJobInten getResumeJobInten(Integer resumeId);//获取简历求职意向信息
	public ResumeOtherInfo getResumeOtherInfo(Integer resumeId);//获取简历其他
	
	public Integer saveOrUpdateResume(Resume resume);//新增简历
	public Integer saveOrUpdateResumeWork(ResumeWork resumeWork);//保存简历工作经历信息
	public Integer saveOrUpdateResumeEducation(ResumeEducation resumeEducation);//保存简历教育经历信息
	public Integer saveOrUpdateResumeLanguage(ResumeLanguage resumeLanguage);//保存简历语言水平信息
	public Integer saveOrUpdateResumeProject(ResumeProject resumeProject);//保存简历项目经验信息
	public Integer saveOrUpdateResumeJobInten(ResumeJobInten resumeJobInten);//保存简历求职意向信息
	public Integer saveOrUpdateResumeOtherInfo(ResumeOtherInfo otherInfo);//保存简历其他信息

	
	public void deleteResume(String ids);//删除简历
	public void deleteResumeWork(String ids);//删除简历工作经历信息
	public void deleteResumeEducation(String ids);//删除简历教育经历信息
	public void deleteResumeProject(String ids);//删除简历项目经验信息
	public void deleteResumeLanguage(String ids);//删除简历语言水平信息
	public void deleteResumeJobInten(String ids);//删除简历求职意向信息，id表示resume的id，用来删除求职意向
	public void deleteResumeOtherInfo(String ids);//删除简历其他信息，ids表示resume的id，用来删除其他信息所用
	
	//预览简历
	
	
	//发布简历
}
