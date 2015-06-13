package com.oc.action.base;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.alibaba.fastjson.JSON;
import com.oc.dto.Json;
import com.oc.dto.Page;
import com.oc.service.BaseServiceI;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("basePackage")
@Namespace("/")
public abstract class BaseAction<T> extends ActionSupport{
	private static final Logger logger = Logger.getLogger(BaseAction.class);
	
	protected abstract BaseServiceI<T>  getService();
	
	protected T o;
	
	private Page page;
	
	private Integer[] ids;
	/**
	 * 将对象转换成JSON字符串，并响应回前台
	 * 
	 * @param object
	 * @throws IOException
	 */
	public void writeJson(Object object) {
		try {
			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获得request
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * 获得response
	 * 
	 * @return
	 */
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	
	public void add() throws Exception {
		Json j = new Json();
		try {
		 getService().saveOrUpdate(getModel());
			j.setSuccess(true);
			j.setMsg("添加成功");
			j.setObj(o);
		} catch (Exception e) {
			j.setSuccess(false);
			j.setMsg("添加失败");
		}
		writeJson(j);
	}

	public void delete() {
		
		getService().remove(ids);;
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("删除成功");
		writeJson(j);
	}

	public String userEdit() {
		return "userEdit";
	}

	public void edit() {
		 getService().saveOrUpdate(getModel());;
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("编辑成功");
		j.setObj(o);
		writeJson(j);
	}

	protected abstract T getModel();
	public void datagrid() {
		this.writeJson(getService().datagrid((Page)getModel()));
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

}
