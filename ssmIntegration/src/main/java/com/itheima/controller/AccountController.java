package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    /**
     * 查询所有账户
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("controller中的查询所有账户执行了...");
        List<Account> accounts = accountService.findAll();
        model.addAttribute("list",accounts);
        return "success";
    }

    /**
     * 测试保存账户
     * @param request
     * @param response
     * @param account
     * @throws IOException
     */
    @RequestMapping("/saveAccount")
    public void saveAccount(HttpServletRequest request, HttpServletResponse response, Account account) throws IOException {
        accountService.saveAccount(account);
        //保存成功跳转至成功页面
        response.sendRedirect(request.getContextPath()+"/account/findAll");
    }
}
