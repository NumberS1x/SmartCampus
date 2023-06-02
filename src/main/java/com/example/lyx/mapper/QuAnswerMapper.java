package com.example.lyx.mapper;


import com.example.lyx.entity.QuAnswer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuAnswerMapper {

    @Insert("insert into qu_answer values (#{id},#{quId},#{isRight},#{content})")
    void addQuAnswer(QuAnswer quAnswer);

    @Update("update qu_answer set is_right =#{isRight},content =#{content} where id = #{id}")
    void updateQuAnswer(QuAnswer quAnswer);

    @Delete("delete from qu_answer where id = #{id}")
    void deleteById(Integer id);

    @Select("select * from qu_answer where id = #{id}")
    QuAnswer queryById(Integer id);

    @Select("select * from qu_answer where qu_id =#{quId}")
    List<QuAnswer> queryAnswer(Integer quId);
}
