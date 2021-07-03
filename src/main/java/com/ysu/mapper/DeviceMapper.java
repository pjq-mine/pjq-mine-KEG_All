package com.ysu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysu.entity.Device;
import com.ysu.entity.page.QueryVode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceMapper extends BaseMapper<Device> {

    List<Device> deviceList(QueryVode vo);
    void insertDevice(@Param("device") Device device,@Param("cId") int cId,@Param("uId")int uId,@Param("mId")int mId);
    void deleteDevice(Long id);
    Integer updateDevice(@Param("device") Device device,@Param("id") int id,@Param("cId") int cId,@Param("uId")int uId,@Param("mId")int mId);
    Device findById(int id);
}
