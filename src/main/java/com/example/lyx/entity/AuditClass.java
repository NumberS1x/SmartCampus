package com.example.lyx.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class AuditClass implements Serializable {
    private Integer auditId;
    private String auditorName;
    private Integer auditorId;
    private Integer applicantId;
    private String applicantName;
    private String applicantClass;
    private Integer applicantTime;
}
