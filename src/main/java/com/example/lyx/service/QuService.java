package com.example.lyx.service;


import com.example.lyx.entity.Qu;

import java.util.List;

public interface QuService {
    void addQu(Qu qu);
    void deleteById(Integer id);
    void updateQu(Qu qu);
    List<Qu> getAllQu();
    List<Qu> getNickName(String search);
}
