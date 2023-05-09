package com.example.lyx.service.impl;


import com.example.lyx.entity.School;
import com.example.lyx.mapper.SchoolMapper;
import com.example.lyx.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("schoolService")
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public School queryById(Integer schoolId){
        return schoolMapper.queryById(schoolId);
    }

    @Override
    public List<School> getAllSchool(){
        return schoolMapper.getAllList();
    }

    @Override
    public List<School> getNickName(String search){
        return schoolMapper.queryNickName(search);
    }

    @Override
    public School queryByName(String schoolName){
        return schoolMapper.queryByName(schoolName);
    }

    @Override
    public void upDate(School school){
        schoolMapper.updateSchool(school);
    }
}
