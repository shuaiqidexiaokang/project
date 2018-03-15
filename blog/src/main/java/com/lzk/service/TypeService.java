package com.lzk.service;

import com.lzk.model.Type;

import java.util.List;

/**
 * Created by lzk on 2018/2/12 11:35
 * Description:
 */
public interface TypeService {

    int addType(Type type);

    int deleteType(Integer typeId);

    int editType(Type type);
    /**
     * 查询所有类型
     * @return
     */
    List<Type> queryAll();

    Type queryByTypeId(Integer typeId);
}
