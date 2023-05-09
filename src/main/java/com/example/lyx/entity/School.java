package com.example.lyx.entity;


import io.swagger.models.auth.In;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class School implements Serializable {
    private Integer schoolId;
    private String schoolName;
    private Integer studentAmount;
}
