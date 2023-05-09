package com.example.lyx.service.impl;


import com.example.lyx.entity.Teacher;
import com.example.lyx.mapper.TeacherMapper;
import com.example.lyx.service.TeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher getAccount(Integer teacherNumber,String teacherPass){
        Teacher teacher = teacherMapper.login(teacherNumber,teacherPass);
        return teacher;
    }

    @Override
    public void addTeacher(Teacher teacher){
        teacherMapper.addTeacher(teacher);
    }

    @Override
    public Teacher findById(Integer teacherNumber){
        return teacherMapper.queryById(teacherNumber);
    }

    @Override
    public void upDate(Teacher teacher){
        teacherMapper.updateTeacher(teacher);
    }
}
