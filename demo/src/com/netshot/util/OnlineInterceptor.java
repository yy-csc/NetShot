package com.netshot.util;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class OnlineInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
/*		HttpSession session = ServletActionContext.getRequest().getSession();
		if (session.getAttribute("osmMemInfo") != null
				|| "login"
						.equalsIgnoreCase(ai.getInvocationContext().getName())
				|| "admin"
						.equalsIgnoreCase(ai.getInvocationContext().getName())
				|| "forgotPwd"
						.equalsIgnoreCase(ai.getInvocationContext().getName())
				|| "resetPwd"
						.equalsIgnoreCase(ai.getInvocationContext().getName())
				) {
			String str=ai.invoke();
			return str;
		} 
		else if("forgotPwd".equalsIgnoreCase(ai.getInvocationContext().getName())){
			return "forgotPwd";
		}
		else {
			System.out.println("interceptor offline");
			return "login";
		}*/
		return "logon";
	}
}
