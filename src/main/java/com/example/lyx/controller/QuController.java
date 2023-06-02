package com.example.lyx.controller;


import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.example.lyx.common.Result;
import com.example.lyx.entity.Qu;
import com.example.lyx.entity.QuAnswer;
import com.example.lyx.service.QuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/qu")
public class QuController {
    @Autowired
    private QuService quService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result<?> addQu(@RequestBody JSONObject body){
        //传过来问题的一些详细的数据,列入问题的题目，答案，等级等等，和题库的数据（因为是在题库中创建题目的)
        String quContent =body.get("quContent").toString();
        //处理前端传来的answers数组
        JSONArray answers = body.getJSONArray("answers");
        Integer repoId = Integer.parseInt(body.get("repoId").toString());
        Integer level = Integer.parseInt(body.get("level").toString());
        Qu qu = new Qu();
        qu.setContent(quContent);
        qu.setLevel(level);
        quService.addQu(qu,answers,repoId);
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
