package com.talan.sou.demo.service.impl;

import com.talan.sou.demo.domain.Account;
import com.talan.sou.demo.repository.AccountRepository;
import com.talan.sou.demo.service.AccountService;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountServiceImpTest {

    @Captor
    ArgumentCaptor<Account> captor;

    @Captor
    ArgumentCaptor<List<Account>> captorList;

    @InjectMocks
    public AccountService accountService = new AccountServiceImp();


    @Mock
    private AccountRepository accountRepository;

    @BeforeClass
    public static void setUp() {
        MockitoAnnotations.initMocks(AccountServiceImpTest.class);
    }

    @Test
    public void should_insert_new_account(){


        //Prepare Mockito
        Account account = new Account("firstAccount",1200);
        Mockito.when(accountRepository.save(any(Account.class))).thenReturn(any(Account.class));
        //End Mockito

        accountService.insertNewAccount(account);
        verify(accountRepository,times(1)).save(captor.capture());
        assertThat(captor.getValue().getAccountName(),is(account.getAccountName()));
    }

    @Test
    public void should_insert_new_accounts() {

        //Prepare Mockito
        Account account = new Account("firstAccount",1200);
        Account secondAccount = new Account("firstAccount",1200);
        List<Account> listAccounts = Arrays.asList(account,secondAccount);
        Mockito.when(accountRepository.save(anyListOf(Account.class))).thenReturn(anyListOf(Account.class));
        //End Mockito


        accountService.insertNewAccounts(listAccounts);
        verify(accountRepository,times(1)).save(captorList.capture());
        Assert.assertEquals(captorList.getValue().size(),2);
    }


    @Test
    public void return_all_accounts_list() {

        Account account = new Account("firstAccount",1200);
        account.setAccountUID(99);
        Account secondAccount = new Account("secondAccount",8937);
        secondAccount.setAccountUID(1);

        List<Account> listAccounts= Arrays.asList(account,secondAccount);
        Mockito.when(accountService.getAccounts()).thenReturn(listAccounts);


        List<Account> listOfAccounts = accountService.getAccounts();
        assertThat(listOfAccounts.size(),is(2));
    }

    @Test
    public void should_return_account_by_nameTest() {

        //Mocking
        Account account = new Account("firstAccount",1200);
        account.setAccountUID(99);
        Mockito.when(accountService.getAccountByName(account.getAccountName())).thenReturn(account);
        //End Mocking

        String name = "firstAccount";
        Account found = accountService.getAccountByName(name);
        assertThat(found.getAccountName(),is(name));

    }

    @Test
    public void should_return_account_by_uid() {

        //Mocking
        Account account = new Account("firstAccount",1200);
        account.setAccountUID(99);
        Mockito.when(accountService.getAccountByUID(account.getAccountUID())).thenReturn(account);
        //End Mocking


        Account secondAccount = accountService.getAccountByUID(99);
        assertThat(secondAccount.getAccountUID(),is(99L));
    }

}