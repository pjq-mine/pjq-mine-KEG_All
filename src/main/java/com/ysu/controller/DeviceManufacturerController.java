package com.ysu.controller;


import com.ysu.common.Result;
import com.ysu.entity.DeviceManufacturer;
import com.ysu.service.DeviceManufacturerService;
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
@RequestMapping("/device-manufacturer")
public class DeviceManufacturerController {
    @Autowired
    private DeviceManufacturerService deviceManufacturerService;

    @GetMapping("/deviceManufacturerList")
    public Result index() {
        List<DeviceManufacturer> list = deviceManufacturerService.deviceManufacturerList();
        return Result.success(list);
    }
    @GetMapping("/getDeviceManufacturer")
    public Result getDeviceManufacturer(){
        List<DeviceManufacturer> list = deviceManufacturerService.getDeviceManufacturer();
        return  Result.success(list);
    }
}
