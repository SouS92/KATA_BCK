package com.talan.sou.demo.tdd.service;

import com.talan.sou.demo.domain.Account;
import com.talan.sou.demo.domain.Op;
import com.talan.sou.demo.domain.Operation;
import com.talan.sou.demo.repository.AccountRepository;
import com.talan.sou.demo.repository.OperationsRepository;
import com.talan.sou.demo.service.AccountService;
import com.talan.sou.demo.service.OperationService;
import com.talan.sou.demo.service.impl.AccountServiceImp;
import com.talan.sou.demo.service.impl.OperationServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OperationServiceImpTest {

    @TestConfiguration
    static class OperationServiceImpTestConfiguration {

        @Bean
        public OperationService operationService(){
            return new OperationServiceImp();
        }

        @Bean
        public AccountService accountService(){
            return new AccountServiceImp();
        }
    }
    @Autowired
    public OperationService operationService;


    @Autowired
    public AccountService accountService;

    @Test
    public void getListOpsPerAccount() throws Exception {

        //Prepare Mockito
        Account account = new Account("firstAccount",1200);
        accountService.insertNewAccount(account);
        //End Mockito

        account = accountService.getAccountByName("firstAccount");
        operationService.accountOp(account.getAccountUID(),Op.WITHDRAW,200);
        operationService.accountOp(account.getAccountUID(),Op.WITHDRAW,200);


        assertThat(operationService.getListOpsPerAccount(account.getAccountUID()).size(),is(2));
    }

    @Test
    public void accountOp() throws Exception {

        //Prepare Mockito
        Account account = new Account("firstAccount",1200);
        accountService.insertNewAccount(account);
        //End Mockito

        account = accountService.getAccountByName("firstAccount");

        Operation op = new Operation();
        op.setFromAccountName("--");
        op.setFromAccount(0);
        op.setAmount(1000);
        op.setOp(Op.DEPOSIT);
        op.setToAccount(account.getAccountUID());
        op.setToAccountName(account.getAccountName());
        op.setDateOp(LocalDate.now());

        operationService.accountOp(op.getToAccount(),op.getOp(),op.getAmount());
        assertThat(account.getBalance(),is(2200L));
    }

    @Test
    public void transferOp() throws Exception {

        //Prepare Mockito
        Account account = new Account("firstAccount",1200);
        Account secondAccount = new Account("secondAccount",3200);
        accountService.insertNewAccounts(Arrays.asList(account,secondAccount));
        //End Mockito

        operationService.transferOp(account.getAccountUID(),secondAccount.getAccountUID(),200);
        account = accountService.getAccountByName("firstAccount");
        secondAccount = accountService.getAccountByName("secondAccount");



        assertThat(account.getBalance(),is(1000L));
        assertThat(secondAccount.getBalance(),is(3400L));

    }

}