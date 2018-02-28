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

    /** Récupérer tous les comptes stockés dans la BD
     * @return Liste de comptes
     */
   @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();

    }

    /** Récupérer un compte avec le nom
     * @param name String
     * @return compte spécifique
     *
     */
    @Override
    public Account getAccountByName(String name) {
        return accountRepository.findByAccountName(name);
    }

    /** Récupérer un compte avec son uid
     * @param uid long
     * @return compte spécifique
     *
     */
    @Override
    public Account getAccountByUID(long uid) {
        return accountRepository.findByAccountUID(uid);

    }

    /** insérer un nouveau compte
     * @param account nouveau compte
     *
     */
    @Override
    public void insertNewAccount(Account account) {
        accountRepository.save(account);
    }

    /** insérer plusieurs comptes en même temps
     * @param accounts liste de nouveaux comptes
     *
     */
    @Override
    public void insertNewAccounts(List<Account> accounts) {
        accountRepository.save(accounts);
    }





}
