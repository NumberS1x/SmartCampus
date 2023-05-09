package com.example.lyx.controller;


import com.example.lyx.common.Result;
import com.example.lyx.entity.Teacher;
import com.example.lyx.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
//    登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result<?> login(@RequestParam Integer teacherNumber,
                           @RequestParam String teacherPass){
        Teacher res = teacherService.getAccount(teacherNumber,teacherPass);
        if (res == null){
            return Result.error("-1","用户名或者密码错误！");
        }else{
            return Result.success(res);
        }
    }

//    注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Result<?> addTeacher(@RequestBody Teacher teacher){
        Teacher res = teacherService.findById(teacher.getTeacherNumber());
        if (res != null){
            return Result.error("-1","已经存在该用户！");
        }else{
            teacherService.addTeacher(teacher);
            return Result.success();
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result<?> update(@RequestBody Teacher teacher){
        if(teacher.getTeacherPass() == null){
            String pass = teacherService.findById(teacher.getTeacherNumber()).getTeacherPass();
            Teacher teacherNew = teacher;
            teacherNew.setTeacherPass(pass);
            teacherService.upDate(teacherNew);
        }else{
            teacherService.upDate(teacher);
        }
        return Result.success();
    }
}
