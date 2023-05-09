package com.example.lyx.mapper;


import com.example.lyx.entity.AuditClass;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuditClassMapper {
    @Insert("insert into audit_class values(#{auditId},#{auditorName},#{auditorId},#{applicantId},#{applicantName},#{applicantClass},#{applicantTime})")
    void addAudit(AuditClass auditClass);

    @Delete("delete from audit_class where audit_id = #{auditId}")
    void deleteById(Integer auditId);

    @Select("select * from audit_class")
    List<AuditClass> getAll();

    @Select("select * from audit_class where auditor_name = #{auditorName}")
    List<AuditClass> getByAuditorName(String auditorName);

    @Select("select * from audit_class where applicant_id = #{applicantId} && applicant_class = #{applicantClass}")
    AuditClass queryExist(Integer applicantId,String applicantClass);

    @Select("select * from audit_class where audit_id = #{auditId}")
    AuditClass queryById(Integer auditId);

    @Select("select * from audit_class where auditor_id = #{auditorId}")
    List<AuditClass> queryByAuditorId(Integer auditorId);
}
