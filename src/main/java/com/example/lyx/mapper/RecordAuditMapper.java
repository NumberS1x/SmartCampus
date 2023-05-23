package com.example.lyx.mapper;


import com.example.lyx.entity.RecordAudit;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecordAuditMapper {
    @Insert("insert into record_audit values(#{recordId},#{applicantId},#{applicantName},#{auditorName},#{auditOutcome},#{auditTime})")
    void addRecord(RecordAudit recordAudit);

    @Delete("delete from record_audit where record_id = #{recordId}")
    void deleteById (Integer recordId);

    @Select("select * from record_audit where applicant_id =#{applicantId}")
    List<RecordAudit> queryByApplicantId(Integer applicantId);
}
