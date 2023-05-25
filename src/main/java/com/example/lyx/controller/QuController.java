package com.example.lyx.controller;


import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.example.lyx.common.Result;
import com.example.lyx.entity.Qu;
import com.example.lyx.service.QuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/qu")
public class QuController {
    @Autowired
    private QuService quService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result<?> addQu(@RequestBody JSONObject body){
        Integer level = Integer.parseInt(body.get("level").toString());
        String content = body.get("content").toString();
        Qu qu = new Qu();
        qu.setLevel(level);
        qu.setContent(content);
        quService.addQu(qu);
        return Result.success();
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result<?> deleteQu(@RequestParam Integer id){
        quService.deleteById(id);
        return Result.success();
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result<?> updateQu(@RequestBody Qu qu){
        quService.updateQu(qu);
        return Result.success();
    }

//    分页
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public Result<?> findPage(@RequestParam int pageNum,
                              @RequestParam int pageSize,
                              @RequestParam String search){
        PageHelper.startPage(pageNum,pageSize);
        List<Qu> quList;
        if (StrUtil.isNotBlank(search)){
            quList = quService.getNickName(search);
        }else{
            quList = quService.getAllQu();
        }
        PageInfo info = new PageInfo(quList);
        return Result.success(info);
    }
}
