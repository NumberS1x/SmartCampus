package com.example.lyx.mapper;


import com.example.lyx.entity.Repo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RepoMapper {
    @Insert("insert into repo values(#{id},#{repoName},#{radioCount})")
    void addRepo(Repo repo);

    @Delete("delete * from repo where id = #{id}")
    void deleteById(Integer id);


    @Update("update repo set repo_name = #{repoName} where id =#{id}")
    void updateName(Repo repo);

    @Update("update repo set radio_count = #{radioCount} where id = #{id}")
    void updateRadioCount(Repo repo);

    @Select("select * from repo where id =#{id}")
    Repo queryById(Integer id);

    @Select("select radio_count from repo where id = #{id}")
    Integer getRadioCount(Integer id);

    @Select("select * from repo")
    List<Repo> getAll();

}
