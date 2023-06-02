package com.example.lyx.controller;


import cn.hutool.json.JSONObject;
import com.example.lyx.common.Result;
import com.example.lyx.entity.Repo;
import com.example.lyx.service.RepoService;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/repo")
public class RepoController {
    @Autowired
    private RepoService repoService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result<?> addRepo(@RequestBody JSONObject body){
        String repoName = body.get("repoName").toString();
        Integer radioCount = 0;
        Repo repo = new Repo();
        repo.setRepoName(repoName);
        repo.setRadioCount(radioCount);
        repoService.addRepo(repo);
        return Result.success();
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result<?> updateRepo(@RequestBody Repo repo){
        repoService.updateName(repo);
        return Result.success();
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result<?> deleteById(@RequestParam Integer id){
        repoService.deleteById(id);
        return Result.success();
    }



}
