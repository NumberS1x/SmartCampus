package com.example.lyx.controller;


import cn.hutool.json.JSONObject;
import com.example.lyx.common.Result;
import com.example.lyx.entity.AuditClass;
import com.example.lyx.entity.MyClass;
import com.example.lyx.entity.RecordAudit;
import com.example.lyx.entity.Student;
import com.example.lyx.service.AuditClassService;
import com.example.lyx.service.MyClassService;
import com.example.lyx.service.RecordAuditService;
import com.example.lyx.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/audit")
public class AuditClassController {
    @Autowired
    private AuditClassService auditClassService;

    @Autowired
    private RecordAuditService recordAuditService;

    @Autowired
    private StudentService studentService;
    @Autowired
    private MyClassService myClassService;


//添加一条审核信息
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result<?> addAudit(@RequestBody JSONObject body){
        Integer applicantId = Integer.parseInt(body.get("applicantId").toString());
        String applicantClass = body.get("applicantClass").toString();
        if (auditClassService.auditExist(applicantId,applicantClass) != null){
            return Result.error("-1","您已经申请加入，请等待审核");
        }
        Integer auditId = new Random().nextInt(99999999);
        while (auditClassService.getById(auditId) != null){
            auditId = new Random().nextInt(99999999);
        }
        String applicantName = body.get("applicantName").toString();
        Integer applicantTime = Integer.parseInt(body.get("applicantTime").toString());
        Integer auditorId = Integer.parseInt(body.get("auditorId").toString());
        String auditorName= body.get("auditorName").toString();
        AuditClass auditClass = new AuditClass();
        auditClass.setAuditId(auditId);
        auditClass.setAuditorName(auditorName);
        auditClass.setAuditorId(auditorId);
        auditClass.setApplicantId(applicantId);
        auditClass.setApplicantName(applicantName);
        auditClass.setApplicantClass(applicantClass);
        auditClass.setApplicantTime(applicantTime);
        auditClassService.addAudit(auditClass);
        return Result.success(auditClassService.getById(auditId));
    }
//根据审核人Id来分页
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public Result<?> findPage(@RequestParam Integer pageNum,
                              @RequestParam Integer pageSize,
                              @RequestParam Integer auditorId){
        PageHelper.startPage(pageNum,pageSize);
        List<AuditClass> auditClasses = auditClassService.queryByAuditorId(auditorId);
        PageInfo pageInfo = new PageInfo(auditClasses);
        return Result.success(pageInfo);
    }

    //开始审核
    @RequestMapping(value = "/startAudit",method = RequestMethod.POST)
    public Result<?> startAudit(@RequestBody JSONObject body){
        Integer auditId = Integer.parseInt(body.get("auditId").toString());
        String auditOutcome = body.get("auditOutcome").toString();
        Integer applicantId = Integer.parseInt(body.get("applicantId").toString());
        String applicantName = body.get("applicantName").toString();
        String auditorName = body.get("auditorName").toString();
        Integer auditTime = Integer.parseInt(body.get("auditTime").toString());
        String schoolName = body.get("schoolName").toString();
        String applicantClass = body.get("applicantClass").toString();
        RecordAudit  recordAudit = new RecordAudit();
        recordAudit.setApplicantId(applicantId);
        recordAudit.setApplicantName(applicantName);
        recordAudit.setAuditorName(auditorName);
        recordAudit.setAuditTime(auditTime);
        recordAudit.setAuditOutcome(auditOutcome);
        recordAuditService.addRecord(recordAudit);

        if (auditOutcome.equals("拒绝")){
            return Result.success("操作成功！已经拒绝申请。");
        }else if (auditOutcome.equals("通过")){
            Student student = new Student();
            student.setStudentId(applicantId);
            student.setStudentClass(applicantClass);
            studentService.upDateClass(student);

            MyClass myClass = myClassService.queryBySchoolName(applicantClass,schoolName);
            Integer studentAmount = myClass.getClassStudentAmount() + 1;
            myClassService.upDateStudentAmount(studentAmount);
        }
        auditClassService.deleteById(auditId);
        return Result.success("操作成功！");
    }
}
