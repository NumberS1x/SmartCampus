package com.example.lyx.service.impl;

import com.example.lyx.entity.Repo;
import com.example.lyx.mapper.RepoMapper;
import com.example.lyx.service.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("repoServiceImpl")
public class RepoServiceImpl implements RepoService {
    @Autowired
    private RepoMapper repoMapper;

    @Override
    public void addRepo(Repo repo){
        repoMapper.addRepo(repo);
    }

    @Override
    public void deleteById(Integer id){
        repoMapper.deleteById(id);
    }

    @Override
    public void updateName(Repo repo){
        repoMapper.updateName(repo);
    }

    @Override
    public void updateRadioCount(Repo repo){
        repoMapper.updateRadioCount(repo);
    }

    @Override
    public Integer getRadioCount(Integer repoId){
        return repoMapper.getRadioCount(repoId);
    }
}
