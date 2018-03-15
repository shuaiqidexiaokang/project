package com.lzkydh.service;

import com.lzkydh.model.Collect;
import com.lzkydh.model.Comment;
import com.lzkydh.model.Recipe;

import java.util.List;

public interface CollectService {
    //根据用户id 和食谱id 添加收藏
    public int addCollectByUserIdAndRecipeId(Integer userId,Integer recipeId);

    //根据用户id 和食谱id 删除收藏
    public int deleteCollectByUserIdAndRecipeId(Integer userId,Integer recipeId);

    //根据用户id 查询所有收藏食谱
    public List<Recipe> queryRecipeByUserId(Integer userId);
}
