package com.talan.sou.demo.controller;


import com.talan.sou.demo.domain.Account;
import com.talan.sou.demo.domain.Operation;
import com.talan.sou.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/accounts")
    public List<Account> getAccounts(){
        return accountService.getAccounts();
    }

    @RequestMapping(value = "/accounts",method = RequestMethod.POST)
    public void saveAccount(@RequestBody Account account){
        accountService.insertNewAccount(new Account(account.getAccountName(),account.getBalance()));
    }

}
