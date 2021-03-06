package com.oc.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oc.dao.BaseDaoI;
import com.oc.model.Tauth;
import com.oc.model.Tmenu;
import com.oc.model.Troletauth;
import com.oc.model.Tuser;
import com.oc.service.RepairServiceI;
import com.oc.utils.system.Encrypt;

@Service("repairService")
public class RepairServiceImpl implements RepairServiceI {
	private BaseDaoI<Tauth> authDao;
	private BaseDaoI<Troletauth> roleauthDao;
	private BaseDaoI<Tmenu> menuDao;

	public BaseDaoI<Tauth> getAuthDao() {
		return authDao;
	}

	@Autowired
	public void setAuthDao(BaseDaoI<Tauth> authDao) {
		this.authDao = authDao;
	}

	public BaseDaoI<Troletauth> getRoleauthDao() {
		return roleauthDao;
	}

	@Autowired
	public void setRoleauthDao(BaseDaoI<Troletauth> roleauthDao) {
		this.roleauthDao = roleauthDao;
	}

	public BaseDaoI<Tmenu> getMenuDao() {
		return menuDao;
	}

	@Autowired
	public void setMenuDao(BaseDaoI<Tmenu> menuDao) {
		this.menuDao = menuDao;
	}

	@Autowired
	private BaseDaoI<Tuser> userDao;

	public BaseDaoI<Tuser> getUserDao() {
		return userDao;
	}

	public void setUserDao(BaseDaoI<Tuser> userDao) {
		this.userDao = userDao;
	}

	@Override
	public void repair() {
		repairUser();
		repairMenu();
		repairAuth();
	}

