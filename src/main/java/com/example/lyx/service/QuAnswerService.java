package com.example.lyx.service;


import com.example.lyx.entity.QuAnswer;

public interface QuAnswerService {
    void addAnswer(QuAnswer answer);
    void deleteById(Integer id);
    void updateAnswer(QuAnswer answer);
}
