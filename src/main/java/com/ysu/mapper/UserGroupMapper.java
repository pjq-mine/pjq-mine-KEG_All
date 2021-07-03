package com.ysu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysu.entity.UserGroup;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author keg
 * @since 2021-05-13
 */
public interface UserGroupMapper extends BaseMapper<UserGroup> {

    List<UserGroup> list();

    List<UserGroup> getUserGroup();
}
