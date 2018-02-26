package com.talan.sou.demo.controller;


import com.talan.sou.demo.domain.Op;
import com.talan.sou.demo.domain.Operation;
import com.talan.sou.demo.service.OperationService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(OperationController.class)
public class OperationControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private OperationService service;

    @Test
    public void getListOps() throws Exception {
        List<Operation> listOps = Arrays.asList(new Operation(1,2,500, LocalDate.now(), Op.TRANSFER));
        given(service.getListOpsPerAccount(1)).willReturn(listOps);

        mvc.perform(get("/operations/{uid}",1).
                contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].amount",is(500)));


    }

}