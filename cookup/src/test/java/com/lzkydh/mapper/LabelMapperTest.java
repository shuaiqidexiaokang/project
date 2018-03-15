package com.lzkydh.mapper;

import com.lzkydh.model.Label;
import com.lzkydh.model.Recipe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LabelMapperTest {
    @Autowired
    private LabelMapper labelMapper;
    @Test
    public void addLabel() throws Exception {
        int count = labelMapper.addLabel("AA");
        System.out.println(count);
    }

    @Test
    public void deleteLabelByLabelId() throws Exception {
        int count = labelMapper.deleteLabelByLabelId(271);
        System.out.println(count);
    }

    @Test
    public void queryLabelByLimit() throws Exception {
        List<Label> labels = labelMapper.queryLabelByLimit(10,5);
        labels.forEach(System.out::println);
    }

    @Test
    public void increaseSearchTimesByLabelName() throws Exception {
    }

}