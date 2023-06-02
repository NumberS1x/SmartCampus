package com.example.lyx.mapper;


import com.example.lyx.entity.QuRepo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuRepoMapper {
    @Insert("insert into qu_repo values(#{id},#{quId},#{repoId},#{level})")
    void add(QuRepo quRepo);

    @Delete("delete from qu_repo where id = #{id}")
    void deleteById(Integer id);
}
