package com.lzkydh.model;

/**
 * Created by lzk on 2018/3/10 19:47
 * Description:
 */
public class Step {
    private int stepId;
    private int recipeId;
    private int stepIndex;
    private String stepContent;

    public int getStepId() {
        return stepId;
    }

    public void setStepId(int stepId) {
        this.stepId = stepId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getStepIndex() {
        return stepIndex;
    }

    public void setStepIndex(int stepIndex) {
        this.stepIndex = stepIndex;
    }

    public String getStepContent() {
        return stepContent;
    }

    public void setStepContent(String stepContent) {
        this.stepContent = stepContent;
    }

    @Override
    public String toString() {
        return "Step{" +
                "stepId=" + stepId +
                ", recipeId=" + recipeId +
                ", stepIndex=" + stepIndex +
                ", stepContent='" + stepContent + '\'' +
                '}';
    }
}
