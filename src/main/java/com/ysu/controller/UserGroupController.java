package com.ysu.controller;


import com.ysu.common.Result;
import com.ysu.entity.UserGroup;
import com.ysu.service.UserGroupService;
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
@RequestMapping("/user-group")
public class UserGroupController {
    @Autowired
    private UserGroupService userGroupService;

    //获取全部的userGroup
//    @RequiresAuthentication
    @GetMapping("/userGroupList")
    public Result index() {
        List<UserGroup> list = userGroupService.list();
        return Result.success(list);
    }

    //获取不带‘全部’的userGroup
    @GetMapping("/getUserGroup")
    public Result getUserGroup() {
        List<UserGroup> list = userGroupService.getUserGroup();
        return Result.success(list);
    }
}
