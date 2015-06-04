package com.oc.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.oc.utils.system.ResourceUtil;
import com.oc.utils.system.SessionInfo;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * session拦截器
 * 
 * @author 
 */
public class LoginedCheckInterceptor extends AbstractInterceptor {

	private static final Logger logger = Logger.getLogger(LoginedCheckInterceptor.class);

	public  String intercept(ActionInvocation actionInvocation) throws Exception {
		HttpServletRequest httpRequest = ServletActionContext.getRequest();
		HttpServletResponse httpResponse = ServletActionContext.getResponse();
		// 取得请求的URL
		String url = httpRequest.getRequestURL().toString();
		// 验证Session是否过期
		if (!ServletActionContext.getRequest().isRequestedSessionIdValid()) {
			// session过期,转向session过期提示页,最终跳转至登录页面
			if ("XMLHttpRequest".equals(httpRequest
					.getHeader("x-requested-with"))) {// ajax
				httpResponse.addHeader("__timeout", "true");
				return null;
			} else
				return "tologin";
		} else {
			// 对登录与注销请求直接放行,不予拦截
			if (url.indexOf("/userAction!login.action") != -1) {
				return actionInvocation.invoke();
			} else {
				SessionInfo sessionInfo = (SessionInfo) ServletActionContext.getRequest().getSession().getAttribute(ResourceUtil.getSessionInfoName());
				// 验证是否已经登录
				if (sessionInfo == null) {
					// session过期,转向session过期提示页,最终跳转至登录页面
					if ("XMLHttpRequest".equals(httpRequest
							.getHeader("x-requested-with"))) {// ajax
						httpResponse.addHeader("__timeout", "true");
						return null;
					} else
						return "tologin";
				} else {
					// 已登录直接放行
					return actionInvocation.invoke();
				}
			}
		}
	}

}
