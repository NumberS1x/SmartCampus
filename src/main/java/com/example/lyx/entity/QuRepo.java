package com.example.lyx.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class QuRepo implements Serializable {
    private Integer id;
    private Integer quId;
    private Integer repoId;
    private Integer level;
}
