package com.example.lyx.service.impl;

import com.example.lyx.entity.QuRepo;
import com.example.lyx.mapper.QuRepoMapper;
import com.example.lyx.service.QuRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("quRepoServiceImpl")
public class QuRepoServiceImpl implements QuRepoService {
    @Autowired
    private QuRepoMapper quRepoMapper;

    @Override
    public void add(QuRepo quRepo){
        quRepoMapper.add(quRepo);
    }

}
