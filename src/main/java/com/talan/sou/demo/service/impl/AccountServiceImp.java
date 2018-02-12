package com.talan.sou.demo.service.impl;


import com.talan.sou.demo.domain.Account;
import com.talan.sou.demo.domain.Op;
import com.talan.sou.demo.domain.Operation;
import com.talan.sou.demo.repository.AccountRepository;
import com.talan.sou.demo.repository.OperationsRepository;
import com.talan.sou.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

   @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();

    }

    @Override
    public Account getAccountByName(String name) {
        return accountRepository.findByAccountName(name);
    }

    @Override
    public Account getAccountByUID(long uid) {
        return accountRepository.findByAccountUID(uid);

    }

    @Override
    public void insertNewAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void insertNewAccounts(List<Account> accounts) {
        accountRepository.save(accounts);
    }





}
