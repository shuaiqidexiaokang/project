package com.lzkydh.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecipeLabelMapper {

    public int addRecipeLabelByBatch(@Param("labelIds") Integer[] labelIds,@Param("recipeId") Integer recipeId);

    public int deleteRecipeLabelByRecipeId(Integer recipeId);
}
