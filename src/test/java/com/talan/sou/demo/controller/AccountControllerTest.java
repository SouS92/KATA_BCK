package com.talan.sou.demo.controller;

import com.talan.sou.demo.domain.Account;
import com.talan.sou.demo.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AccountService service;



    @Test
    public void return_accounts_list() throws Exception {

        Account account = new Account();
        account.setBalance(1000);
        account.setAccountName("firstAccount");
        account.setAccountUID(1);

        given(service.getAccounts()).willReturn(Arrays.asList(account));

        mvc.perform(get("/accounts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
    @Test
    public void insert_new_account() throws Exception {

        Account account = new Account();
        account.setBalance(1000);
        account.setAccountName("firstAccount");
        account.setAccountUID(1);

        doNothing().when(service).insertNewAccount(account);

        mvc.perform(post("/accounts"));


    }

}