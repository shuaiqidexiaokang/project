package com.lzkydh.service;

import com.lzkydh.model.Recipe;

import java.util.List;

public interface RecipeService {
    /**
     * 发布食谱
     * @param recipe
     * @param labels
     * @return
     */
    public int addRecipe(Recipe recipe,Integer[] labels);

    /**
     * 根据食谱id删除食谱
     * @param recipeId
     * @return
     */
    public int deleteRecipeByRecipeId(Integer recipeId);

    public int updateRecipe(Recipe recipe);

    /**
     * 根据食谱id查询食谱信息（包含user，label）
     * @param recipeId
     * @return
     */
    public Recipe queryByRecipeId(Integer recipeId);

    /**
     * 根据发布者id查询食谱信息
     * @param userId
     * @return
     */
    public List<Recipe> queryByUserId(Integer userId);

    /**
     * 根据标签名查询食谱信息
     * @param labelName
     * @return
     */
    public List<Recipe> queryByLabelNames(String[] labelName);
}
