package com.lzkydh.mapper;

import com.lzkydh.model.Collect;
import com.lzkydh.model.Recipe;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper {

    //根据用户id 和食谱id 添加收藏
    public int addCollectByUserIdAndRecipeId(@Param("userId") Integer userId, @Param("recipeId")Integer recipeId);

    //根据用户id 和食谱id 删除收藏
    public int deleteCollectByUserIdAndRecipeId(@Param("userId")Integer userId,@Param("recipeId")Integer recipeId);

    //根据用户id 查询所有收藏食谱
    public List<Recipe> queryRecipeByUserId(Integer userId);
}
