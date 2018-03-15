package com.lzkydh.model;

/**
 * Created by lzk on 2018/3/10 19:48
 * Description:
 */
public class RecipeLabel {
    private int labelId;
    private int recipeId;
    private String labelName;

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    @Override
    public String toString() {
        return "RecipeLabel{" +
                "labelId=" + labelId +
                ", recipeId=" + recipeId +
                ", labelName='" + labelName + '\'' +
                '}';
    }
}
