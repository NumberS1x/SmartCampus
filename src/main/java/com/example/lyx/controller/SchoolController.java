package com.example.lyx.controller;


import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.example.lyx.common.Result;
import com.example.lyx.entity.School;
import com.example.lyx.mapper.SchoolMapper;
import com.example.lyx.service.SchoolService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

//学校分页
    @RequestMapping(value ="/findPage",method = RequestMethod.GET)
    public Result<?> findPage(@RequestParam int pageNum,
                              @RequestParam int pageSize,
                              @RequestParam String search){
        PageHelper.startPage(pageNum,pageSize);
        List<School> schools;
        if (StrUtil.isNotBlank(search)){
            schools = schoolService.getNickName(search);
        }else {
            schools = schoolService.getAllSchool();
        }
        PageInfo pageInfo = new PageInfo(schools);
        return Result.success(pageInfo);
    }




}
