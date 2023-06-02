package com.example.lyx.service.impl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.example.lyx.entity.Qu;
import com.example.lyx.entity.QuAnswer;
import com.example.lyx.entity.QuRepo;
import com.example.lyx.entity.Repo;
import com.example.lyx.mapper.QuMapper;
import com.example.lyx.service.QuAnswerService;
import com.example.lyx.service.QuRepoService;
import com.example.lyx.service.QuService;
import com.example.lyx.service.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;


@Service("quService")
public class QuServiceImpl implements QuService {

    @Autowired
    private QuMapper quMapper;

    @Autowired
    private QuAnswerService quAnswerService;

    @Autowired
    private QuRepoService quRepoService;

    @Autowired
    private RepoService repoService;


    @Override
    public void addQu(Qu qu,JSONArray answers, Integer repoId){
        Integer level = qu.getLevel();
        quMapper.addQu(qu);
        Integer quId = quMapper.getId();
        //更新题库
        Integer radioCount = repoService.getRadioCount(repoId) +1;
        Repo repo = new Repo();
        repo.setRadioCount(radioCount);
        repo.setId(repoId);
        repoService.updateRadioCount(repo);
        //加入问题表
        for(int i =0;i<answers.size();i++){
            JSONObject answer = answers.getJSONObject(i);
            String content = answer.get("content").toString();
            Integer isRight = Integer.parseInt(answer.get("isRight").toString());
            QuAnswer quAnswer = new QuAnswer();
            quAnswer.setContent(content);
            quAnswer.setIsRight(isRight);
            quAnswer.setQuId(quId);
            quAnswerService.addAnswer(quAnswer);
        }
        //更新题库题目表
        QuRepo quRepo = new QuRepo();
        quRepo.setRepoId(repoId);
        quRepo.setQuId(quId);
        quRepo.setLevel(level);
        quRepoService.add(quRepo);
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
