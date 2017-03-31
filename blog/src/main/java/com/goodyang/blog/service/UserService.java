package com.goodyang.blog.service;

import com.goodyang.blog.po.User;

public interface UserService {
	
	public boolean registerUser(User user);
	
	public boolean loginUser(User user);
}
