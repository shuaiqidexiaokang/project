package com.lzk.mapper;

import com.lzk.model.Type;

import java.util.List;

/**
 * Created by lzk on 2018/2/10 22:05
 * Description:
 */
public interface TypeMapper {
    int addType(Type type);

    int deleteType(Integer typeId);

    int editType(Type type);

    int reduceNumber(Integer typeId);

    int increaseNumber(Integer typeId);

    Type queryById(Integer typeId);

    List<Type> queryAll();
}
