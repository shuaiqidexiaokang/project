package com.lzkydh.service;

import com.lzkydh.model.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {
    //添加评论
    public int addComment(Comment comment);

    //根据用户id 和食谱id 删除评论
    public int deleteCommentByUserIdAndRecipeId(Integer userId,Integer recipeId);

    //根据食谱id 查询该食谱所有评论
    public List<Comment> queryByRecipeIdWithUser(Integer recipeId);

    //根据评论用户id 查询该用户所有的评论
    public List<Comment> queryByUserIdWithRecipe(Integer userId);
}
