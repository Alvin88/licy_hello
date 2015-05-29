package com.oc.action;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oc.action.base.BaseAction;
import com.oc.dto.Json;
import com.oc.dto.SessionInfo;
import com.oc.dto.User;
import com.oc.service.UserServiceI;
import com.oc.utils.system.IpUtil;
import com.oc.utils.system.ResourceUtil;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/")
@Action(value = "userAction", results = {
		@Result(name = "loginSuccess", type="redirect",location = "/index.jsp"),
		@Result(name = "loginFail", location = "/login.jsp"),
		@Result(name = "userEdit", location = "/views/admin/userEdit.jsp"),
		@Result(name = "doNotNeedSession_userInfo", location = "/views/user/userInfo.jsp")})
@SuppressWarnings("all")
public class UserAction extends BaseAction implements ModelDriven<User> {
	private static final Logger logger = Logger.getLogger(UserAction.class);
	User user = new User();

	public User getModel() {
		return user;
	}

	@Autowired
	private UserServiceI userService;

	public UserServiceI getUserService() {
		return userService;
	}

	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	public void reg() throws Exception {
		Json j = new Json();
		try {
			userService.save(user);
			j.setSuccess(true);
			j.setMsg("注册成功");
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("注册失败");
		}
		writeJson(j);
	}

	public String login() {
		User u = userService.login(user);
		if (u != null) {
			SessionInfo sessionInfo = new SessionInfo();
			sessionInfo.setUserId(u.getId());
			sessionInfo.setLoginName(user.getName());
			sessionInfo.setLoginPassword(user.getPwd());
			sessionInfo.setIp(IpUtil.getIpAddr(ServletActionContext.getRequest()));
			ServletActionContext.getRequest().getSession().setAttribute(ResourceUtil.getSessionInfoName(), sessionInfo);
			sessionInfo.setAuthIds(u.getAuthIds());
			sessionInfo.setAuthNames(u.getAuthNames());
			sessionInfo.setRoleIds(u.getRoleIds());
			sessionInfo.setRoleNames(u.getRoleNames());
			sessionInfo.setAuthUrls(u.getAuthUrls());
			return "loginSuccess";
		} else {
			this.getRequest().setAttribute("error", "用户名或密码错误,请重试");
			return "loginFail";
		}
		
		
	}

	public void datagrid() {
		super.writeJson(userService.datagrid(user));
	}

	public void add() throws Exception {
		Json j = new Json();
		try {
			User u = userService.save(user);
			j.setSuccess(true);
			j.setMsg("添加成功");
			j.setObj(u);
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("添加失败");
		}
		writeJson(j);
	}

	public void delete() {
		userService.remove(user.getIds());
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("删除成功");
		writeJson(j);
	}

	public String userEdit() {
		return "userEdit";
	}

	public void edit() {
		User u = userService.edit(user);
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("编辑成功");
		j.setObj(u);
		writeJson(j);
	}

	public void doNotNeedSession_logout() {
		ServletActionContext.getRequest().getSession().invalidate();
		Json j = new Json();
		j.setSuccess(true);
		super.writeJson(j);
	}

	public String doNotNeedSession_userInfo() {
		return "doNotNeedSession_userInfo";
	}

	public void doNotNeedSession_editUserInfo() {
        Json j=new Json();
        try {
			userService.editUserInfo(user);
			j.setSuccess(true);
			j.setMsg("修改成功！");
		} catch (Exception e) {
			j.setMsg("修改失败！");
		}
		super.writeJson(j);
 	}
}
