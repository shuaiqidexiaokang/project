package com.lzkydh.controller;

import com.lzkydh.dto.Result;
import com.lzkydh.model.Collect;
import com.lzkydh.model.Comment;
import com.lzkydh.model.Recipe;
import com.lzkydh.service.CollectService;
import com.lzkydh.service.CommentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lzk on 2018/3/11 14:20
 * Description:
 */
@RestController
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;

    /**
     * 根据用户id 和食谱id 添加收藏
     * @param userId
     * @param reciperId
     * @return
     */
    @PostMapping("/add")
    public Result addCollect(@RequestParam("userId") Integer userId, @RequestParam("recipeId") Integer reciperId){
        int count = collectService.addCollectByUserIdAndRecipeId(userId, reciperId);
        if (count > 0){
            return new Result(true,"添加收藏成功");
        }
            return new Result(false,"添加收藏失败");
    }

    /**
     *根据用户id 和食谱id 删除收藏
     * @param userId
     * @param reciperId
     * @return
     */
    @PostMapping("/delete")
    public Result deleteCollect(@RequestParam("userId") Integer userId, @RequestParam("recipeId") Integer reciperId){
        int count = collectService.deleteCollectByUserIdAndRecipeId(userId, reciperId);
        if (count > 0){
            return new Result(true,"删除收藏成功");
        }
            return new Result(false,"删除收藏失败");
    }

    /**
     * 根据用户id 查询所有收藏信息
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public Result<List<Recipe>> queryByUserId(@PathVariable("userId") Integer userId){
        List<Recipe> recipes = collectService.queryRecipeByUserId(userId);
        if (recipes !=null && !recipes.isEmpty()){
            return new Result<>(true,recipes,"查询用户id为" + userId+ "的收藏信息成功");
        }
        return new Result<>(false,"无用户id为" + userId+ "的收藏信息");
    }
}
