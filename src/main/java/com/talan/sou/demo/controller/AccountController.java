package com.talan.sou.demo.controller;

import com.talan.sou.demo.domain.Account;
import com.talan.sou.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;


    @RequestMapping(value = "/accounts",method = RequestMethod.GET)
    public List<Account> getAccounts(){
        return accountService.getAccounts();
    }

    @RequestMapping(value = "/accounts",method = RequestMethod.POST)
    public void insertAccount(@RequestBody Account account){
        accountService.insertNewAccount(account);
    }
}
