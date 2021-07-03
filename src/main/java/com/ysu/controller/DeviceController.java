package com.ysu.controller;


import com.ysu.common.Result;
import com.ysu.entity.Device;
import com.ysu.entity.page.PageListRes;
import com.ysu.entity.page.QueryVode;
import com.ysu.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device")

public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @GetMapping("/index")
    public Result index() {
        Device device = deviceService.getById(2L);
        return Result.success(device);
    }

    @GetMapping("/deviceList")
    public Result deviceList(String keyword, QueryVode vo) {
        PageListRes pageList = deviceService.deviceList(vo);
        return Result.success(pageList);
    }

    @GetMapping("/findById")
    public Result findById(int id){

        return Result.success((deviceService.findById(id)));
    }

    @RequestMapping("/update")
    public Result update(Device device,int id, int cId, int uId, int mId){
        System.out.println("save---");
        System.out.println(device);
        Integer rows =deviceService.updateDevice(device,id,cId,uId,mId);
        if (rows==null){
            return null;
        }
        return Result.success(200,"修改成功",device);
    }

    @PostMapping("/save")
    public Result save( Device device,int cId,int uId,int mId) {

        deviceService.insertDevice(device,cId,uId,mId);
        return Result.success(device);
    }

    @RequestMapping("/deleteDevice")
    public void deleteDevice(Long id){
        deviceService.deleteDevice(id);
    }


}
