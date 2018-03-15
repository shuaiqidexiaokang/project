package com.lzkydh.service;

import com.lzkydh.model.Label;

import java.util.List;

/**
 * Created by lzk on 2018/3/11 10:10
 * Description:
 */
public interface LabelService {
    /**
     * 降序查询指定偏移量Label
     * @param offset
     * @param limit
     * @return
     */
    public List<Label> queryLabelByLimit(int offset,int limit);

}
