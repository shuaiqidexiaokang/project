package com.lzkydh.controller;

import com.lzkydh.dto.Result;
import com.lzkydh.model.Recipe;
import com.lzkydh.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lzk on 2018/3/11 11:01
 * Description:
 */
@RestController
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    /**
     * 根据条件（标签名或发布者）查询食谱信息接口（包括user和label）
     * @param labelNames
     * @param userId
     * @return
     */
    @GetMapping("/critical")
    public Result<List<Recipe>> queryByLabelName(@RequestParam(value = "labelNames",required = false) String [] labelNames,@RequestParam(value = "userId",required = false) Integer userId){
        List<Recipe> recipe;
        if (labelNames !=null && userId == null){
            recipe = recipeService.queryByLabelNames(labelNames);
            return new Result<>(true,recipe,"查询标签成功");
        }else if(labelNames ==null && userId != null){
            recipe = recipeService.queryByUserId(userId);
            return new Result<>(true,recipe,"查询发布者成功");
        }
        return new Result<>(false,"查询失败");
    }

    /**
     * 根据食谱id查询食谱信息接口
     * @param recipeId
     * @return
     */
    @GetMapping("/{recipeId}")
    public Result<Recipe> queryByRecipeId(@PathVariable("recipeId") Integer recipeId){
        Recipe recipe = recipeService.queryByRecipeId(recipeId);
        if (recipe !=null){
            return new Result<>(true,recipe,"查询成功");
        }
        return new Result<>(false,"查询失败");
    }

    /**
     * 发布食谱接口
     * @param recipe 食谱
     * @param labelIds 标签
     * @return
     */
    @PostMapping("/add")
    public Result<Recipe> add(Recipe recipe, @RequestParam("labelIds") Integer[] labelIds){
        if (recipe != null){
            int count = recipeService.addRecipe(recipe,labelIds);
            if (count > 0){
                return new Result<>(true,recipe,"添加成功");
            }
        }
        return new Result<>(false,"添加失败");
    }
}
