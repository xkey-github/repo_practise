package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

public interface IAccountService {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 保存账户
     * @param account
     */
    void saveAccount(Account account);
}
