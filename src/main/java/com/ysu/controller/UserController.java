package com.ysu.controller;


import com.ysu.common.Result;
import com.ysu.entity.UploadResult;
import com.ysu.entity.User;
import com.ysu.entity.page.PageListRes;
import com.ysu.entity.page.QueryVo;
import com.ysu.service.UserService;
import com.ysu.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author keg
 * @since 2021-05-05
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

//    @RequiresAuthentication
    @GetMapping("/index")
    public Result index() {
        User user = userService.getById(2L);
        return Result.success(user);
    }

    @GetMapping("/userList")
    public Result userList(String keyword, QueryVo vo) {
        PageListRes pageList = userService.userList(vo);
        System.out.println(keyword);
        System.out.println(vo.toString());
        return Result.success(pageList);
    }

    @GetMapping("/userInfo")
    public Result userInfo() {
        List<User> list = userService.getUserInfo();
        return Result.success(list);
    }

    //更改用户状态（启用/冻结）
    @RequestMapping("/status/{param}")
    public Result status(@PathVariable("param") String param,
                         @RequestParam(value = "ids", required = false) List<Long> ids) {
        System.out.println(param);
        System.out.println(ids);
        int status = 0;
        if (param.equals("ok")){
            status = 1;
        }else if (param.equals("freezed")){
            status = 0;
        }else if (param.equals("delete")){
            userService.deleteUsers(ids);
        }
        userService.updateStatus(status, ids);
        return Result.success("");
    }

    @PostMapping("/save")
    public Result save(User user, int gId, int rId) {  //@Validated
        System.out.println("save---");
        System.out.println(user);
        userService.insertUser(user,gId,rId);
        return Result.success("");
    }

    /**
     * 文件上传
     * @param file
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadImages",method= RequestMethod.POST)
    @ResponseBody
    public UploadResult uploadImages(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destDir = "/upload/picture";
        UploadResult webResult = new UploadResult();
        try {
            String path = UploadUtil.uploads(file, destDir, request,response);
            System.out.println(path);
            webResult.setStatus(0);
            webResult.setFilepath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webResult;
    }




}
