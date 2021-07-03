package com.ysu.controller;


import com.ysu.common.Result;
import com.ysu.entity.Accountbook;
import com.ysu.entity.page.PageListRes;
import com.ysu.entity.page.QueryVo;
import com.ysu.service.AccountbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author keg
 * @since 2021-05-23
 */
@RestController
@RequestMapping("/accountbook")
public class AccountbookController {

    @Autowired
    AccountbookService AccountbookService;

    @GetMapping("/accountbookList")
    public Result AccountbookList(String keyword, QueryVo vo) {

        PageListRes pageList = AccountbookService.AccountbookList(vo);
        return Result.success(pageList);
    }

    //更改用户状态（启用/冻结）
    @RequestMapping("/deleteAccountbook")
    public Result status(@RequestParam(value = "ids") Long ids) {
        System.out.println(ids);
        AccountbookService.deleteAccountbook(ids);
        return Result.success("");
    }

    @PostMapping("/save")
    public Result save2(Accountbook accountbook) {  //@Validated
        System.out.println("save---");
        System.out.println(accountbook);
        AccountbookService.insertAccount(accountbook);
        return Result.success("");
    }

}
