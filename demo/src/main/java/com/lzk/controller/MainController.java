package com.lzk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lzk
 * @create 2018-08-20 22:48
 * Description: html映射
 */
@Controller
public class MainController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
