package com.example.lyx.service.impl;

import com.example.lyx.entity.Qu;
import com.example.lyx.mapper.QuMapper;
import com.example.lyx.service.QuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("quService")
public class QuServiceImpl implements QuService {

    @Autowired
    private QuMapper quMapper;

    @Override
    public void addQu(Qu qu){
        quMapper.addQu(qu);
    }

    @Override
    public void deleteById(Integer id){
        quMapper.deleteById(id);
    }

    @Override
    public void updateQu(Qu qu){
        quMapper.updateQu(qu);
    }

    @Override
    public List<Qu> getAllQu(){
        return quMapper.getAll();
    }

    @Override
    public List<Qu> getNickName(String search){
        return quMapper.getNickName(search);
    }
}
