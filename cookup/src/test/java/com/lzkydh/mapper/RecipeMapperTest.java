package com.lzkydh.mapper;

import com.lzkydh.model.Recipe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeMapperTest {
    @Autowired
    private RecipeMapper recipeMapper;

    @Test
    public void addRecipe() throws Exception {
// (int userId, String recipeName, String picUrl, String material, String profile) {
        Recipe recipe = new Recipe(11,"菊花茶","1111","2222","111");
        int count = recipeMapper.addRecipe(recipe);
        System.out.println(recipe);
    }

    @Test
    public void deleteRecipeByRecipeId() throws Exception {
        int count = recipeMapper.deleteRecipeByRecipeId(1004);
        System.out.println(count);
    }

    @Test
    public void updateRecipe() throws Exception {
        Recipe recipe = new Recipe(22,"菊花茶11","222","2222","111");
        recipe.setRecipeId(1005);
        int count = recipeMapper.updateRecipe(recipe);
        System.out.println(count);
    }

    @Test
    public void queryByRecipeId() throws Exception {
        Recipe recipe = recipeMapper.queryByRecipeId(1000);
        System.out.println(recipe);
    }

    @Test
    public void queryByUserId() throws Exception {
        List<Recipe> recipes = recipeMapper.queryByUserId(1000);
        recipes.forEach(System.out::println);
    }

    @Test
    public void queryByLabelName() throws Exception {
        String [] labelNames = {"鲁菜","鲜辣"};
        List<Recipe> recipes = recipeMapper.queryByLabelName(labelNames);
        recipes.forEach(System.out::println);
    }

}