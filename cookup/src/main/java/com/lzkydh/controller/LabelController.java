package com.lzkydh.controller;

import com.lzkydh.dto.Result;
import com.lzkydh.model.Label;
import com.lzkydh.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lzk on 2018/3/11 10:12
 * Description:
 */
@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;

    /**
     * 查询搜索次数前三的标签接口
     * @return
     */
    @GetMapping("/hot")
    public Result<List<Label>> queryHotLabel(){
        List<Label> labels = labelService.queryLabelByLimit(0,3);
        if (labels !=null){
            return new Result<>(true,labels,"查询成功");
        }
        return new Result<>(false,"查询失败");
    }
}
