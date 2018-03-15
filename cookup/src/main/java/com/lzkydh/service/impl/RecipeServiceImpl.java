package com.lzkydh.service.impl;

import com.lzkydh.mapper.LabelMapper;
import com.lzkydh.mapper.RecipeLabelMapper;
import com.lzkydh.mapper.RecipeMapper;
import com.lzkydh.model.Label;
import com.lzkydh.model.Recipe;
import com.lzkydh.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzk on 2018/3/11 11:00
 * Description:
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeMapper recipeMapper;

    @Autowired
    private RecipeLabelMapper recipeLabelMapper;

    @Autowired
    private LabelMapper labelMapper;

    @Override
    @Transactional
    public int addRecipe(Recipe recipe, Integer[] labels) {
        int addrCount = recipeMapper.addRecipe(recipe);
        if (addrCount>0){
            int addrlCount = recipeLabelMapper.addRecipeLabelByBatch(labels,recipe.getRecipeId());
            if (addrlCount > 0){
                return 1;
            }
        }
        return 0;
    }

    @Override
    @Transactional
    public int deleteRecipeByRecipeId(Integer recipeId) {
        int deleteRL = recipeLabelMapper.deleteRecipeLabelByRecipeId(recipeId);
        if (deleteRL > 0){
            int deleteR = recipeMapper.deleteRecipeByRecipeId(recipeId);
            if (deleteR > 0){
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int updateRecipe(Recipe recipe) {
        return recipeMapper.updateRecipe(recipe);
    }

    @Override
    public Recipe queryByRecipeId(Integer recipeId) {
        return recipeMapper.queryByRecipeId(recipeId);
    }

    @Override
    public List<Recipe> queryByUserId(Integer userId) {
        return recipeMapper.queryByUserId(userId);
    }

    @Override
    public List<Recipe> queryByLabelNames(String[] labelNames) {
        labelMapper.increaseSearchTimesByLabelNames(labelNames);
        return recipeMapper.queryByLabelName(labelNames);
    }
}
