package com.ysu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysu.entity.DeviceClass;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author keg
 * @since 2021-05-26
 */
public interface DeviceClassService extends IService<DeviceClass> {
    List<DeviceClass> list();
    List<DeviceClass> getDeviceClass();
}
