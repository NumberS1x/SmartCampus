package com.example.lyx.mapper;


import com.example.lyx.entity.Teacher;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TeacherMapper {
    @Insert("insert into teacher values(#{teacherNumber},#{teacherPass},#{teacherName},#{teacherCourse},#{teacherSchool})")
    void addTeacher(Teacher teacher);
    @Delete("delete from teacher where teacher_number = #{teacherNumber}")
    void deleteById(Integer teacherNumber);

    @Update("update teacher set teacher_name = #{teacherName},teacher_pass=#{teacherPass},teacher_course=#{teacherCourse},teacher_school=#{teacherSchool} where teacher_number=#{teacherNumber}")
    void updateTeacher(Teacher teacher);

    @Select("select * from teacher where teacher_number =#{teacherNumber}")
    Teacher queryById(Integer teacherNumber);

    @Select("select * from teacher where teacher_number =#{teacherNumber} and teacher_pass =#{teacherPass}")
    Teacher login(Integer teacherNumber,String teacherPass);
}