	private void repairAuth() {
		authDao.executeHql("update Tauth a set a.tauth = null");

		Tauth sshe = new Tauth();
		sshe.setCid("0");
		sshe.setTauth(null);
		sshe.setName("首页");
		sshe.setUrl("");
		sshe.setSeq(BigDecimal.valueOf(1));
		sshe.setCdesc("EasyUI示例项目");
		authDao.saveOrUpdate(sshe);

		Tauth xtgl = new Tauth();
		xtgl.setCid("xtgl");
		xtgl.setTauth(sshe);
		xtgl.setName("系统管理");
		xtgl.setUrl("");
		xtgl.setSeq(BigDecimal.valueOf(2));
		xtgl.setCdesc("");
		authDao.saveOrUpdate(xtgl);

		Tauth yhgl = new Tauth();
		yhgl.setCid("yhgl");
		yhgl.setTauth(xtgl);
		yhgl.setName("用户管理");
		yhgl.setUrl("");
		yhgl.setSeq(BigDecimal.valueOf(1));
		yhgl.setCdesc("");
		authDao.saveOrUpdate(yhgl);

		Tauth yhcx = new Tauth();
		yhcx.setCid("yhcx");
		yhcx.setTauth(yhgl);
		yhcx.setName("用户查询");
		yhcx.setUrl("/userAction!datagrid.action");
		yhcx.setSeq(BigDecimal.valueOf(1));
		yhcx.setCdesc("");
		authDao.saveOrUpdate(yhcx);

		Tauth yhadd = new Tauth();
		yhadd.setCid("yhadd");
		yhadd.setTauth(yhgl);
		yhadd.setName("用户添加");
		yhadd.setUrl("/userAction!add.action");
		yhadd.setSeq(BigDecimal.valueOf(2));
		yhadd.setCdesc("");
		authDao.saveOrUpdate(yhadd);

		Tauth yhedit = new Tauth();
		yhedit.setCid("yhedit");
		yhedit.setTauth(yhgl);
		yhedit.setName("用户修改");
		yhedit.setUrl("/userAction!edit.action");
		yhedit.setSeq(BigDecimal.valueOf(3));
		yhedit.setCdesc("");
		authDao.saveOrUpdate(yhedit);

		Tauth yhsc = new Tauth();
		yhsc.setCid("yhsc");
		yhsc.setTauth(yhgl);
		yhsc.setName("用户删除");
		yhsc.setUrl("/userAction!delete.action");
		yhsc.setSeq(BigDecimal.valueOf(4));
		yhsc.setCdesc("");
		authDao.saveOrUpdate(yhsc);

		Tauth jsgl = new Tauth();
		jsgl.setCid("jsgl");
		jsgl.setTauth(xtgl);
		jsgl.setName("角色管理");
		jsgl.setUrl("");
		jsgl.setSeq(BigDecimal.valueOf(2));
		jsgl.setCdesc("");
		authDao.saveOrUpdate(jsgl);

		Tauth jscx = new Tauth();
		jscx.setCid("jscx");
		jscx.setTauth(jsgl);
		jscx.setName("角色查询");
		jscx.setUrl("/roleAction!datagrid.action");
		jscx.setSeq(BigDecimal.valueOf(1));
		jscx.setCdesc("");
		authDao.saveOrUpdate(jscx);

		Tauth jsaddym = new Tauth();
		jsaddym.setCid("jsaddym");
		jsaddym.setTauth(jsgl);
		jsaddym.setName("添加角色页面");
		jsaddym.setUrl("/roleAction!roleAdd.action");
		jsaddym.setSeq(BigDecimal.valueOf(2));
		jsaddym.setCdesc("");
		authDao.saveOrUpdate(jsaddym);

		Tauth jsadd = new Tauth();
		jsadd.setCid("jsadd");
		jsadd.setTauth(jsgl);
		jsadd.setName("角色添加");
		jsadd.setUrl("/roleAction!add.action");
		jsadd.setSeq(BigDecimal.valueOf(3));
		jsadd.setCdesc("");
		authDao.saveOrUpdate(jsadd);

		Tauth jseditym = new Tauth();
		jseditym.setCid("jseditym");
		jseditym.setTauth(jsgl);
		jseditym.setName("编辑角色页面");
		jseditym.setUrl("/roleAction!roleEdit.action");
		jseditym.setSeq(BigDecimal.valueOf(4));
		jseditym.setCdesc("");
		authDao.saveOrUpdate(jseditym);

		Tauth jsedit = new Tauth();
		jsedit.setCid("jsedit");
		jsedit.setTauth(jsgl);
		jsedit.setName("角色编辑");
		jsedit.setUrl("/roleAction!edit.action");
		jsedit.setSeq(BigDecimal.valueOf(5));
		jsedit.setCdesc("");
		authDao.saveOrUpdate(jsedit);

		Tauth jsdelete = new Tauth();
		jsdelete.setCid("jsdelete");
		jsdelete.setTauth(jsgl);
		jsdelete.setName("角色删除");
		jsdelete.setUrl("/roleAction!delete.action");
		jsdelete.setSeq(BigDecimal.valueOf(6));
		jsdelete.setCdesc("");
		authDao.saveOrUpdate(jsdelete);

		Tauth qxgl = new Tauth();
		qxgl.setCid("qxgl");
		qxgl.setTauth(xtgl);
		qxgl.setName("权限管理");
		qxgl.setUrl("");
		qxgl.setSeq(BigDecimal.valueOf(3));
		qxgl.setCdesc("");
		authDao.saveOrUpdate(qxgl);

		Tauth qxcx = new Tauth();
		qxcx.setCid("qxcx");
		qxcx.setTauth(qxgl);
		qxcx.setName("权限查询");
		qxcx.setUrl("/authAction!treegrid.action");
		qxcx.setSeq(BigDecimal.valueOf(1));
		qxcx.setCdesc("");
		authDao.saveOrUpdate(qxcx);

		Tauth qxaddym = new Tauth();
		qxaddym.setCid("qxaddym");
		qxaddym.setTauth(qxgl);
		qxaddym.setName("添加权限页面");
		qxaddym.setUrl("/authAction!authAdd.action");
		qxaddym.setSeq(BigDecimal.valueOf(2));
		qxaddym.setCdesc("");
		authDao.saveOrUpdate(qxaddym);

		Tauth qxadd = new Tauth();
		qxadd.setCid("qxadd");
		qxadd.setTauth(qxgl);
		qxadd.setName("权限添加");
		qxadd.setUrl("/authAction!add.action");
		qxadd.setSeq(BigDecimal.valueOf(3));
		qxadd.setCdesc("");
		authDao.saveOrUpdate(qxadd);

		Tauth qxeditym = new Tauth();
		qxeditym.setCid("qxeditym");
		qxeditym.setTauth(qxgl);
		qxeditym.setName("编辑权限页面");
		qxeditym.setUrl("/authAction!authEdit.action");
		qxeditym.setSeq(BigDecimal.valueOf(4));
		qxeditym.setCdesc("");
		authDao.saveOrUpdate(qxeditym);

		Tauth qxedit = new Tauth();
		qxedit.setCid("qxedit");
		qxedit.setTauth(qxgl);
		qxedit.setName("权限编辑");
		qxedit.setUrl("/demo/authAction!edit.action");
		qxedit.setSeq(BigDecimal.valueOf(5));
		qxedit.setCdesc("");
		authDao.saveOrUpdate(qxedit);

		Tauth qxdelete = new Tauth();
		qxdelete.setCid("qxdelete");
		qxdelete.setTauth(qxgl);
		qxdelete.setName("权限删除");
		qxdelete.setUrl("/authAction!delete.action");
		qxdelete.setSeq(BigDecimal.valueOf(6));
		qxdelete.setCdesc("");
		authDao.saveOrUpdate(qxdelete);

		Tauth cdgl = new Tauth();
		cdgl.setCid("cdgl");
		cdgl.setTauth(xtgl);
		cdgl.setName("菜单管理");
		cdgl.setUrl("");
		cdgl.setSeq(BigDecimal.valueOf(4));
		cdgl.setCdesc("");
		authDao.saveOrUpdate(cdgl);

		Tauth cdcx = new Tauth();
		cdcx.setCid("cdcx");
		cdcx.setTauth(cdgl);
		cdcx.setName("菜单查询");
		cdcx.setUrl("/menuAction!treegrid.action");
		cdcx.setSeq(BigDecimal.valueOf(1));
		cdcx.setCdesc("");
		authDao.saveOrUpdate(cdcx);

		Tauth cdaddym = new Tauth();
		cdaddym.setCid("cdaddym");
		cdaddym.setTauth(cdgl);
		cdaddym.setName("添加菜单页面");
		cdaddym.setUrl("/menuAction!menuAdd.action");
		cdaddym.setSeq(BigDecimal.valueOf(2));
		cdaddym.setCdesc("");
		authDao.saveOrUpdate(cdaddym);

		Tauth cdadd = new Tauth();
		cdadd.setCid("cdadd");
		cdadd.setTauth(cdgl);
		cdadd.setName("菜单添加");
		cdadd.setUrl("/menuAction!add.action");
		cdadd.setSeq(BigDecimal.valueOf(3));
		cdadd.setCdesc("");
		authDao.saveOrUpdate(cdadd);

		Tauth cdeditym = new Tauth();
		cdeditym.setCid("cdeditym");
		cdeditym.setTauth(cdgl);
		cdeditym.setName("编辑菜单页面");
		cdeditym.setUrl("/menuAction!menuEdit.action");
		cdeditym.setSeq(BigDecimal.valueOf(4));
		cdeditym.setCdesc("");
		authDao.saveOrUpdate(cdeditym);

		Tauth cdedit = new Tauth();
		cdedit.setCid("cdedit");
		cdedit.setTauth(cdgl);
		cdedit.setName("菜单编辑");
		cdedit.setUrl("/demo/menuAction!edit.action");
		cdedit.setSeq(BigDecimal.valueOf(5));
		cdedit.setCdesc("");
		authDao.saveOrUpdate(cdedit);

		Tauth cddelete = new Tauth();
		cddelete.setCid("cddelete");
		cddelete.setTauth(cdgl);
		cddelete.setName("菜单删除");
		cddelete.setUrl("/menuAction!delete.action");
		cddelete.setSeq(BigDecimal.valueOf(6));
		cddelete.setCdesc("");
		authDao.saveOrUpdate(cddelete);

		//简历管理
		Tauth jlgl = new Tauth();
		jlgl.setCid("jlgl");
		jlgl.setTauth(xtgl);
		jlgl.setName("简历管理");
		jlgl.setUrl("");
		jlgl.setSeq(BigDecimal.valueOf(5));
		jlgl.setCdesc("");
		authDao.saveOrUpdate(jlgl);

		Tauth jlcx = new Tauth();
		jlcx.setCid("jlcx");
		jlcx.setTauth(jlgl);
		jlcx.setName("简历查询");
		jlcx.setUrl("/authAction!treegrid.action");
		jlcx.setSeq(BigDecimal.valueOf(1));
		jlcx.setCdesc("");
		authDao.saveOrUpdate(jlcx);

		Tauth jltjym = new Tauth();
		jltjym.setCid("jltjym");
		jltjym.setTauth(jlgl);
		jltjym.setName("添加简历页面");
		jltjym.setUrl("/authAction!authAdd.action");
		jltjym.setSeq(BigDecimal.valueOf(2));
		jltjym.setCdesc("");
		authDao.saveOrUpdate(jltjym);

		Tauth jltj = new Tauth();
		jltj.setCid("jltj");
		jltj.setTauth(jlgl);
		jltj.setName("权限添加");
		jltj.setUrl("/authAction!add.action");
		jltj.setSeq(BigDecimal.valueOf(3));
		jltj.setCdesc("");
		authDao.saveOrUpdate(jltj);

		Tauth jlbjym = new Tauth();
		jlbjym.setCid("jlbjym");
		jlbjym.setTauth(jlgl);
		jlbjym.setName("编辑权限页面");
		jlbjym.setUrl("/authAction!authEdit.action");
		jlbjym.setSeq(BigDecimal.valueOf(4));
		jlbjym.setCdesc("");
		authDao.saveOrUpdate(jlbjym);

		Tauth jlbj = new Tauth();
		jlbj.setCid("jlbj");
		jlbj.setTauth(jlgl);
		jlbj.setName("权限编辑");
		jlbj.setUrl("/demo/authAction!edit.action");
		jlbj.setSeq(BigDecimal.valueOf(5));
		jlbj.setCdesc("");
		authDao.saveOrUpdate(jlbj);

		Tauth jldelete = new Tauth();
		jldelete.setCid("jldelete");
		jldelete.setTauth(qxgl);
		jldelete.setName("权限删除");
		jldelete.setUrl("/authAction!delete.action");
		jldelete.setSeq(BigDecimal.valueOf(6));
		jldelete.setCdesc("");
		authDao.saveOrUpdate(jldelete);
		
		//公司管理
		Tauth gsgl = new Tauth();
		gsgl.setCid("gsgl");
		gsgl.setTauth(xtgl);
		gsgl.setName("简历管理");
		gsgl.setUrl("");
		gsgl.setSeq(BigDecimal.valueOf(5));
		gsgl.setCdesc("");
		authDao.saveOrUpdate(gsgl);

		Tauth gscx = new Tauth();
		gscx.setCid("gscx");
		gscx.setTauth(gsgl);
		gscx.setName("简历查询");
		gscx.setUrl("/companyAction!treegrid.action");
		gscx.setSeq(BigDecimal.valueOf(1));
		gscx.setCdesc("");
		authDao.saveOrUpdate(gscx);

		Tauth gstjym = new Tauth();
		gstjym.setCid("gstjym");
		gstjym.setTauth(gsgl);
		gstjym.setName("添加简历页面");
		gstjym.setUrl("/companyAction!authAdd.action");
		gstjym.setSeq(BigDecimal.valueOf(2));
		gstjym.setCdesc("");
		authDao.saveOrUpdate(gstjym);

		Tauth gstj = new Tauth();
		gstj.setCid("gstj");
		gstj.setTauth(gsgl);
		gstj.setName("权限添加");
		gstj.setUrl("/companyAction!add.action");
		gstj.setSeq(BigDecimal.valueOf(3));
		gstj.setCdesc("");
		authDao.saveOrUpdate(gstj);

		Tauth gsbjym = new Tauth();
		gsbjym.setCid("gsbjym");
		gsbjym.setTauth(gsgl);
		gsbjym.setName("编辑权限页面");
		gsbjym.setUrl("/companyAction!authEdit.action");
		gsbjym.setSeq(BigDecimal.valueOf(4));
		gsbjym.setCdesc("");
		authDao.saveOrUpdate(gsbjym);

		Tauth gsbj = new Tauth();
		gsbj.setCid("gsbj");
		gsbj.setTauth(gsgl);
		gsbj.setName("权限编辑");
		gsbj.setUrl("/demo/companyAction!edit.action");
		gsbj.setSeq(BigDecimal.valueOf(5));
		gsbj.setCdesc("");
		authDao.saveOrUpdate(gsbj);

		Tauth gsdelete = new Tauth();
		gsdelete.setCid("gsdelete");
		gsdelete.setTauth(qxgl);
		gsdelete.setName("权限删除");
		gsdelete.setUrl("/companyAction!delete.action");
		gsdelete.setSeq(BigDecimal.valueOf(6));
		gsdelete.setCdesc("");
		authDao.saveOrUpdate(gsdelete);
	}

