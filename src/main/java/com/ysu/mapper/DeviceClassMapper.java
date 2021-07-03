package com.ysu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysu.entity.DeviceClass;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author keg
 * @since 2021-05-26
 */
public interface DeviceClassMapper extends BaseMapper<DeviceClass> {
    List<DeviceClass> list();
    List<DeviceClass> getDeviceClass();
}
