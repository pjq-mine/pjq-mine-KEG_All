package com.ysu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ysu.entity.Accountbook;
import com.ysu.entity.page.PageListRes;
import com.ysu.entity.page.QueryVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author keg
 * @since 2021-05-23
 */
public interface AccountbookService extends IService<Accountbook> {
    PageListRes AccountbookList(QueryVo vo);

    void deleteAccountbook(Long ids);

    void insertAccount(Accountbook accountbook);
}
