package com.lzk.service;

import com.lzk.model.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class TypeServiceTest {
    @Autowired
    private TypeService typeService;
    @Test
    public void queryAll() throws Exception {
        List<Type> types = typeService.queryAll();
        types.forEach(System.out::println);


    }

}