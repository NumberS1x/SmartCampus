package com.example.lyx.mapper;


import com.example.lyx.entity.School;
import com.example.lyx.entity.Student;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    @Insert("insert into student values(#{studentId},#{studentName},#{studentClass},#{studentPass},#{studentSex},#{studentBoss},#{schoolName})")
    void addStudent(Student student);

    @Delete("delete from student where student_Id = #{studentId}")
    void deleteById(Integer studentId);

    @Update("update student set student_name = #{studentName},student_class =#{studentClass},student_pass=#{studentPass},student_sex=#{studentSex},student_boss=#{studentBoss},school_name = #{schoolName} where student_Id=#{studentId}")
    void updateStudent(Student student);

    @Update("update student set school_name = #{schoolName} where student_id = #{studentId}")
    void upDateSchoolName(Student student);

    @Update("update student set class_name = #{className} where student_id = {studentId}")
    void upDateClassName(Student student);

    @Select("select * from student where student_Id =#{studentId}")
    Student queryById(Integer studentId);

    @Select("select * from student where student_Id =#{studentId} and student_pass =#{studentPass}")
    Student login(Integer studentId,String studentPass);

    @Select("select * from student")
    List<Student> getAllStudent();

    @Select("select * from student where student_name like '%' #{studentName} '%' ")
    List<Student> queryNickName(String studentName);
}
