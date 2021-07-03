package com.ysu.controller;


import com.ysu.common.Result;
import com.ysu.entity.UserResearch;
import com.ysu.service.UserResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author keg
 * @since 2021-05-13
 */
@RestController
@RequestMapping("/user-research")
public class UserResearchController {
    @Autowired
    private UserResearchService userResearchService;

    //获取全部的userResearch
    @GetMapping("/userResearchList")
    public Result index() {
        List<UserResearch> list = userResearchService.userResearchList();
        return Result.success(list);
    }

    //获取不包含‘全部’的userResearch
    @GetMapping("/getUserResearch")
    public Result getUserResearch() {
        List<UserResearch> list = userResearchService.getUserResearch();
        return Result.success(list);
    }

}
