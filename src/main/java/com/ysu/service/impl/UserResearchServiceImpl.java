package com.ysu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysu.entity.UserResearch;
import com.ysu.mapper.UserResearchMapper;
import com.ysu.service.UserResearchService;
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
public class UserResearchServiceImpl extends ServiceImpl<UserResearchMapper, UserResearch> implements UserResearchService {
    @Autowired
    private UserResearchMapper userResearchMapper;
    
    @Override
    public List<UserResearch> userResearchList() {
        return userResearchMapper.userResearchList();
    }

    @Override
    public List<UserResearch> getUserResearch() {
        return userResearchMapper.getUserResearch();
    }
}
