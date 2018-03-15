package com.lzkydh.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeLabelMapperTest {

    @Autowired
    private RecipeLabelMapper recipeLabelMapper;
    @Test
    public void addRecipeLabelByBatch() throws Exception {
        Integer[] array = {10,50,30};
        int count = recipeLabelMapper.addRecipeLabelByBatch(array,1003);
        System.out.println("count:" + count);
    }

    @Test
    public void deleteRecipeLabelByRecipeId() throws Exception {
        int count = recipeLabelMapper.deleteRecipeLabelByRecipeId(1003);
        System.out.println(count);
    }

}