package com.ysu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ysu.entity.User;
import com.ysu.entity.page.PageListRes;
import com.ysu.entity.page.QueryVo;
import com.ysu.mapper.UserMapper;
import com.ysu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author keg
 * @since 2021-05-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageListRes userList(QueryVo vo) {
        System.out.println(vo.getCurr());
        System.out.println(vo.getLimit());
        System.out.println(vo.getKeyword());
        System.out.println(vo.getStatus());
        Page<Object> page = PageHelper.startPage(vo.getCurr(), vo.getLimit());
        List<User> userList = userMapper.userList(vo);
//        System.out.println(userList);
        /*封装成pageList*/
        PageListRes pageListRes = new PageListRes();
        pageListRes.setTotal(page.getTotal());
        pageListRes.setRows(userList);
        return pageListRes;
    }

    @Override
    public void updateStatus(int status, List<Long> ids) {
        userMapper.updateStatus(status, ids);
    }

    @Override
    public void deleteUsers(List<Long> ids) {
        userMapper.deleteUsers(ids);
    }

    @Override
    public void insertUser(User user, int gId, int rId) {
        userMapper.insertUser(user, gId, rId);
    }

    @Override
    public List<User> getUserInfo() {
        return userMapper.getUserInfo();
    }
}
