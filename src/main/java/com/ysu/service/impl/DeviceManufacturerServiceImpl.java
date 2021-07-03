package com.ysu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysu.entity.DeviceManufacturer;
import com.ysu.mapper.DeviceManufacturerMapper;
import com.ysu.service.DeviceManufacturerService;
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
public class DeviceManufacturerServiceImpl extends ServiceImpl<DeviceManufacturerMapper, DeviceManufacturer> implements DeviceManufacturerService {
    @Autowired
    private DeviceManufacturerMapper deviceManufacturerMapper;

    @Override
    public List<DeviceManufacturer> deviceManufacturerList() {
        return deviceManufacturerMapper.deviceManufacturerList();
    }
    @Override
    public List<DeviceManufacturer> getDeviceManufacturer(){
        return deviceManufacturerMapper.getDeviceManufacturer();
    }
}
