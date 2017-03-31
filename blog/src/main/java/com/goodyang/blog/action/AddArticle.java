package com.goodyang.blog.action;

import java.util.Date;
import java.util.Map;

import com.goodyang.blog.po.Article;
import com.goodyang.blog.service.ArticleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddArticle extends ActionSupport{
	private String title;
	private String content;
	private ArticleService articleService;
	
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	@Override
	public String execute() throws Exception {
		Article article = new Article();
		article.setTitle(title);
		article.setContent(content);
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username = (String)session.get("username");
		article.setUsername(username);
		article.setDate(new Date());
		article.setHasread(0);
		articleService.addArticle(article);
		return this.SUCCESS;
	}
}
