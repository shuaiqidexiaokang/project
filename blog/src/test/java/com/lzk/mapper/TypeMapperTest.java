package com.lzk.mapper;

import com.lzk.model.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mapper.xml"})
public class TypeMapperTest {
    @Autowired
    TypeMapper typeMapper;

    @Test
    public void addType() throws Exception {
        Type type = new Type();
        type.setTypeName("aa");
        int result = typeMapper.addType(type);
        System.out.println(result);
    }
    @Test
    public void deleteType() throws Exception {
        int result = typeMapper.deleteType(11);
        System.out.println(result);
    }
    @Test
    public void editType() throws Exception {
        Type type = typeMapper.queryById(26);
        type.setNumber(12);
        int result = typeMapper.editType(type);
        System.out.println(result);
    }

    @Test
    public void queryAll() throws Exception {
        List<Type> types = typeMapper.queryAll();
        types.forEach(System.out::println);
    }

}