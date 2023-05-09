package com.example.lyx.service.impl;


import com.example.lyx.entity.Student;
import com.example.lyx.mapper.StudentMapper;
import com.example.lyx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getAccount(Integer studentId,String studentPass){
        Student student = studentMapper.login(studentId,studentPass);
        return student;
    }

    @Override
    public void addStudent(Student student){
        studentMapper.addStudent(student);
    }

    @Override
    public Student findById(Integer studentId){
        Student student = studentMapper.queryById(studentId);
        return student;
    }

    @Override
    public void upDate(Student student){
        studentMapper.updateStudent(student);
    }

    @Override
    public List<Student> getAllStudent(){
        return studentMapper.getAllStudent();
    }

    @Override
    public List<Student> getNickName(String search){
        return studentMapper.queryNickName(search);
    }

    @Override
    public void upDateSchool(Student student){
        studentMapper.upDateSchoolName(student);
    }

    @Override
    public void upDateClass(Student student){
        studentMapper.upDateClassName(student);
    }
}
