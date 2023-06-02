package com.example.lyx.service;

import com.example.lyx.entity.Repo;

public interface RepoService {
    void addRepo(Repo repo);
    void deleteById(Integer id);
    void updateName(Repo repo);
    void updateRadioCount(Repo repo);
    Integer getRadioCount(Integer repoId);
}
