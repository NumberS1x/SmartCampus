package com.example.lyx.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.ibatis.annotations.Delete;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class RecordAudit implements Serializable {
    private Integer recordId;
    private Integer applicantId;
    private String applicantName;
    private String auditorName;
    private String auditOutcome;
    private Integer auditTime;
}
