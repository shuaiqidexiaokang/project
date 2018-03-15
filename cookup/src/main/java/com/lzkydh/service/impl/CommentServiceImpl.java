package com.lzkydh.service.impl;

import com.lzkydh.mapper.CommentMapper;
import com.lzkydh.model.Comment;
import com.lzkydh.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lzk on 2018/3/11 14:30
 * Description:
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

    @Override
    public int deleteCommentByUserIdAndRecipeId(Integer userId, Integer recipeId) {
        return commentMapper.deleteCommentByUserIdAndRecipeId(userId, recipeId);
    }

    @Override
    public List<Comment> queryByRecipeIdWithUser(Integer recipeId) {
        return commentMapper.queryByRecipeIdWithUser(recipeId);
    }

    @Override
    public List<Comment> queryByUserIdWithRecipe(Integer userId) {
        return commentMapper.queryByUserIdWithRecipe(userId);
    }
}
