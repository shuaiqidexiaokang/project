package com.lzkydh.service.impl;

import com.lzkydh.mapper.LabelMapper;
import com.lzkydh.model.Label;
import com.lzkydh.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lzk on 2018/3/11 10:11
 * Description:
 */
@Service
public class LabelServiceImpl implements LabelService{

    @Autowired
    private LabelMapper labelMapper;

    @Override
    public List<Label> queryLabelByLimit(int offset, int limit) {
        return labelMapper.queryLabelByLimit(offset,limit);
    }
}
