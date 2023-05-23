package com.example.lyx.controller;


import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.example.lyx.common.Result;
import com.example.lyx.entity.MyClass;
import com.example.lyx.entity.Student;
import com.example.lyx.service.MyClassService;
import com.example.lyx.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/myClass")
public class MyClassController {

    @Autowired
    private MyClassService myClassService;

    @Autowired
    private StudentService studentService;
//创建一个班级
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result<?> addClass(@RequestBody JSONObject body){
        if (myClassService.queryByName(body.get("className").toString())!=null){
            return Result.error("-1","班级名字已存在！");
        }
        MyClass myClass = new MyClass();
        Integer classId = new Random().nextInt(99999999);
        while (myClassService.queryById(classId) != null){
            classId = new Random().nextInt(99999999);
        }
        myClass.setClassId(classId);
        myClass.setClassName(body.get("className").toString());
        myClass.setSchoolName(body.get("schoolName").toString());
        myClass.setClassSys(body.get("classSys").toString());
        myClass.setClassStudentAmount(0);
        myClass.setClassTeacherAmount(0);
        myClassService.addMyClass(myClass);
        return Result.success(myClassService.queryById(classId));
    }
//班级分页
    @RequestMapping(value = "/findPage",method = RequestMethod.GET)
    public Result<?> findPage(@RequestParam Integer pageNum,
                              @RequestParam Integer pageSize,
                              @RequestParam String search,
                              @RequestParam String schoolName){
        List<MyClass> myClasses;
        PageHelper.startPage(pageNum,pageSize);
        if (StrUtil.isNotBlank(search)){
            myClasses = myClassService.getNickName(search,schoolName);
        }else{
            myClasses = myClassService.getAllClass(schoolName);
        }
        PageInfo pageInfo = new PageInfo(myClasses);
        return Result.success(pageInfo);
    }

//    获取我的班级
    @RequestMapping(value = "/MyClass",method = RequestMethod.POST)
    public Result<?> getMyClass(@RequestBody JSONObject body){
        Integer studentId = Integer.parseInt(body.get("studentId").toString());
        Student res = studentService.findById(studentId);
        String className = res.getStudentClass();
        String schoolName = res.getSchoolName();
        if (className == null){
            return Result.error("-1","您还未加入班级！");
        }
        return Result.success(myClassService.queryBySchoolName(className,schoolName));
    }





}
