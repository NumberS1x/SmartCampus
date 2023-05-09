package com.example.lyx.service;

import com.example.lyx.entity.RecordAudit;

import java.util.List;

public interface RecordAuditService {
    void addRecord(RecordAudit recordAudit);
    void deleteById(Integer recordId);
    List<RecordAudit> queryByApplicantId(Integer applicantId);
}
