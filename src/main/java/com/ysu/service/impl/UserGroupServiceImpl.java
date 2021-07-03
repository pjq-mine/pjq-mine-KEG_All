package com.ysu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysu.entity.UserGroup;
import com.ysu.mapper.UserGroupMapper;
import com.ysu.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author keg
 * @since 2021-05-13
 */
@Service
public class UserGroupServiceImpl extends ServiceImpl<UserGroupMapper, UserGroup> implements UserGroupService {
    @Autowired
    private UserGroupMapper userGroupMapper;

    @Override
    public List<UserGroup> list() {
        return userGroupMapper.list();
    }

    @Override
    public List<UserGroup> getUserGroup() {
        return userGroupMapper.getUserGroup();
    }
}
