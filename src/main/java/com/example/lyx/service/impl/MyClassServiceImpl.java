package com.example.lyx.service.impl;


import com.example.lyx.entity.MyClass;
import com.example.lyx.mapper.MyClassMapper;
import com.example.lyx.service.MyClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("myClassService")
public class MyClassServiceImpl implements MyClassService {
    @Autowired
    private MyClassMapper myClassMapper;

    @Override
    public List<MyClass> getAllClass(String schoolName){
      return myClassMapper.getAllClass(schoolName);
    }

    @Override
    public void addMyClass(MyClass myClass){
        myClassMapper.addClass(myClass);
    }

    @Override
    public List<MyClass> getNickName(String search,String schoolName){
        return myClassMapper.getNickName(search,schoolName);
    }

    @Override
    public MyClass queryById(Integer classId){
        return myClassMapper.queryById(classId);
    }

    @Override
    public MyClass queryBySchoolName(String className,String schoolName){
        return myClassMapper.queryBySchool(className,schoolName);
    }

    @Override
    public void upDateStudentAmount(Integer studentAmount){
        myClassMapper.updateStudentAmount(studentAmount);
    }

    @Override
    public MyClass queryByName(String className){
        return myClassMapper.queryByName(className);
    }
}
