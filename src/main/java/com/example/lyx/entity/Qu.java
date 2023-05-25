package com.example.lyx.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Qu implements Serializable {
    private Integer id;
    private Integer level;
    private String content;
}
