package com.ysu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysu.entity.Device;
import com.ysu.entity.page.PageListRes;
import com.ysu.entity.page.QueryVode;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceService extends IService<Device> {

    PageListRes deviceList(QueryVode vo);
    void insertDevice(Device device,int cId,int uId,int mId);
    void deleteDevice(Long id);
    Integer updateDevice(Device device,int id,int cId,int uId,int mId);
    Device findById(int id);
}

