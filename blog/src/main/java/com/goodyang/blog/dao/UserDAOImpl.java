package com.goodyang.blog.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.goodyang.blog.po.User;

public class UserDAOImpl extends DAOSupport implements UserDAO {

	@Override
	public void add(User user) {
		Session session = getSession();
		session.save(user);
		session.flush();
	}

	@Override
	public void delete(User user) {
		getSession().delete(user);
	}

	@Override
	public void update(User user) {
		getSession().update(user);
	}

	@Override
	public List<User> queryAll() {
		return (List<User>)getSession().createQuery("from User ").list();
	}

	@Override
	public User queryByID(String username) {
		
		return (User)getSession()
				.createQuery("from User as u where u.username= :username")
				.setString("username", username)
				.uniqueResult();
	}

}
