package com.ysu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysu.entity.DeviceClass;
import com.ysu.mapper.DeviceClassMapper;
import com.ysu.service.DeviceClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author keg
 * @since 2021-05-26
 */
@Service
public class DeviceClassServiceImpl extends ServiceImpl<DeviceClassMapper, DeviceClass> implements DeviceClassService {
    @Autowired
    private DeviceClassMapper deviceClassMapper;

    @Override
    public List<DeviceClass> list() {
        return deviceClassMapper.list();
    }
    @Override
    public List<DeviceClass> getDeviceClass(){return deviceClassMapper.getDeviceClass();}
}
