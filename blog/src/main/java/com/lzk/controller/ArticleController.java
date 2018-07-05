package com.lzk.controller;

import com.lzk.dto.PageBean;
import com.lzk.dto.Result;
import com.lzk.model.Article;
import com.lzk.model.CreateTimeCount;
import com.lzk.model.Type;
import com.lzk.service.ArticleService;
import com.lzk.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lzk on 2018/2/11 15:44
 * Description:
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private final int pageSize = 5;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String list(@RequestParam(name = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                       @RequestParam(name = "typeId", required = false) Integer typeId,
                       @RequestParam(name = "createTime", required = false) String createTime, Model model) {
        int total;
        List<Article> articles;
        if(typeId != null && !typeId.equals("")){
            total = articleService.queryCountByTypeId(typeId);
            articles = articleService.queryArticlesByTypeId(typeId, (pageNo - 1) * pageSize, pageSize);
            model.addAttribute("typeId", typeId);
        }else if(createTime!=null&& !createTime.equals("")){
            total = articleService.queryCountByCreateTime(createTime);
            articles = articleService.queryArticlesByCreateTime(createTime, (pageNo - 1) * pageSize, pageSize);
            model.addAttribute("createTime", createTime);
        }else{
            total = articleService.queryCount();
            articles = articleService.queryArticles((pageNo - 1) * pageSize, pageSize);
        }
        PageBean page = new PageBean(pageNo, pageSize, total);
        List<Article> hotBlog = articleService.queryHotArticles();
        List<Article> newBlog = articleService.queryNewArticles();
        List<Type> types = typeService.queryAll();
        List<CreateTimeCount> dates = articleService.queryDates();
        model.addAttribute("articles", articles);
        model.addAttribute("page", page);
        model.addAttribute("hotBlog", hotBlog);
        model.addAttribute("newBlog", newBlog);
        model.addAttribute("types", types);
        model.addAttribute("dates", dates);
        return "visitor/index";
    }

    /**
     * 游客查看文章的同时阅读数加++
     * @param blogId
     * @param model
     * @return
     */
    @RequestMapping(value = "/{blogId}/details", method = RequestMethod.GET)
    public String details(@PathVariable("blogId") Integer blogId, Model model) {
        //查询的文章
        Article article = articleService.readArticle(blogId);
        //查询的上一篇文章
        Article preArticle = articleService.preArticleById(blogId);
        //查询的下一篇文章
        Article nextArticle = articleService.nextArticleById(blogId);
        //查询的热门文章
        List<Article> hotBlog = articleService.queryHotArticles();
        //查询的最新文章
        List<Article> newBlog = articleService.queryNewArticles();
        //文章类别归档
        List<Type> types = typeService.queryAll();
        //文章日期归档
        List<CreateTimeCount> dates = articleService.queryDates();
        model.addAttribute("article", article);
        model.addAttribute("preArticle", preArticle);
        model.addAttribute("nextArticle", nextArticle);
        model.addAttribute("hotBlog", hotBlog);
        model.addAttribute("newBlog", newBlog);
        model.addAttribute("types", types);
        model.addAttribute("dates", dates);
        return "visitor/details";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String articleList(Model model) {
        int count = articleService.queryCount();
        List<Article> articles = articleService.queryArticles(0,count);
        if (articles !=null){
            model.addAttribute("articles",articles);
            model.addAttribute("count",count);
            return "article/articlelist";
        }
        model.addAttribute("msg","出错");
        return "error";
    }

    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public String addArticle(Article article, Model model) {
        int count = articleService.addArticle(article);
        if (count > 0){
            return "redirect:/article/list";
        }
        model.addAttribute("msg","添加文章错误");
        return "error";
    }

    @RequestMapping(value = "/deleteArticle", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result deleteArticle(Integer articleId) {
        int count = articleService.deleteArticleById(articleId);
        if (count > 0){
            return new Result(true,"删除成功");
        }
        return new Result(false,"删除失败");
    }

    //显示修改的文章信息
    @RequestMapping(value = "/editArticle/{articleId}", method = RequestMethod.GET)
    public String editArticle(@PathVariable("articleId") Integer articleId, Model model) {
        Article article = articleService.queryById(articleId);
        if (article !=null){
            model.addAttribute("article",article);
            return "article/updateArticle";
        }
        model.addAttribute("msg","未查找到该文章");
        return "error";
    }

    //修改的文章信息
    @RequestMapping(value = "/updateArticle", method = RequestMethod.POST)
    public String updateArticle(Article article,@RequestParam("oldTypeId") Integer oldTypeId, Model model) {
        System.out.println(article);
        int result = articleService.updateArticle(article,oldTypeId);
        if (result > 0 ){
            return "redirect:/article/list";
        }
        model.addAttribute("msg","修改文章失败");
        return "error";
    }

    //根据条件查询文章
    @RequestMapping(value = "/seachArticle", method = RequestMethod.GET)
    public String seachArticle(String key, Model model) {
        List<Article> articles = articleService.searchArticle(key);
        int count = articles.size();
        if (articles!=null){
            model.addAttribute("articles",articles);
            model.addAttribute("count",count);
            return "article/articlelist";
        }
        model.addAttribute("msg","出错");
        return "error";
    }
}
