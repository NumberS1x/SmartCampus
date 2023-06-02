package com.example.lyx.service;


import cn.hutool.json.JSONArray;
import com.example.lyx.entity.Qu;
import com.example.lyx.entity.QuAnswer;

import java.util.List;

public interface QuService {
    void addQu(Qu qu, JSONArray answers, Integer repoId);
    void deleteById(Integer id);
    void updateQu(Qu qu);
    List<Qu> getAllQu();
    List<Qu> getNickName(String search);
}
