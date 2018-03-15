package com.lzk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    //转发login页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
       return "admin/login";
    }

    //转发login1页面
    @RequestMapping(value = "/login1", method = RequestMethod.GET)
    public String login1(HttpServletRequest request) {
       return "admin/login1";
    }

    //转发到添加文章的页面
    @RequestMapping(value = "/addArticle", method = RequestMethod.GET)
    public String addArticle() {
       return "article/addArticle";
    }

    //转发出错页面
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error() {
       return "error";
    }
}
