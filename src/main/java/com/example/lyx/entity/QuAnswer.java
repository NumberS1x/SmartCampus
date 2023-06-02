package com.example.lyx.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class QuAnswer implements Serializable {
    private Integer id;
    private Integer quId;
    private Integer isRight;
    private String content;
}
