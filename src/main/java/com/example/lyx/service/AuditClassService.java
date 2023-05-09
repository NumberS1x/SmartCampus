package com.example.lyx.service;


import com.example.lyx.entity.AuditClass;

import java.util.List;

public interface AuditClassService {
    void addAudit(AuditClass auditClass);
    void deleteById(Integer auditId);
    List<AuditClass> getAll();
    List<AuditClass> queryByName(String auditorName);
    List<AuditClass> queryByAuditorId(Integer auditorId);
    AuditClass auditExist(Integer applicantId,String applicantClass);
    AuditClass getById(Integer auditId);
}
