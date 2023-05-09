package com.example.lyx.mapper;


import com.example.lyx.entity.MyClass;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MyClassMapper {
    @Insert("insert into class values(#{classId},#{className},#{classTeacherAmount},#{classStudentAmount},#{classSys},#{schoolName})")
    void addClass(MyClass myClass);

    @Delete("delete from class where class_id = #{classId}")
    void deleteClass(Integer classId);

    @Update("update class set class_teacher_amount = #{classTeacherAmount}")
    void updateTeacherAmount(Integer classTeacherAmount);

    @Update("update class set class_student_amount = #{classStudentAmount}")
    void updateStudentAmount(Integer classStudentAmount);

    @Select("select * from class where class_id = #{classId}")
    MyClass queryById(Integer classId);

    @Select("select * from class where class_name = #{className}")
    MyClass queryByName(String className);

    @Select("select * from class where class_name =#{className} && school_name = #{schoolName}")
    MyClass queryBySchool(String className,String schoolName);

    @Select("select * from class where school_name = #{schoolName}")
    List<MyClass> getAllClass(String schoolName);

    @Select("select * from class where class_name like '%' #{search} '%' and school_name = #{schoolName}")
    List<MyClass> getNickName(String search,String schoolName);

}
