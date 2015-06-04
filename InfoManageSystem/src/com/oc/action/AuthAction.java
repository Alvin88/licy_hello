package com.oc.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oc.action.base.BaseAction;
import com.oc.dto.Auth;
import com.oc.service.AuthServiceI;
<<<<<<< HEAD
import com.oc.utils.system.Json;
=======
import com.oc.service.BaseServiceI;
>>>>>>> branch 'master' of https://github.com/Alvin88/licy_hello
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/")
@Action(value = "authAction", results = { @Result(name = "authAdd", location = "/admin/authAdd.jsp"), @Result(name = "authEdit", location = "/admin/authEdit.jsp") })
public class AuthAction extends BaseAction implements ModelDriven<Auth> {
	private AuthServiceI authService;

	public AuthServiceI getAuthService() {
		return authService;
	}

	@Autowired
	public void setAuthService(AuthServiceI authService) {
		this.authService = authService;
	}

	public Auth getAuth() {
		return auth;
	}

	public void setAuth(Auth auth) {
		this.auth = auth;
	}

	private Auth auth = new Auth();

	@Override
	public Auth getModel() {
		return auth;
	}

	/**
	 * 获得权限树
	 */
	public void doNotNeedSession_treeRecursive() {
		super.writeJson(authService.tree(auth, true));
	}

	public void treegrid() {
		writeJson(authService.treegrid(auth));
	}

	/**
	 * 添加权限
	 * 
	 * @return
	 */
	public String authAdd() {
		return "authAdd";
	}

	public void add() {
		Json j = new Json();
		try {
			authService.add(auth);
			j.setSuccess(true);
			j.setMsg("添加成功!");
		} catch (Exception e) {
			j.setMsg("添加失败！");
		}
		super.writeJson(j);
	}

	@Override
	protected BaseServiceI getService() {
		// TODO Auto-generated method stub
		return null;
	}
}
