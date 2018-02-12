package com.talan.sou.demo.service;

import com.talan.sou.demo.domain.Account;
import com.talan.sou.demo.domain.Op;
import com.talan.sou.demo.domain.Operation;

import java.util.List;


public interface AccountService {

    List<Account> getAccounts();
    Account getAccountByName(String name);
    Account getAccountByUID(long uid);
    void insertNewAccount(Account account);
    void insertNewAccounts(List<Account> account);

}
