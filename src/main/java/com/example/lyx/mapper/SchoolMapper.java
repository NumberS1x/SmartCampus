package com.example.lyx.mapper;

import com.example.lyx.entity.School;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SchoolMapper {
    @Insert("insert into school values(#{schoolId},#{schoolName},#{studentAmount})")
    void addSchool(School school);

    @Delete("delete from school where school_id =#{schoolId}")
    void deleteById(Integer schoolId);

    @Update("update school set student_amount = #{studentAmount} where school_name = #{schoolName}")
    void updateSchool(School school);

    @Select("select * from school where school_id =#{schoolId}")
    School queryById(Integer schoolId);

    @Select("select * from school where school_name = #{schoolName}")
    School queryByName(String schoolName);

    @Select("select * from school")
    List<School> getAllList();

    @Select("select * from school where school_name like '%' #{search} '%'")
    List<School> queryNickName(String search);

}
