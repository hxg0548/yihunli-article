package com.dianzishangwu.yihunli.yihunli_article;


import java.util.Date;
import java.util.List;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dianzishangwu.yihunli.article.service.ArticleService;
import com.dianzishangwu.yihunli.domain.article.Article;

import com.dianzishangwu.yihunli.domain.article.Resource;

import static org.junit.Assert.*;

public class ArticleTest 
{
	ApplicationContext beanContext ;
	ArticleService articleService;
	
	@Before
    public void prepare(){
    	beanContext = new ClassPathXmlApplicationContext("yihunli-article.xml");
    	articleService = (ArticleService)beanContext.getBean("articleService");
    }
	
    public void testApp()
    {
        Article article = new Article();
        article.setArea(Article.Area.LUXURY);
        article.setCity("广州市");
        article.setPrice("忻州市");
        article.setDate(new Date());
        article.setTime(new Date());
        article.setName("飘柔");
        article.setPrice("5.00");
        article.setText("酒店房间司法考试的jfk设计的");
        article.setUserEntityId("123456");
        article.setType(com.dianzishangwu.yihunli.domain.user.Merchant.WEDDTYPE.WEDDING_CAMERAMAN);
 
        Resource resource = new Resource();
        resource.setType("图片");
        resource.setUrl("/upload/IMAGE/jjs_1.jpg");
        article.addResource(resource);
        
        Resource resource1 = new Resource();
        resource1.setType("视频");
        resource1.setUrl("/upload/VIDEO/kks_1.jpg");
        article.addResource(resource1);
        
         ArticleService articleService = (ArticleService)beanContext.getBean("articleService");
        
         Object seri = articleService.saveArticle(article);
        
          assertEquals(3,seri);
    }
	
    @Test
	public void testGetArticleById(){
		
		  Object seri = 0;
		  for(int i =0; i < 100; i ++){
			  
		        Article article = new Article();
		        article.setArea(Article.Area.LUXURY);
		        article.setCity("广州市");
		        article.setPrice("忻州市");
		        article.setDate(new Date());
		        article.setTime(new Date());
		        article.setName("飘柔");
		        article.setPrice("5.00");
		        article.setText("酒店房间司法考试的jfk设计的");
		        article.setUserEntityId("123456");
		        
		        if(i % 3 == 0) article.setType(com.dianzishangwu.yihunli.domain.user.Merchant.WEDDTYPE.WEDDING_CAMERAMAN);
		        else if(i % 5 == 0 ) article.setType(com.dianzishangwu.yihunli.domain.user.Merchant.WEDDTYPE.WEDDING_DRESSER);
		        else if(i % 2 == 0 ) article.setType(com.dianzishangwu.yihunli.domain.user.Merchant.WEDDTYPE.WEDDING_SHOTOS);
		        else article.setType(com.dianzishangwu.yihunli.domain.user.Merchant.WEDDTYPE.WEDDING_COMPERE);
		 
		        Resource resource = new Resource();
		        resource.setType("图片");
		        resource.setUrl("/upload/IMAGE/jjs_" + i + ".jpg");
		        article.addResource(resource);
		        
		        Resource resource1 = new Resource();
		        resource1.setType("视频");
		        resource1.setUrl("/upload/VIDEO/kks_" + i + ".jpg");
		        article.addResource(resource1);
		        
		        seri = articleService.saveArticle(article);
		  }
		  
		  assertEquals(106,seri);
		  
	}
	
	
	public void typePageTest(){
		List<Article> articles = articleService.findArticlesByType(com.dianzishangwu.yihunli.domain.user.Merchant.WEDDTYPE.WEDDING_DRESSER, 1, 20);
		assertEquals(13,articles.size());
		for(int i = 0; i  < articles.size();i++){
		   assertEquals(com.dianzishangwu.yihunli.domain.user.Merchant.WEDDTYPE.WEDDING_DRESSER,((Article)articles.get(i)).getType());
		}
	}
	
	@After
	public void after(){
		
	}
}
