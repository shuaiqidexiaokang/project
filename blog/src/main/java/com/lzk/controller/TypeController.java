package com.lzk.controller;

import com.lzk.dto.Result;
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
 * Created by lzk on 2018/3/2 13:43
 * Description:
 */
@Controller
@RequestMapping("/type")
public class TypeController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String queryAllType(Model model){
        List<Type> types = typeService.queryAll();
        model.addAttribute("types",types);
        return "type/typelist";
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<List<Type>> findAll(Model model){
        List<Type> types = typeService.queryAll();
        if (types !=null){
            return new Result<>(true,types,"查询成功");
        }
        return new Result<>(false,"查询失败");
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result addType(Type type){
        int result = typeService.addType(type);
        if (result > 0){
            return new Result(true,"添加成功");
        }
        return new Result(false,"添加失败");
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result delete(@RequestParam("typeId") Integer typeId){
        int result = typeService.deleteType(typeId);
        if (result >0){
            return new Result(true,"删除成功");
        }
        return new Result(false,"删除失败");
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result edit(Type type){
        System.out.println(type);
        int result = typeService.editType(type);
        if (result >0){
            return new Result(true,"修改成功");
        }
        return new Result(false,"修改失败");
    }
}
