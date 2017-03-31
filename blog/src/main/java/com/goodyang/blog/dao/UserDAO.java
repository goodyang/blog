package com.goodyang.blog.dao;

import java.util.List;

import com.goodyang.blog.po.User;

public interface UserDAO {
	public void add(User user);
	
	public void delete(User user);
	
	public void update(User user);
	
	public List<User> queryAll();
	
	public User queryByID(String username);
}
