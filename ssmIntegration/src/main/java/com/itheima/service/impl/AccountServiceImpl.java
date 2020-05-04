package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    /**
     * 查询所有账户
     * @return
     */
    @Override
    public List<Account> findAll() {
        System.out.println("service中执行了查询所有账户...");
        List<Account> accounts = accountDao.findAll();
        return accounts;
    }

    /**
     * 保存账户
     * @param account
     */
    @Override
    public void saveAccount(Account account) {
        System.out.println("service中执行了保存...");
        accountDao.saveAccount(account);
    }
}
