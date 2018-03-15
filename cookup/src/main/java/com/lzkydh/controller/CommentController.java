package com.lzkydh.controller;

import com.lzkydh.dto.Result;
import com.lzkydh.model.Comment;
import com.lzkydh.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lzk on 2018/3/11 14:20
 * Description:
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public Result addComment(Comment comment){
        int count = commentService.addComment(comment);
        if (count > 0){
            return new Result(true,"添加评论成功");
        }
        return new Result(false,"添加评论失败");
    }

    @PostMapping("/delete")
    public Result deleteCommentByUserIdAndRecipeId(@RequestParam("userId") Integer userId,@RequestParam("recipeId") Integer recipeId){
        int count = commentService.deleteCommentByUserIdAndRecipeId(userId, recipeId);
        if (count > 0){
            return new Result(true,"删除评论成功");
        }
        return new Result(false,"删除评论失败");
    }

    /**
     * 根据食谱id 查询该食谱所有评论
     * @param recipeId 食谱id
     * @return
     */
    @GetMapping("/recipe/{recipeId}")
    public Result<List<Comment>> queryCommentByRecipeId(@PathVariable("recipeId") Integer recipeId){
        List<Comment> comments = commentService.queryByRecipeIdWithUser(recipeId);
        if (comments !=null && !comments.isEmpty()){
            return new Result<>(true,commentService.queryByRecipeIdWithUser(recipeId),"该食谱评论信息查询成功");
        }
        return new Result<>(true,"该食谱无评论信息");
    }

    /**
     * 根据评论用户id查询对应评论信息接口
     * @param userId 评论用户id
     * @return
     */
    @GetMapping("/user/{userId}")
    public Result<List<Comment>> queryCommentByUserId(@PathVariable("userId") Integer userId){
        List<Comment> comments = commentService.queryByUserIdWithRecipe(userId);
        if (comments !=null && !comments.isEmpty()){
            return new Result<>(true,comments,"该用户评论信息查询成功");
        }
        return new Result<>(true,"该用户无评论信息");
    }
}
