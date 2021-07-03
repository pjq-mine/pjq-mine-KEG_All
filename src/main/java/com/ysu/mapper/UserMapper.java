package com.ysu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysu.entity.User;
import com.ysu.entity.page.QueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author keg
 * @since 2021-05-05
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> userList(QueryVo vo);

    void updateStatus(int status, List<Long> ids);

    void deleteUsers(List<Long> ids);

    void insertUser(@Param("user")User user,@Param("gId") int gId,@Param("rId") int rId);

    List<User> getUserInfo();
}
