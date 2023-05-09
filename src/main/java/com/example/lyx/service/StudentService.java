package com.example.lyx.service;

import com.example.lyx.entity.Student;

import java.util.List;

public interface StudentService {
    Student getAccount(Integer studentId,String studentPass);
    void addStudent(Student student);
    Student findById(Integer studentId);
    void upDate(Student student);
    List<Student> getAllStudent();
    List<Student> getNickName(String search);
    void upDateSchool(Student student);
    void upDateClass(Student student);
}
