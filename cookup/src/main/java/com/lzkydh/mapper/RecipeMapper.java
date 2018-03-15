package com.lzkydh.mapper;

import com.lzkydh.model.Recipe;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecipeMapper {
    public int addRecipe(Recipe recipe);

    public int deleteRecipeByRecipeId(Integer recipeId);

    public int updateRecipe(Recipe recipe);

    /**
     * 根据食谱id查询食谱信息（包括发布者的名字和标签）
     * @param recipeId
     * @return
     */
    public Recipe queryByRecipeId(Integer recipeId);

    /**
     * 根据用户id查询食谱信息（包括发布者的名字和标签）
     * @param userId
     * @return
     */
    public List<Recipe> queryByUserId(Integer userId);

    /**
     * 根据标签名数组查询食谱
     * @param labelNames
     * @return
     */
    public List<Recipe> queryByLabelName(@Param("labelNames") String[] labelNames);
}
