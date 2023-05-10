package com.example.lyx.controller;


import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.example.lyx.common.Result;
import com.example.lyx.config.LoginConfig;
import com.example.lyx.entity.School;
import com.example.lyx.entity.Student;
import com.example.lyx.mapper.StudentMapper;
import com.example.lyx.service.SchoolService;
import com.example.lyx.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private SchoolService schoolService;



//    登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result<?> login(@RequestParam Integer studentId,
                           @RequestParam String studentPass){
        Student res = studentService.getAccount(studentId, studentPass);
        if (res == null){
            return Result.error("-1","用户名或者密码输入错误！");
        }else{
            HashMap<String,Object> map = new HashMap<>();
            String token = LoginConfig.addToken(studentId, studentPass);
            map.put("token",token);
            return Result.success(map);
        }
    }
//    学生注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Result<?> add(@RequestBody JSONObject body){
        Integer studentId = Integer.parseInt(body.get("studentId").toString());
        Student res = studentService.findById(studentId);
        if (res!=null){
            return Result.error("-1","注册失败，已经存在该用户！");
        }else{
            Student student = new Student();
            student.setStudentId(studentId);
            student.setStudentPass(body.get("studentPass").toString());
            student.setStudentName(body.get("studentName").toString());
            student.setStudentClass(body.get("studentClass").toString());
            student.setStudentSex(body.get("studentSex").toString());
            student.setStudentBoss(body.get("studentBoss").toString());
            student.setSchoolName(body.get("schoolName").toString());
            studentService.addStudent(student);
            return Result.success();
        }
    }

//    更新
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result<?> update(@RequestBody Student student){
        if(student.getStudentPass() == null){
            String pass = studentService.findById(student.getStudentId()).getStudentPass();
            Student studentNew = student;
            studentNew.setStudentPass(pass);
            studentService.upDate(studentNew);
        }else{
            studentService.upDate(student);
        }
        return Result.success();
    }
//学生分页
    @RequestMapping(value = "/findpage",method = RequestMethod.GET)
    public Result<?> findPage(@RequestParam int pageNum,
                              @RequestParam int pageSize,
                              @RequestParam String search){
        PageHelper.startPage(pageNum,pageSize);
        List<Student> students;
        if (StrUtil.isNotBlank(search)){
            students = studentService.getNickName(search);
        }else{
            students = studentService.getAllStudent();
        }
        PageInfo pageInfo = new PageInfo(students);
        return Result.success(pageInfo);
    }

//    学生加入学校
    @RequestMapping(value = "/joinschool",method = RequestMethod.POST)
    public Result<?> joinSchool(@RequestBody JSONObject body){
        String schoolName = body.get("schoolName").toString();
        Integer studentId = Integer.parseInt(body.get("studentId").toString());
        Student res = studentService.findById(studentId);
        if (res.getSchoolName()!=null){
            return Result.error("-1","你已经加入一所大学了");
        }
        Student student = new Student();
        School school = new School();
        student.setSchoolName(schoolName);
        student.setStudentId(studentId);
        studentService.upDateSchool(student);
        School ans = schoolService.queryByName(schoolName);
        Integer studentAmount = ans.getStudentAmount() + 1;
        school.setSchoolName(schoolName);
        school.setStudentAmount(studentAmount);
        schoolService.upDate(school);
        return Result.success(studentService.findById(studentId));
    }






}
