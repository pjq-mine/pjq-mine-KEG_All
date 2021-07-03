package com.ysu.controller;


import com.ysu.common.Result;
import com.ysu.entity.DeviceClass;
import com.ysu.service.DeviceClassService;
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
 * @since 2021-05-26
 */
@RestController
@RequestMapping("/device-class")
public class DeviceClassController {
    @Autowired
    private DeviceClassService deviceClassService;

    @GetMapping("/deviceClassList")
    public Result index() {
        List<DeviceClass> list = deviceClassService.list();
        return Result.success(list);
    }
    @GetMapping("/getDeviceClass")
    public Result getDeviceClass(){
        List<DeviceClass> list = deviceClassService.getDeviceClass();
        return Result.success(list);
    }
}
