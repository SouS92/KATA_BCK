package com.talan.sou.demo;

import com.talan.sou.demo.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankAccountsApplicationTests {

	@Autowired
	private AccountRepository accountRepository;

	@Test
	public void contextLoads() {
	}

}