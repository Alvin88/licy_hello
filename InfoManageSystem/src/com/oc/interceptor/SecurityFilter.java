package com.oc.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.druid.Constants;
import com.oc.dto.SessionInfo;
import com.oc.utils.system.ResourceUtil;

public class SecurityFilter implements Filter {
	@SuppressWarnings("unused")
	private FilterConfig filterCon = null;

	public void init(FilterConfig config) throws ServletException {
		filterCon = config;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		SessionInfo sessionInfo = (SessionInfo)httpRequest.getSession().getAttribute(ResourceUtil.getSessionInfoName());
		String str = httpRequest.getRequestURL().toString();
		if (sessionInfo == null) {
			if (str.indexOf("/login.jsp") == -1) {
				httpResponse.sendRedirect(httpRequest.getContextPath()
						+ "/login.jsp");
			} else {
				filterChain.doFilter(request, response);
			}
		} else {
			filterChain.doFilter(request, response);
		}
	}

	public void destroy() {
		filterCon = null;
	}
}
