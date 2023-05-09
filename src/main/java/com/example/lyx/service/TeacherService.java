package com.example.lyx.service;

import com.example.lyx.entity.Teacher;

public interface TeacherService {
    Teacher getAccount(Integer teacherNumber,String teacherPass);
    void addTeacher(Teacher teacher);
    Teacher findById(Integer teacherNumber);
    void upDate(Teacher teacher);
}
