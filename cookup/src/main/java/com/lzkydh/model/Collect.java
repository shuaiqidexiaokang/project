package com.lzkydh.model;

/**
 * Created by lzk on 2018/3/10 19:48
 * Description:
 */
public class Collect {
    private int userId;
    private int recipeId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "userId=" + userId +
                ", recipeId=" + recipeId +
                '}';
    }
}
