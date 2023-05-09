package com.example.lyx.service.impl;


import com.example.lyx.entity.AuditClass;
import com.example.lyx.mapper.AuditClassMapper;
import com.example.lyx.service.AuditClassService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service("auditClassService")
public class AuditClassServiceImpl implements AuditClassService {
    @Autowired
    private AuditClassMapper auditClassMapper;

    @Override
    public void addAudit(AuditClass auditClass){
        auditClassMapper.addAudit(auditClass);
    }

    @Override
    public void deleteById(Integer auditId){
        auditClassMapper.deleteById(auditId);
    }

    @Override
    public List<AuditClass> getAll(){
        return auditClassMapper.getAll();
    }

    @Override
    public List<AuditClass> queryByName(String auditorName){
        return auditClassMapper.getByAuditorName(auditorName);
    }

    @Override
    public List<AuditClass> queryByAuditorId(Integer auditorId){
        return auditClassMapper.queryByAuditorId(auditorId);
    }


    @Override
    public AuditClass auditExist(Integer applicantId,String applicantClass){
        return auditClassMapper.queryExist(applicantId,applicantClass);
    }

    @Override
    public AuditClass getById(Integer auditId){
        return auditClassMapper.queryById(auditId);
    }

}
