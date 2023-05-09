package com.example.lyx.service;

import com.example.lyx.entity.MyClass;

import java.util.List;

public interface MyClassService {
    List<MyClass> getAllClass(String schoolName);
    void addMyClass(MyClass myClass);
    List<MyClass> getNickName(String search,String schoolName);
    MyClass queryById(Integer classId);
    MyClass queryBySchoolName(String className,String schoolName);
    void upDateStudentAmount(Integer studentAmount);
    MyClass queryByName(String className);
}
