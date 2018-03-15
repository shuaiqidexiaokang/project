package com.lzkydh.service.impl;

import com.lzkydh.mapper.CollectMapper;
import com.lzkydh.mapper.CommentMapper;
import com.lzkydh.model.Collect;
import com.lzkydh.model.Comment;
import com.lzkydh.model.Recipe;
import com.lzkydh.service.CollectService;
import com.lzkydh.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lzk on 2018/3/11 14:30
 * Description:
 */
@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public int addCollectByUserIdAndRecipeId(Integer userId, Integer recipeId) {
        return collectMapper.addCollectByUserIdAndRecipeId(userId,recipeId);
    }

    @Override
    public int deleteCollectByUserIdAndRecipeId(Integer userId, Integer recipeId) {
        return collectMapper.deleteCollectByUserIdAndRecipeId(userId,recipeId);
    }

    @Override
    public List<Recipe> queryRecipeByUserId(Integer userId) {
        return collectMapper.queryRecipeByUserId(userId);
    }
}
