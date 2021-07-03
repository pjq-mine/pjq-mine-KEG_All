package com.ysu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysu.entity.DeviceManufacturer;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author keg
 * @since 2021-05-26
 */
public interface DeviceManufacturerService extends IService<DeviceManufacturer> {
    List<DeviceManufacturer> deviceManufacturerList();
    List<DeviceManufacturer> getDeviceManufacturer();
}
