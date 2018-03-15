package com.lzk.service;

import com.lzk.model.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void addArticle() throws Exception {
        Article article = new Article("测试",9,"abc","aaa","aaaa");
        int count = articleService.addArticle(article);
        System.out.println(count);
    }

    @Test
    public void deleteArticleById() throws Exception {
        int count = articleService.deleteArticleById(1017);
        System.out.println(count);
    }

}