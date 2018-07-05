package com.lzk.service.impl;

import com.lzk.mapper.ArticleMapper;
import com.lzk.mapper.TypeMapper;
import com.lzk.model.Article;
import com.lzk.model.CreateTimeCount;
import com.lzk.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/*
 *
 * Created by lzk on 2018/2/11 17:36
 * Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private TypeMapper typeMapper;

    @Override
    @Transactional
    public int addArticle(Article article) {
        int increaseCount = typeMapper.increaseNumber(article.getTypeId());
        if (increaseCount > 0){
            int addCount = articleMapper.addArticle(article);
            if (addCount >0){
                return 1;
            }
        }
        return 0;
    }

    @Override
    @Transactional
    public int deleteArticleById(Integer articleId) {
        Article article = articleMapper.queryById(articleId);
        System.out.println(article);
        int reduceCount = typeMapper.reduceNumber(article.getTypeId());
        if (reduceCount > 0){
            int deleteCount = articleMapper.deleteArticle(articleId);
            if (deleteCount >0){
                return 1;
            }
        }
        return 0;
    }

    //修改文章的同时需要修改类型的数量
    @Override
    @Transactional
    public int updateArticle(Article article, Integer oldTypeId) {
        int newTypeId = article.getTypeId();
        if (newTypeId != oldTypeId){
            typeMapper.reduceNumber(oldTypeId);
            typeMapper.increaseNumber(newTypeId);
        }
        return articleMapper.updateArticle(article);
    }

    @Override
    public List<Article> queryArticles(int pageNo,int size) {
        return articleMapper.queryAllSortByTime(pageNo,size);
    }

    @Override
    public int queryCount(){
        return articleMapper.queryCountByTypeIdOrCreate(null,null);
    }

    @Override
    public int queryCountByTypeId(Integer typeId) {
        return articleMapper.queryCountByTypeIdOrCreate(typeId,null);
    }

    @Override
    public int queryCountByCreateTime(String createTime) {
        return articleMapper.queryCountByTypeIdOrCreate(null,createTime);
    }

    @Override
    public Article queryById(int articleId) {
        return articleMapper.queryById(articleId);
    }

    @Override
    public List<Article> queryHotArticles() {
        return articleMapper.queryAllSortByReadNumber(0,5);
    }

    @Override
    public List<Article> queryNewArticles() {
        return articleMapper.queryAllSortByTime(0,5);
    }

    @Override
    public List<Article> queryArticlesByTypeId(int typeId, int pageNo, int size) {
        return articleMapper.queryAllByTypeIdOrCreateTimeSortByTime(typeId, null,pageNo, size);
    }

    @Override
    public List<Article> queryArticlesByCreateTime(String createTime, int pageNo, int size) {
        return articleMapper.queryAllByTypeIdOrCreateTimeSortByTime(null, createTime,pageNo, size);
    }

    @Override
    public List<CreateTimeCount> queryDates() {
        return articleMapper.queryDate();
    }

    @Override
    public Article preArticleById(Integer articleId) {
        return articleMapper.preArticleById(articleId);
    }

    @Override
    public Article nextArticleById(Integer articleId) {
        return articleMapper.nextArticleById(articleId);
    }

    @Override
    public List<Article> searchArticle(String key) {
        return articleMapper.searchArticle(key);
    }

    @Override
    @Transactional
    public Article readArticle(Integer articleId) {
        int result = articleMapper.increaseReadNumber(articleId);
        if (result > 0){
            return articleMapper.queryById(articleId);
        }
        return null;
    }
}
