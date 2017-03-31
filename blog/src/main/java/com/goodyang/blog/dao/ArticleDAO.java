package com.goodyang.blog.dao;

import java.util.List;

import com.goodyang.blog.fenye.Page;
import com.goodyang.blog.po.Article;

public interface ArticleDAO {
	public void add(Article article);
	
	public int queryUserAllCount(String username);
	
	public List<Article> queryByPage(final String username, final Page page);
	
	//定义一个queryUserAll,用来取出用户的所有文章
	public List<Article> queryUserAll(String username);
	
	//获得所有文章的总记录数
	public int queryAllCount();
	
	//按分页信息查询记录
	public List<Article> queryAllByPage(Page page);
	
	//按ID查询文章
	public Article queryById(int id);
}