	private void repairUser() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", "admin");
		Tuser t = userDao.getObject("from Tuser t where t.name=:name and t.id !='0'", params);
		if (t != null) {
			t.setName(UUID.randomUUID().toString());
		}
		Tuser admin = new Tuser();
		admin.setId("0");
		admin.setName("admin");
		admin.setPwd(Encrypt.e("admin"));
		admin.setCreatedatetime(new Date());
		userDao.saveOrUpdate(admin);
	}

	private void repairMenu() {
		Tmenu root = new Tmenu();
		root.setId("0");
		root.setText("首页");
		root.setUrl("");
		menuDao.saveOrUpdate(root);

		Tmenu xtgl = new Tmenu();
		xtgl.setId("xtgl");
		xtgl.setTmenu(root);
		xtgl.setText("系统管理");
		xtgl.setUrl("");
		menuDao.saveOrUpdate(xtgl);

		Tmenu yhgl = new Tmenu();
		yhgl.setId("yhgl");
		yhgl.setTmenu(xtgl);
		yhgl.setUrl("/views/admin/yhgl.jsp");
		yhgl.setText("用户管理");
		menuDao.saveOrUpdate(yhgl);

		Tmenu jsgl = new Tmenu();
		jsgl.setId("jsgl");
		jsgl.setTmenu(xtgl);
		jsgl.setUrl("/views/admin/role.jsp");
		jsgl.setText("角色管理");
		menuDao.saveOrUpdate(jsgl);

		Tmenu gxgl = new Tmenu();
		gxgl.setId("gxgl");
		gxgl.setTmenu(xtgl);
		gxgl.setUrl("/views/admin/auth.jsp");
		gxgl.setText("权限管理");
		menuDao.saveOrUpdate(gxgl);

		Tmenu cdgl = new Tmenu();
		cdgl.setId("cdgl");
		cdgl.setTmenu(xtgl);
		cdgl.setUrl("");
		cdgl.setText("菜单管理");
		menuDao.saveOrUpdate(cdgl);

		Tmenu jlgl = new Tmenu();
		jlgl.setId("jlgl");
		jlgl.setTmenu(jlgl);
		jlgl.setUrl("/views/resume/resume.jsp");
		jlgl.setText("简历管理");
		menuDao.saveOrUpdate(jlgl);
		
		Tmenu gsgl = new Tmenu();
		gsgl.setId("gsgl");
		gsgl.setTmenu(gsgl);
		gsgl.setUrl("/views/company/company.jsp");
		gsgl.setText("公司管理");
		menuDao.saveOrUpdate(gsgl);
	}
}
