package com.example.lyx.service.impl;


import com.example.lyx.entity.QuAnswer;
import com.example.lyx.mapper.QuAnswerMapper;
import com.example.lyx.service.QuAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("quAnswerServiceImpl")
public class QuAnswerServiceImpl implements QuAnswerService {
    @Autowired
    private QuAnswerMapper quAnswerMapper;

    @Override
    public void addAnswer(QuAnswer answer){
        quAnswerMapper.addQuAnswer(answer);
    }

    @Override
    public void deleteById(Integer id){
        quAnswerMapper.deleteById(id);
    }

    @Override
    public void updateAnswer(QuAnswer answer){
        quAnswerMapper.updateQuAnswer(answer);
    }
}
