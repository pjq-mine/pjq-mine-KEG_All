package com.ysu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysu.entity.User;
import com.ysu.entity.page.PageListRes;
import com.ysu.entity.page.QueryVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author keg
 * @since 2021-05-05
 */
public interface UserService extends IService<User> {

    PageListRes userList(QueryVo vo);

    void updateStatus(int status, List<Long> ids);

    void deleteUsers(List<Long> ids);

    void insertUser(User user, int gId, int rId);

    List<User> getUserInfo();
}
