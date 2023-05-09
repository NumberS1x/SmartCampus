package com.example.lyx.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class MyClass {
    private Integer classId;
    private String className;
    private Integer classTeacherAmount;
    private Integer classStudentAmount;
    private String classSys;
    private String schoolName;
}
