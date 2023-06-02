package com.example.lyx.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Repo implements Serializable {
    private Integer id;
    private String repoName;
    private Integer radioCount;
}
