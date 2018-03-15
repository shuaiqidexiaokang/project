package com.lzkydh.mapper;

import com.lzkydh.model.Collect;
import com.lzkydh.model.Recipe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectMapperTest {
    @Autowired
    private CollectMapper collectMapper;

    @Test
    public void addCollectByUserIdAndRecipeId() throws Exception {
        int count = collectMapper.addCollectByUserIdAndRecipeId(1000,1000);
        System.out.println(count);
    }

    @Test
    public void deleteCollectByUserIdAndRecipeId() throws Exception {
        int count = collectMapper.deleteCollectByUserIdAndRecipeId(1000,1000);
        System.out.println(count);
    }

    @Test
    public void queryRecipeByUserId() throws Exception {
        List<Recipe> recipes = collectMapper.queryRecipeByUserId(100000);
        recipes.forEach(System.out::println);
    }



}