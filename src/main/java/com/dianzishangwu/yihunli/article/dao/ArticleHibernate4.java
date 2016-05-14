package com.dianzishangwu.yihunli.article.dao;

import java.io.Serializable;
import java.util.List;

import com.dianzishangwu.yihunli.domain.article.Article;
import com.dianzishangwu.yihunli.domain.dao.BaseDaoHibernate4;
import com.dianzishangwu.yihunli.domain.user.Merchant.WEDDTYPE;


public class ArticleHibernate4 extends BaseDaoHibernate4<Article>{
   
	 public List<Article> findByPageById(String userEntityId,int pageNo,int pageSize){
		 return super.findByPage("from Article as article where article.userEntityId = ?0",pageNo,pageSize,userEntityId);
	 }

	 public List<Article> findByPageByType(WEDDTYPE type,int pageNo,int pageSize){
		 return super.findByPage("from Article as article where article.type = ?0", pageNo, pageSize,type);
	 }
	 
	 public List<Article> findMerchantArticles(int pageNo,int pageSize){
		 return super.findByPage("from Article as article where article.type != null", pageNo, pageSize);
	 }
	 
	 public List<Article> findUserArticles(int pageNo,int pageSize){
		 return super.findByPage("from Article as article where article.type = null", pageNo, pageSize);
	 }
	 
	 public long getUserArticleNum(){
		 return super.findCountByCondition(Article.class, "type", "null","=");
	 } 
	 
	 public long getMerchantArticleNum(){
		 return super.findCountByCondition(Article.class, "type", "null","!=");
	 } 
	 
	 public long getMerchantArticleNumByType(WEDDTYPE type){
		 return super.findCountByCondition(Article.class,"type",type.ordinal(),"=");
	 }
	 
	 public List<Article> findUserArticlesByNew(int pageNo,int pageSize){
		 return super.findByPage("from Article as article where article.type = null order by article.date desc,article.time desc", pageNo, pageSize);
	 }
	 
	 public List<Article> findUserArticlesByHot(int pageNo,int pageSize){
		 return super.findByPage("from Article as article where article.type = null order by article.agree desc, article.date asc,article.time asc", pageNo, pageSize);
	 }
	 
	 public List<Article> findArticleBy(Integer articleId){
		 return super.find("from Article as article where article.id = ?0", articleId);
	 }
}
