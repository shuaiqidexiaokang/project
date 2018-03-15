package com.lzkydh.mapper;

import com.lzkydh.model.Label;
import com.lzkydh.model.Recipe;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LabelMapper {

    public int addLabel(String labelName);

    public int deleteLabelByLabelId(Integer labelId);

    /**
     * 根据查询次数降序排序，偏移量查询标签
     * @param offset
     * @param limit
     * @return
     */
    public List<Label> queryLabelByLimit(@Param("offset") int offset, @Param("limit") int limit);

    public int increaseSearchTimesByLabelNames(String[] labelNames);
}
