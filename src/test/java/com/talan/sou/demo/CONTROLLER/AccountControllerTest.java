package com.talan.sou.demo.CONTROLLER;

import com.talan.sou.demo.DV.DvHistory;
import com.talan.sou.demo.SERVICE.INTERFACE.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AccountService service;

    @Test
    public void whenListOps_thenReturnJsonArray() throws  Exception{

        List<DvHistory> list = service.getListOpsPerAccount(1);
        given(service.getListOpsPerAccount(1)).willReturn(list);


    }

}
