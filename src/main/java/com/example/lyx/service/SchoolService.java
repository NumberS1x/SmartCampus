package com.example.lyx.service;


import com.example.lyx.entity.School;

import java.util.List;

public interface SchoolService {
    School queryById(Integer schoolId);
    List<School> getAllSchool();
    List<School> getNickName(String search);
    School queryByName(String schoolName);
    void upDate(School school);
}
