package com.dianzishangwu.yihunli.article.service;

import java.io.Serializable;
import java.util.List;

import com.dianzishangwu.yihunli.article.dao.ArticleHibernate4;
import com.dianzishangwu.yihunli.domain.article.Article;
import com.dianzishangwu.yihunli.domain.user.Merchant.WEDDTYPE;

public class ArticleService {
	
	private ArticleHibernate4 articleDao;

	public ArticleHibernate4 getArticleDao() {
		return articleDao;
	}

	public void setArticleDao(ArticleHibernate4 articleDao) {
		this.articleDao = articleDao;
	}
	 
	public Serializable saveArticle(Article article){
		return articleDao.save(article);
	}
	 
	public List<Article> findArticles(String userEntityId,int pageNo,int pageSize){
		return articleDao.findByPageById(userEntityId, pageNo, pageSize);
	}
	
	public List<Article> findMerchantArticles(int pageNo,int pageSize){
		return articleDao.findMerchantArticles(pageNo, pageSize);
	}
	
	public List<Article> findUserArticles(int pageNo,int pageSize){
		return articleDao.findUserArticles(pageNo, pageSize);
	}
	
	public long getUserArticleNum(){
		return articleDao.getUserArticleNum();
	}
	
	public long getMerchantArticleNum(){
		return articleDao.getMerchantArticleNum();
	}
	
	public long getMerchantArticleNumByType(WEDDTYPE type){
		return articleDao.getMerchantArticleNumByType(type);
	}
	
	public List<Article> findArticlesByType(WEDDTYPE type,int pageNo,int pageSize){
		return articleDao.findByPageByType(type, pageNo, pageSize);
	}
	
	public List<Article> findArticleBy(Integer articleId){
		return articleDao.findArticleBy(articleId);
	}
	
	public void updateArticle(Article article){
		articleDao.update(article);	
	}
	
	public void removeArticle(Article article){
		articleDao.delete(article);
	}
	
	public void removeArticle(Integer articleId){
		articleDao.delete(Article.class, articleId);
	}

}
