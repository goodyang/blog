package com.goodyang.blog.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DAOSupport {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	protected Session getSession(){
		Session session;
		try {
			session = this.sessionFactory.getCurrentSession();
		} catch (Exception e) {
			session = this.sessionFactory.openSession();
		}
		return session;
	}
}
