package com.lzkydh.model;

import java.util.List;

/**
 * Created by lzk on 2018/3/10 19:47
 * Description:
 */
public class Recipe {
    private int recipeId;
    private int userId;
    private String recipeName;
    private String picUrl;
    private String material;
    private String profile;
    private User user;
    private List<Label> labels;

    public Recipe() {
    }

    public Recipe(int userId, String recipeName, String picUrl, String material, String profile) {
        this.userId = userId;
        this.recipeName = recipeName;
        this.picUrl = picUrl;
        this.material = material;
        this.profile = profile;
    }

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

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", userId=" + userId +
                ", recipeName='" + recipeName + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", material='" + material + '\'' +
                ", profile='" + profile + '\'' +
                ", user=" + user +
                ", labels=" + labels +
                '}';
    }
}
