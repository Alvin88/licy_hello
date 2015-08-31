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
import com.oc.dto.Talent;
import com.oc.model.Tresume;
import com.oc.model.Ttalent;
import com.oc.service.TalentServiceI;
import com.oc.utils.system.CodeGenerator;
import com.oc.utils.system.DataGrid;
import com.oc.utils.system.Encrypt;
import com.oc.utils.system.ResourceUtil;
import com.oc.utils.system.SessionInfo;
import com.oc.utils.system.SysConstants;
@Service("talentService")
public class TalentServiceImpl implements TalentServiceI {
	private BaseDaoI<Ttalent> talentDao;//rencai基本信息dao
	
	public BaseDaoI<Ttalent> getTalentDao() {
		return talentDao;
	}
	@Autowired
	public void setTalentDao(BaseDaoI<Ttalent> talentDao) {
		this.talentDao = talentDao;
	}

	@Override
	public DataGrid datagrid(Talent talent) {
		DataGrid d = new DataGrid();
		d.setRows(changerModel(find(talent)));
		d.setTotal(total(talent));
		return d;
	}

	@Override
	public boolean saveOrUpdateTalent(Talent talent) {
		if(talent.getId()!=null){//表示修改
			Ttalent t = talentDao.get(Ttalent.class, talent.getId());
			String code = t.getCode();//人才编号不能改变
			String createUserId = t.getCreateUserId();//创建人ID是不能变的
			String createUserName = t.getCreateUserName();//创建人姓名是不能变的
			Date createDate = t.getCreateDate();//创建时间是不能变化的
			Integer auditStatus = t.getAuditStatus();//审核状态不变
			//Integer isPublish = t.getIsPublish();//是否发布状态不变
			BeanUtils.copyProperties(talent, t);//这里会改变部分属性值，因此事先需要记录，然后再设置值
			//然后设置保留原来的值，并设置修改时间
			t.setCode(code);//保留人才编号
			t.setCreateDate(createDate);//保留创建时间
			t.setCreateUserId(createUserId);//保留创建人id
			t.setCreateUserName(createUserName);//保留创建人姓名
			t.setAuditStatus(auditStatus);//保留审核状态
			t.setModifyDate(new Date());
			talentDao.saveOrUpdate(t);//保存修改内容
			talent.setId(t.getId());//设置保存后的id
			return true;//添加成功
		}else{//表示新增
			Ttalent t = new Ttalent();
			String hql ="from Ttalent t where t.mobile='"+talent.getMobile()+"'";
			List<Ttalent> tmp = talentDao.find(hql);
			if(tmp!=null&&tmp.size()>0){
				return false;//表示已经具有该人才失败，添加失败
			}else{
				BeanUtils.copyProperties(talent, t);
				//t.setId(UUID.randomUUID().toString());
				t.setCode(CodeGenerator.getResumeNo());//自动创建简历编号
				t.setCreateDate(new Date());//创建日期
				SessionInfo sessionInfo = (SessionInfo) ServletActionContext.getRequest().getSession().getAttribute(ResourceUtil.getSessionInfoName());
				t.setCreateUserId(sessionInfo.getUserId());//创建人ID
				t.setCreateUserName(sessionInfo.getLoginName());//创建人
				//初始化时审核状态为未审核，发布状态为未发布
				t.setAuditStatus(SysConstants.NO_AUDIT);//未审核
				t.setIsPublish(SysConstants.PUBLISH_NO);//未发布
				talentDao.save(t);//新增内容
				talent.setId(t.getId());//设置人才id
				return true;
			}
		}
	}

	@Override
	public void deleteTalent(String ids) {
		// TODO Auto-generated method stub
		if (ids != null) {
			for (String id : ids.split(",")) {
				if (!id.trim().equals("0")) {
					Ttalent u = talentDao.get(Ttalent.class, Integer.valueOf(id.trim()));
					if (u != null) {
						//userroleDao.executeHql("delete Tusertrole t where t.tuser = ?", new Object[] { u });//如果没有级联删除，需要手动删除简历关联的其他信息
						talentDao.delete(u);
					}
				}
			}
		}
	}

	
	//将从数据库中获取的数据进行模型转换
		private List<Talent> changerModel(List<Ttalent> talentList) {
			List<Talent> talents = new ArrayList<Talent>();
			if (talentList != null && talentList.size() > 0) {
				for (Ttalent tre : talentList) {
					Talent u = new Talent();
					BeanUtils.copyProperties(tre, u);//属性值复制，属性名称相同的会复制，因此要保证两个类需要复制的属性值相同
					talents.add(u);//添加
				}
			}
			return talents;
		}

		
		//find方法实现
		private List<Ttalent> find(Talent talent) {
			String hql = "from Ttalent t where 1=1";
			List<Object> values = new ArrayList<Object>();
			hql = addWhere(talent, hql, values);
			if (talent.getSort() != null && talent.getOrder() != null) {
				hql += " order by " + talent.getSort() + " " + talent.getOrder();
			}
			return talentDao.find(hql, values, talent.getPage(), talent.getRows());
		}
		
		//查询条件
		private String addWhere(Talent resume, String hql, List<Object> values) {
			if(resume.getCertificateType()!=null&&!resume.getCertificateType().equals("")){
				hql += " and t.certificateType like ?";
				values.add("%%"+resume.getCertificateType().trim()+"%%");
			}
			System.out.println(resume.getProfession());
			if(resume.getProfession()!=null&& !resume.getProfession().equals("")){
				hql += " and t.profession like ?";
				values.add("%%"+resume.getProfession().trim()+"%%");
			}
			if(resume.getSbArea()!=null&&!resume.getSbArea().equals("")){
				hql += " and t.sbArea like ?";
				values.add("%%"+resume.getSbArea().trim()+"%%");
			}
			return hql;
		}
		
		private Long total(Talent talent) {
			String hql = "select count(*) from Ttalent t where 1=1 ";
			List<Object> values = new ArrayList<Object>();
			hql = addWhere(talent, hql, values);
			return talentDao.count(hql, values);
		}
}
