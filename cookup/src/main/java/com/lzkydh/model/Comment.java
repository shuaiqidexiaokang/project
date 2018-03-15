package com.lzkydh.model;

import java.util.List;

/**
 * Created by lzk on 2018/3/10 19:48
 * Description:
 */
public class Comment {
    private int commentId;
    private int recipeId;
    private int userId;
    private int score;
    private String content;
    private User user;
    private Recipe recipe;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Comment() {
    }

    public Comment(int recipeId, int userId, int score, String content) {
        this.recipeId = recipeId;
        this.userId = userId;
        this.score = score;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", recipeId=" + recipeId +
                ", userId=" + userId +
                ", score=" + score +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", recipe=" + recipe +
                '}';
    }
}
