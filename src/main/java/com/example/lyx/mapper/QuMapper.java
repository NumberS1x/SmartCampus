package com.example.lyx.mapper;


import com.example.lyx.entity.Qu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuMapper {

    @Insert("insert into qu values (#{id},#{level},#{content})")
    void addQu(Qu qu);

    @Select("select max(id) from qu")
    Integer getId();

    @Delete("delete from qu where id = #{id}")
    void deleteById(Integer id);

    @Update("update qu set content = #{content} where id = #{id}")
    void updateQu(Qu qu);

    @Select("select * from qu")
    List<Qu> getAll();

    @Select("select * from qu where content like '%' #{search} '%' ")
    List<Qu> getNickName(String search);
}
