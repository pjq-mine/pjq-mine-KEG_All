package com.ysu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ysu.entity.Accountbook;
import com.ysu.entity.page.PageListRes;
import com.ysu.entity.page.QueryVo;
import com.ysu.service.AccountbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author keg
 * @since 2021-05-23
 */
@Service
public class AccountbookServiceImpl extends ServiceImpl<com.ysu.mapper.AccountbookMapper, Accountbook> implements AccountbookService {
    @Autowired
    private com.ysu.mapper.AccountbookMapper AccountbookMapper;

    @Override
    public PageListRes AccountbookList(QueryVo vo) {

        System.out.println(vo.getCurr());
        System.out.println(vo.getLimit());
        System.out.println(vo.getKeyword());
        System.out.println(vo.getStatus());

        Page<Object> page = PageHelper.startPage(vo.getCurr(), vo.getLimit());

        List<Accountbook> AccountbookList = AccountbookMapper.AccountbookList(vo);

        PageListRes pageListRes = new PageListRes();

        pageListRes.setTotal(page.getTotal());
        pageListRes.setRows(AccountbookList);

        return pageListRes;
    }

    @Override
    public void deleteAccountbook(Long ids) {
        AccountbookMapper.deleteAccountbook(ids);
    }

    @Override
    public void insertAccount(Accountbook accountbook) {
        AccountbookMapper.insertAccount(accountbook);
    }

}
