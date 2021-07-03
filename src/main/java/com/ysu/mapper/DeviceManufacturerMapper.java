package com.ysu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysu.entity.DeviceManufacturer;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author keg
 * @since 2021-05-26
 */
public interface DeviceManufacturerMapper extends BaseMapper<DeviceManufacturer> {
    List<DeviceManufacturer> deviceManufacturerList();
    List<DeviceManufacturer> getDeviceManufacturer();
}
