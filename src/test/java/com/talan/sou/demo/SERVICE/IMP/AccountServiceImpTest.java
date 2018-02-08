package com.talan.sou.demo.SERVICE.IMP;

import com.talan.sou.demo.DV.DvAccount;
import com.talan.sou.demo.REPO.AccountRepository;
import com.talan.sou.demo.SERVICE.INTERFACE.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountServiceImpTest {

    @TestConfiguration
    static class AccountServiceImplTestContextConfiguration {

        @Bean
        public AccountService employeeService() {
            return new AccountServiceImp();
        }
    }

    @Autowired
    private AccountService accountService;
    @Test
    public void getAccounts() throws Exception {
        accountService.insertNewAccount(new DvAccount(0,"account1",1000));
        accountService.insertNewAccount(new DvAccount(0,"account2",1800));
        accountService.insertNewAccount(new DvAccount(0,"account3",4000));
        System.out.println(accountService.getAccounts().size());
        assertTrue(accountService.getAccounts().size() > 0);
    }

    @Test
    public void getAccountByName() throws Exception {
        accountService.insertNewAccount(new DvAccount(0,"account1",1000));
        System.out.println(accountService.getAccountByName("account1").getNameAccount());
        assertTrue(accountService.getAccountByName("account1").getNameAccount().equals("account1"));
    }

    @Test
    public void getAccountByUID() throws Exception {
        accountService.insertNewAccount(new DvAccount(0,"account1",1000));
        assertTrue(accountService.getAccountByName("account1").getId() > 0);
    }

}