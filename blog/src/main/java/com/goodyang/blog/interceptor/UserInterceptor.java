package com.goodyang.blog.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation actioninvocation) throws Exception {
		ActionContext context = actioninvocation.getInvocationContext();
		Map<String, Object> session = context.getSession();
		String username = (String)session.get("username");
		if(username == null || "".equals(username)) {
			return Action.LOGIN;
		}else{
			return actioninvocation.invoke();
		}
	}
	
}
