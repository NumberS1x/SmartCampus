package com.example.lyx.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Student implements Serializable {
    private Integer studentId;
    private String studentName;
    private String studentClass;
    private String studentPass;
    private String studentSex;
    private String studentBoss;
    private String schoolName;
}
