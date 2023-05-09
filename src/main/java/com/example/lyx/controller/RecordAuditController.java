package com.example.lyx.controller;


import com.example.lyx.service.RecordAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/recordAudit")
public class RecordAuditController {
    @Autowired
    private RecordAuditService recordAuditService;


}
