package com.example.lyx.entity;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Teacher implements Serializable {
    private Integer teacherNumber;
    private String teacherPass;
    private String teacherName;
    private String teacherCourse;
    private String teacherSchool;
}
