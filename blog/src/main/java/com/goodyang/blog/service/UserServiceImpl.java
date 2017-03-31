package com.goodyang.blog.service;

import com.goodyang.blog.dao.UserDAO;
import com.goodyang.blog.po.User;

public class UserServiceImpl implements UserService{
	private UserDAO userDAO;
	
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	@Override
	public boolean registerUser(User user) {
		if(userDAO.queryByID(user.getUsername())==null) {
			userDAO.add(user);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean loginUser(User user) {
		if(userDAO.queryByID(user.getUsername())!=null) {
			User queryUser = userDAO.queryByID(user.getUsername());
			if(queryUser.getPassword().equals(user.getPassword())) {
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
}
