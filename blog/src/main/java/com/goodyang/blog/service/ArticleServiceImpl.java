package com.goodyang.blog.service;

import com.goodyang.blog.dao.ArticleDAO;
import com.goodyang.blog.po.Article;

public class ArticleServiceImpl implements ArticleService{
	private ArticleDAO articleDAO;
	
	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}
	
	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
	
	public void addArticle(Article article) {
		articleDAO.add(article);
	}
}
