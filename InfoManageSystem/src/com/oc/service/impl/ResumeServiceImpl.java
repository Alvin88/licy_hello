package com.oc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oc.dao.BaseDaoI;
import com.oc.dto.Resume;
import com.oc.dto.ResumeEducation;
import com.oc.dto.ResumeJobInten;
import com.oc.dto.ResumeLanguage;
import com.oc.dto.ResumeOtherInfo;
import com.oc.dto.ResumeProject;
import com.oc.dto.ResumeWork;
import com.oc.model.TpEducation;
import com.oc.model.TpJobIntension;
import com.oc.model.TpLanguage;
import com.oc.model.TpOtherInfo;
import com.oc.model.TpProject;
import com.oc.model.TpWork;
import com.oc.model.Tresume;
import com.oc.service.ResumeServiceI;
import com.oc.utils.system.CodeGenerator;
import com.oc.utils.system.DataGrid;
import com.oc.utils.system.Encrypt;
import com.oc.utils.system.ResourceUtil;
import com.oc.utils.system.SessionInfo;
import com.oc.utils.system.SysConstants;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeServiceI {
 
	private BaseDaoI<Tresume> resumeDao;//简历基本信息dao
	private BaseDaoI<TpWork> resumeWorkDao;//工作经历dao
	private BaseDaoI<TpProject> resumeProjectDao;//项目经验dao
	private BaseDaoI<TpJobIntension> resumeJobIntenDao;//工作意向dao
	private BaseDaoI<TpEducation> resumeEduDao;//教育经历dao
	private BaseDaoI<TpOtherInfo> resumeOtherDao;//其他信息dao
	private BaseDaoI<TpLanguage> resumeLanDao;//语言水平dao
	
	public BaseDaoI<Tresume> getResumeDao() {
		return resumeDao;
	}

	@Autowired
	public void setResumeDao(BaseDaoI<Tresume> resumeDao) {
		this.resumeDao = resumeDao;
	}

	public BaseDaoI<TpWork> getResumeWorkDao() {
		return resumeWorkDao;
	}
	@Autowired
	public void setResumeWorkDao(BaseDaoI<TpWork> resumeWorkDao) {
		this.resumeWorkDao = resumeWorkDao;
	}

	public BaseDaoI<TpProject> getResumeProjectDao() {
		return resumeProjectDao;
	}
	@Autowired
	public void setResumeProjectDao(BaseDaoI<TpProject> resumeProjectDao) {
		this.resumeProjectDao = resumeProjectDao;
	}

	public BaseDaoI<TpJobIntension> getResumeJobIntenDao() {
		return resumeJobIntenDao;
	}
	@Autowired
	public void setResumeJobIntenDao(BaseDaoI<TpJobIntension> resumeJobIntenDao) {
		this.resumeJobIntenDao = resumeJobIntenDao;
	}

	public BaseDaoI<TpEducation> getResumeEduDao() {
		return resumeEduDao;
	}
	@Autowired
	public void setResumeEduDao(BaseDaoI<TpEducation> resumeEduDao) {
		this.resumeEduDao = resumeEduDao;
	}

	public BaseDaoI<TpOtherInfo> getResumeOtherDao() {
		return resumeOtherDao;
	}
	@Autowired
	public void setResumeOtherDao(BaseDaoI<TpOtherInfo> resumeOtherDao) {
		this.resumeOtherDao = resumeOtherDao;
	}

	public BaseDaoI<TpLanguage> getResumeLanDao() {
		return resumeLanDao;
	}
	@Autowired
	public void setResumeLanDao(BaseDaoI<TpLanguage> resumeLanDao) {
		this.resumeLanDao = resumeLanDao;
	}

	/*
	 * 根据条件获取所查询的简历
	 * **/
	@Override
	public DataGrid datagrid(Resume resume) {
		DataGrid d = new DataGrid();
		d.setRows(changerModel(find(resume)));
		d.setTotal(total(resume));
		return d;
	}

	//将从数据库中获取的数据进行模型转换
	private List<Resume> changerModel(List<Tresume> tresumes) {
		List<Resume> resumes = new ArrayList<Resume>();
		if (tresumes != null && tresumes.size() > 0) {
			for (Tresume tre : tresumes) {
				Resume u = new Resume();
				BeanUtils.copyProperties(tre, u);//属性值复制，属性名称相同的会复制，因此要保证两个类需要复制的属性值相同
				u.setJobInten(this.getResumeJobInten(tre.getId()));//获取求职意向
				u.setOtherInfo(this.getResumeOtherInfo(tre.getId()));//获取其他信息
				resumes.add(u);//添加
			}
		}
		return resumes;
	}

	
	//find方法实现
	private List<Tresume> find(Resume resume) {
		String hql = "from Tresume t where 1=1";
		List<Object> values = new ArrayList<Object>();
		hql = addWhere(resume, hql, values);
		if (resume.getSort() != null && resume.getOrder() != null) {
			hql += " order by " + resume.getSort() + " " + resume.getOrder();
		}
		return resumeDao.find(hql, values, resume.getPage(), resume.getRows());
	}
	
	//查询条件
	private String addWhere(Resume resume, String hql, List<Object> values) {
//		if (user.getName() != null && !user.getName().trim().equals("")) {
//			hql += " and t.name like ? ";
//			values.add("%%" + user.getName().trim() + "%%");
//		}
		return hql;
	}
	
	private Long total(Resume resume) {
		String hql = "select count(*) from Tresume t where 1=1 ";
		List<Object> values = new ArrayList<Object>();
		hql = addWhere(resume, hql, values);
		return resumeDao.count(hql, values);
	}
	
	/**
	 * 简历基本信息保存
	 * 返回保存的实体id
	 * */
	public boolean saveOrUpdateResume(Resume resume) {
		if(resume.getId()!=null){//表示修改
			Tresume t = resumeDao.get(Tresume.class, resume.getId());
			String createUserId = t.getCreateUserId();//创建人是不能变的
			String createUserName = t.getCreateUserName();//创建人是不能变的
			Date createDate = t.getCdate();//创建时间是不能变化的
			Integer auditStatus = t.getAuditStatus();//审核状态不变
			Integer isPublish = t.getIsPublish();//是否发布状态不变
			BeanUtils.copyProperties(resume, t, new String[] { "loginpwd" });//这里会改变部分属性值，因此事先需要记录，然后再设置值
			if(resume.getLoginpwd()!=null&& !(resume.getLoginpwd().equals(""))){
				t.setLoginpwd(Encrypt.e(resume.getLoginpwd()));
			}
			t.setCreateUserId(createUserId);//保留原来的创建人id
			t.setCreateUserName(createUserName);//保留原来创建人名称
			t.setCdate(createDate);//保留原来创建时间
			t.setAuditStatus(auditStatus);//保留原来审核状态
			t.setIsPublish(isPublish);//保留原来发布状态
			t.setMdate(new Date());
			resumeDao.saveOrUpdate(t);//保存修改内容
			resume.setId(t.getId());//设置保存后的id
			return true;//添加成功
		}else{//表示新增
			Tresume t = new Tresume();
			String hql = "from Tresume t where t.loginname='"+resume.getLoginname()+"'";
			List<Tresume> tmp = resumeDao.find(hql);
			if(tmp!=null&&tmp.size()>0){
				return false;//表示已经具有该用户，添加失败
			}else{
				BeanUtils.copyProperties(resume, t, new String[] { "loginpwd" });
				//t.setId(UUID.randomUUID().toString());
				t.setCode(CodeGenerator.getResumeNo());//自动创建简历编号
				t.setLoginpwd(Encrypt.e(resume.getLoginpwd()));//密码加密
				t.setCdate(new Date());//创建日期
				SessionInfo sessionInfo = (SessionInfo) ServletActionContext.getRequest().getSession().getAttribute(ResourceUtil.getSessionInfoName());
				t.setCreateUserId(sessionInfo.getUserId());//创建人ID
				t.setCreateUserName(sessionInfo.getLoginName());//创建人
				//初始化时审核状态为未审核，发布状态为未发布
				t.setAuditStatus(SysConstants.NO_AUDIT);//未审核
				t.setIsPublish(SysConstants.PUBLISH_NO);//未发布
				resumeDao.save(t);//新增内容
				resume.setId(t.getId());//设置简历id
				return true;
			}
		}
	}
	

	
	/**
	 * 保存简历的工作经历信息
	 * */
	public boolean saveOrUpdateResumeWork(ResumeWork resumeWork){
		if(resumeWork!=null && resumeWork.getResumeId()!=null){
				//使用公司名称辨别是否为同一段工作经历
				String hql = "from TpWork t where t.company='"+resumeWork.getCompany()+"' "
						+ " and t.resume.id="+resumeWork.getResumeId();
				List<TpWork> tmp = resumeWorkDao.find(hql);
				if(tmp!=null&&tmp.size()>0){
					return false;//表示数据库中已经具有该工作经历，添加失败
				}else{
					TpWork  t = new TpWork();
					BeanUtils.copyProperties(resumeWork, t);//复制属性值
					t.setId(resumeWork.getWorkId());//增加这个是防止修改的时候把id给丢失了,防止重新新建数据
					resumeWorkDao.save(t);//保存
					resumeWork.setWorkId(t.getId());//设置保存实体的id
					return true;
				}
		}
		return false;
	}
	
	/**
	 * 保存简历的教育经历信息
	 * */
	public boolean saveOrUpdateResumeEducation(ResumeEducation resumeEducation){
		if(resumeEducation!=null && resumeEducation.getResumeId()!=null){
				//使用学历和学校辨别是否为同一段教育经历
				String hql = "from TpEducation t where t.schoolName='"+resumeEducation.getSchoolName()+"' "
						+ "and t.degree="+resumeEducation.getDegree()+" and t.resume.id="+resumeEducation.getResumeId();
				List<TpEducation> tmp = resumeEduDao.find(hql);
				if(tmp!=null&&tmp.size()>0){
					return false;//表示数据库中已经具有该教育经历，添加失败
				}else{
					TpEducation  t = new TpEducation();
					BeanUtils.copyProperties(resumeEducation, t);//复制属性值
					t.setId(resumeEducation.getEduId());//增加这个是防止修改的时候把id给丢失了，防止重新新建数据
					resumeEduDao.save(t);//保存
					resumeEducation.setEduId(t.getId());//设置保存实体后的id
					return true;
				}
		}
		return false;
	}

	/**
	 * 保存简历的语言水平信息
	 * */
	public boolean saveOrUpdateResumeLanguage(ResumeLanguage resumeLanguage){
		if(resumeLanguage!=null && resumeLanguage.getResumeId()!=null){
				//使用语言类别辨别是否为同一语言水平信息
				String hql = "from TpLanguage t where t.languageCategory="+resumeLanguage.getLanguageCategory()+
						" and t.resume.id="+resumeLanguage.getResumeId();
				List<TpLanguage> tmp = resumeLanDao.find(hql);
				if(tmp!=null&&tmp.size()>0){
					return false;//表示数据库中已经具有该语言水平，添加失败
				}else{
					TpLanguage  t = new TpLanguage();
					BeanUtils.copyProperties(resumeLanguage, t);//复制属性值
					t.setId(resumeLanguage.getLanId());//增加这个是防止修改的时候把id给丢失了，防止重新新建数据
					resumeLanDao.save(t);//保存
					resumeLanguage.setResumeId(t.getId());//设置实体保存后的id
					return true;
				}
		}
		return false;
	}

	/**
	 * 保存简历的项目经验信息
	 * */
	public boolean saveOrUpdateResumeProject(ResumeProject resumeProject){
		if(resumeProject!=null && resumeProject.getResumeId()!=null){
				//使用项目名称表示是否为同一个项目经历
				String hql = "from TpProject t where t.projectTitle='"+resumeProject.getProjectTitle()+
						"' and t.resume.id="+resumeProject.getResumeId();
				List<TpProject> tmp = resumeProjectDao.find(hql);
				if(tmp!=null&&tmp.size()>0){
					return false;//表示数据库中已经具有该项目经验，添加失败
				}else{
					TpProject  t = new TpProject();
					BeanUtils.copyProperties(resumeProject, t);//复制属性值
					t.setId(resumeProject.getProjectId());//增加这个是防止修改的时候把id给丢失了，防止重新新建数据
					resumeProjectDao.save(t);//保存
					resumeProject.setProjectId(t.getId());//设置保存实体后的id
					return true;
				}
		}
		return false;
	}
	
	/**
	 * 保存简历的工作意向信息
	 * */
	public boolean saveOrUpdateResumeJobInten(ResumeJobInten resumeJobInten){
		if(resumeJobInten!=null && resumeJobInten.getResumeId()!=null){
			TpJobIntension  t = new TpJobIntension();
			BeanUtils.copyProperties(resumeJobInten, t);//复制属性值
			t.setId(resumeJobInten.getJobIntenId());//增加这个是防止修改的时候把id给丢失了，防止重新新建数据
			Tresume resume = resumeDao.get(Tresume.class, resumeJobInten.getResumeId());
			t.setResume(resume);
			resumeJobIntenDao.saveOrUpdate(t);//.save(t);//新增或修改
			resumeJobInten.setJobIntenId(t.getId());//设置保存实体后的id
			return true;
		}
		return false;
	}
	
	/**
	 * 保存简历的其他信息
	 * */
	public boolean saveOrUpdateResumeOtherInfo(ResumeOtherInfo otherInfo){
		if(otherInfo!=null && otherInfo.getResumeId()!=null){
			TpOtherInfo  t = new TpOtherInfo();
			BeanUtils.copyProperties(otherInfo, t);//复制属性值
			t.setId(otherInfo.getOtherId());//增加这个是防止修改的时候把id给丢失了，防止重新新建数据
			Tresume resume = resumeDao.get(Tresume.class, otherInfo.getResumeId());
			t.setResume(resume);
			resumeOtherDao.saveOrUpdate(t);//save(t);//新增或修改
			otherInfo.setOtherId(t.getId());//设置保存实体后的id
			return true;
		}
		return false;
	}



	/**删除简历（是否级联删除工作经历项目经验等需要验证）*/
	public void deleteResume(String ids) {
		if (ids != null) {
			for (String id : ids.split(",")) {
				if (!id.trim().equals("0")) {
					Tresume u = resumeDao.get(Tresume.class, Integer.valueOf(id.trim()));
					if (u != null) {
						//userroleDao.executeHql("delete Tusertrole t where t.tuser = ?", new Object[] { u });//如果没有级联删除，需要手动删除简历关联的其他信息
						resumeDao.delete(u);
					}
				}
			}
		}
	}
	
	 /**
     * 删除简历上面的工作经历
     * */
	public void deleteResumeWork(String ids){
		if (ids != null) {
			for (String id : ids.split(",")) {
				if (!id.trim().equals("0")) {
					TpWork u = resumeWorkDao.get(TpWork.class, Integer.valueOf(id.trim()));
					if (u != null) {
						//userroleDao.executeHql("delete Tusertrole t where t.tuser = ?", new Object[] { u });
						resumeWorkDao.delete(u);
					}
				}
			}
		}
	}
	
	 /**
     * 删除简历上面的教育经历
     * */
	public void deleteResumeEducation(String ids){
		if (ids != null) {
			for (String id : ids.split(",")) {
				if (!id.trim().equals("0")) {
					TpEducation u = resumeEduDao.get(TpEducation.class, Integer.valueOf(id.trim()));
					if (u != null) {
						//userroleDao.executeHql("delete Tusertrole t where t.tuser = ?", new Object[] { u });
						resumeEduDao.delete(u);
					}
				}
			}
		}
	}
	
	 /**
     * 删除简历上面的项目经验
     * */
	public void deleteResumeProject(String ids){
		if (ids != null) {
			for (String id : ids.split(",")) {
				if (!id.trim().equals("0")) {
					TpProject u = resumeProjectDao.get(TpProject.class, Integer.valueOf(id.trim()));
					if (u != null) {
						//userroleDao.executeHql("delete Tusertrole t where t.tuser = ?", new Object[] { u });
						resumeProjectDao.delete(u);
					}
				}
			}
		}
	}
	
	 /**
     * 删除简历上面的语言水平
     * */
	public void deleteResumeLanguage(String ids){
		if (ids != null) {
			for (String id : ids.split(",")) {
				if (!id.trim().equals("0")) {
					TpLanguage u = resumeLanDao.get(TpLanguage.class, Integer.valueOf(id.trim()));
					if (u != null) {
						//userroleDao.executeHql("delete Tusertrole t where t.tuser = ?", new Object[] { u });
						resumeLanDao.delete(u);
					}
				}
			}
		}
	}
	
	 /**
     * 删除简历上面的求职意向
     * */
	public void deleteResumeJobInten(String ids){//id表示resume的id，用来删除求职意向用
		if (ids != null) {
			for (String id : ids.split(",")) {
				String hql="delete TpJobIntension t where t.resume.id="+Integer.valueOf(id);
				if (!id.trim().equals("0")) {
						//userroleDao.executeHql("delete Tusertrole t where t.tuser = ?", new Object[] { u });
						resumeOtherDao.executeHql(hql);
				}
			}
		}
	}
	
	 /**
     * 删除简历上面的其他信息
     * */
	public void deleteResumeOtherInfo(String ids){//ids表示resume的id，用来删除其他信息所用
		if (ids != null) {
			for (String id : ids.split(",")) {
				String hql="delete TpOtherInfo t where t.resume.id="+Integer.valueOf(id);
				if (!id.trim().equals("0")) {
						//userroleDao.executeHql("delete Tusertrole t where t.tuser = ?", new Object[] { u });
						resumeOtherDao.executeHql(hql);
				}
			}
		}
	}
	
	
	
	
	//----------------------获取简历相关的工作经历信息
	public DataGrid getResumeWorkList(Integer resumeId){
		DataGrid d = new DataGrid();
		List<ResumeWork> works = new ArrayList<ResumeWork>();
		String hql = "from TpWork t where 1=1 and t.resume.id="+resumeId;
		List<TpWork> tpworks = resumeWorkDao.find(hql);
		if (tpworks != null && tpworks.size() > 0) {
			for (TpWork tw : tpworks) {
				ResumeWork u = new ResumeWork();
				BeanUtils.copyProperties(tw, u);//属性值复制
				u.setWorkId(tw.getId());//因为ID名称改变，所以需要手动设置
				works.add(u);
			}
		}
		d.setRows(works);
		d.setTotal((long)works.size());
		return d;
	}
	
	//----------------------获取简历相关的教育经历信息
		public DataGrid getResumeEduList(Integer resumeId){
			DataGrid d = new DataGrid();
			List<ResumeEducation> edus = new ArrayList<ResumeEducation>();
			String hql = "from TpEducation t where 1=1 and t.resume.id="+resumeId;
			List<TpEducation> tpedus = resumeEduDao.find(hql);
			if (tpedus != null && tpedus.size() > 0) {
				for (TpEducation te : tpedus) {
					ResumeEducation u = new ResumeEducation();
					BeanUtils.copyProperties(te, u);//属性值复制
					u.setEduId(te.getId());//因为ID名称改变，所以需要手动设置
					edus.add(u);
				}
			}
			d.setRows(edus);
			d.setTotal((long)edus.size());
			return d; 
		}
		
		
		//----------------------获取简历相关的项目经验信息
		public  DataGrid getResumeProjectList(Integer resumeId){
			DataGrid d = new DataGrid();
			List<ResumeProject> projects = new ArrayList<ResumeProject>();
			String hql = "from TpProject t where 1=1 and t.resume.id="+resumeId;
			List<TpProject> tpprojects = resumeProjectDao.find(hql);
			if (tpprojects != null && tpprojects.size() > 0) {
				for (TpProject tp : tpprojects) {
					ResumeProject u = new ResumeProject();
					BeanUtils.copyProperties(tp, u);//属性值复制
					u.setProjectId(tp.getId());//因为ID名称改变，所以需要手动设置
					projects.add(u);
				}
			}
			d.setRows(projects);
			d.setTotal((long)projects.size());
			return d; 
		}
		
		
		//----------------------获取简历相关的语言水平信息
		public DataGrid getResumeLanList(Integer resumeId){
			DataGrid d = new DataGrid();
			List<ResumeLanguage> lans = new ArrayList<ResumeLanguage>();
			String hql = "from TpLanguage t where 1=1 and t.resume.id="+resumeId;
			List<TpLanguage> tplans = resumeLanDao.find(hql);
			if (tplans != null && tplans.size() > 0) {
				for (TpLanguage tl : tplans) {
					ResumeLanguage u = new ResumeLanguage();
					BeanUtils.copyProperties(tl, u);//属性值复制
					u.setLanId(tl.getId());//因为ID名称改变，所以需要手动设置
					lans.add(u);
				}
			}
			d.setRows(lans);
			d.setTotal((long)lans.size());
			return d; 
		}
		
		
		//----------------------获取简历相关的工作意向信息
		public ResumeJobInten getResumeJobInten(Integer resumeId){
			ResumeJobInten jobInten = new ResumeJobInten();
			String hql = "from TpJobIntension t where 1=1 and t.resume.id="+resumeId;
			List<TpJobIntension> tpjobs = resumeJobIntenDao.find(hql);
			if (tpjobs != null && tpjobs.size() > 0) {
				TpJobIntension tmp = tpjobs.get(0);//本系统对于一个简历的求职意向也只有一项
				BeanUtils.copyProperties(tmp,jobInten);//属性值复制
				jobInten.setJobIntenId(tmp.getId());//由于id属性名称改变了，所以需要手动设置
			}
			return jobInten; 
		}
		
		
		
		//----------------------获取简历相关的其他信息
		public ResumeOtherInfo getResumeOtherInfo(Integer resumeId){
			ResumeOtherInfo otherInfo = new ResumeOtherInfo();
			String hql = "from TpOtherInfo t where 1=1 and t.resume.id="+resumeId;
			List<TpOtherInfo> tpothers = resumeOtherDao.find(hql);
			if (tpothers != null && tpothers.size() > 0) {
				TpOtherInfo tmp = tpothers.get(0);//本系统对于一个简历的其他信息也只有一项
				BeanUtils.copyProperties(tmp,otherInfo);//属性值复制
				otherInfo.setOtherId(tmp.getId());//由于id属性名称改变了，所以需要手动设置
			}
			return otherInfo; 
		}
		


}
