package com.ysu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysu.entity.Accountbook;
import com.ysu.entity.page.QueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author keg
 * @since 2021-05-23
 */
@Repository
public interface AccountbookMapper extends BaseMapper<Accountbook> {

    List<Accountbook>  AccountbookList(QueryVo vo);

    void deleteAccountbook(Long ids);

    void insertAccount(Accountbook accountbook);
}
