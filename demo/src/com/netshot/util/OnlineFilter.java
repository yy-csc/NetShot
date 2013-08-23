package com.netshot.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OnlineFilter extends HttpServlet implements Filter {

	public void doFilter(ServletRequest sRequest, ServletResponse sResponse,
			FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) sRequest;
		HttpServletResponse response = (HttpServletResponse) sResponse;
		HttpSession session = request.getSession();
		
		String url = request.getServletPath();
		String contextPath = request.getContextPath();
		if (url.equals(""))
			url += "/";
		if ((url.startsWith("/") 
				&& !url.startsWith("/css")
				&& !url.startsWith("/img")
				&& !url.startsWith("/jsp/login"))) {
			if (session.getAttribute("osmMemInfo") == null) {
				response.sendRedirect(contextPath + "/jsp/login.jsp");
				return;
			}
		}
		filterChain.doFilter(sRequest, sResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
