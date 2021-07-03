package com.ysu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ysu.entity.Device;
import com.ysu.entity.page.PageListRes;
import com.ysu.entity.page.QueryVode;
import com.ysu.mapper.DeviceMapper;
import com.ysu.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {
    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public void insertDevice(Device device,int cId,int uId,int mId){
        deviceMapper.insertDevice(device,cId,uId,mId);
    }

    @Override
    public void deleteDevice(Long id){
        deviceMapper.deleteDevice(id);
    }

    @Override
    public Integer updateDevice(Device device,int id,int cId,int uId,int mId){
        return deviceMapper.updateDevice(device,id,cId,uId,mId);
    }

    @Override
    public Device findById(int id){
        return deviceMapper.findById(id);
    }

    @Override
    public PageListRes deviceList(QueryVode vo) {
        System.out.println(vo.getCurr());
        System.out.println(vo.getLimit());
        System.out.println(vo.getKeyword());
        System.out.println(vo.getStatus());
        Page<Object> page = PageHelper.startPage(vo.getCurr(), vo.getLimit());
        List<Device> deviceList = deviceMapper.deviceList(vo);
//        System.out.println(userList);
        /*封装成pageList*/
        PageListRes pageListRes = new PageListRes();
        pageListRes.setTotal(page.getTotal());
        pageListRes.setRows(deviceList);
        return pageListRes;
    }

}
