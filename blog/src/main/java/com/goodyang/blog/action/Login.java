package com.goodyang.blog.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.goodyang.blog.po.User;
import com.goodyang.blog.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport{
	private String username;
	private String password;
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String execute() throws Exception {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		if(userService.loginUser(user)) {
			request.setAttribute("url", "user/getBlogInfo.action");
			request.setAttribute("info", "登录成功");
			
			Map< String, Object> sessionMap = ActionContext.getContext().getSession();
			sessionMap.put("username", username);
			return SUCCESS;
		}else{
			request.setAttribute("url", "login.jsp");
			request.setAttribute("info", "登录失败");
			return ERROR;
		}
	}
	
}
