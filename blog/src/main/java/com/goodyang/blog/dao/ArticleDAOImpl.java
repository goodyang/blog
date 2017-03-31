package com.goodyang.blog.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.goodyang.blog.fenye.Page;
import com.goodyang.blog.po.Article;

public class ArticleDAOImpl extends DAOSupport implements ArticleDAO{

	@Override
	public void add(Article article) {
		Session session = getSession();
		session.saveOrUpdate(article);
		session.flush();
	}

	@Override
	public int queryUserAllCount(String username) {
		return (int)getSession().createCriteria("Article")
				.add(Restrictions.eq("username", username))
				.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public List<Article> queryByPage(String username, Page page) {
		return getSession().createCriteria("Article")
				.add(Restrictions.eq("username", username))
				.setMaxResults(page.getEveryPage())
				.setFirstResult(page.getBeginIndex())
				.addOrder(Order.desc("date"))
				.list();
	}

	@Override
	public List<Article> queryUserAll(String username) {
		return getSession().createCriteria("Article")
			.add(Restrictions.eq("username", username))
			.addOrder(Order.desc("date"))
			.list();
	}

	@Override
	public int queryAllCount() {
		return (int)getSession().createCriteria("Article")
				.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public List<Article> queryAllByPage(Page page) {
		return getSession().createCriteria("Article")
				.setMaxResults(page.getEveryPage())
				.setFirstResult(page.getBeginIndex())
				.addOrder(Order.desc("date"))
				.list();
	}

	@Override
	public Article queryById(int id) {
		return (Article)getSession().createCriteria("Article")
				.add(Restrictions.eq("Id", id))
				.uniqueResult();
	}
	
}
