package com.netshot.util;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class SessionListener implements HttpSessionListener {

	private static int sessionCount = 0;
	
//	private ILoginService loginInfoService;

	public SessionListener() {
		super(); 
//		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(HttpSession);
//		loginInfoService=
	}

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session=event.getSession();
		ServletContext svltCxt=event.getSession().getServletContext();
		session.setAttribute("contextPath", svltCxt.getContextPath());
		System.out.println(svltCxt.getContextPath());
		System.out.println(svltCxt.getServletContextName());
		
		WebApplicationContext wac;
		wac=WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
//		loginInfoService=(ILoginService)wac.getBean("LoginService");
		System.out.println("session Create:" + new Date());
		System.out.println("The ID of the session created is :"+session.getId());
		++sessionCount;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event){
		HttpSession session=event.getSession();
//		LoginInfoVO loginInfoVO = (LoginInfoVO) session.getAttribute("loginInfo");
		try {
			Date currentTime = new TimeOperation().getCurrentDate();
//			if (loginInfoVO != null) {
//				loginInfoVO.setLogoutTime(currentTime);
//				loginInfoService.updateLoginInfo(loginInfoVO);
//			}
			System.out.println("session Destroy:" + currentTime);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("The ID of the session destoryed is :"+session.getId());
		--sessionCount;
	}

	public static int getCount() {
		return sessionCount;
	}
}
