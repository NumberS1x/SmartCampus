package com.example.lyx.service.impl;


import com.example.lyx.entity.RecordAudit;
import com.example.lyx.mapper.RecordAuditMapper;
import com.example.lyx.service.RecordAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("recordAuditService")
public class RecordAuditServiceImpl implements RecordAuditService {

    @Autowired
    private RecordAuditMapper recordAuditMapper;

    @Override
    public void addRecord(RecordAudit recordAudit){
        recordAuditMapper.addRecord(recordAudit);
    }

    @Override
    public void deleteById(Integer recordId){
        recordAuditMapper.deleteById(recordId);
    }

    @Override
    public List<RecordAudit> queryByApplicantId(Integer applicantId){
        return recordAuditMapper.queryByApplicantId(applicantId);
    }
}
