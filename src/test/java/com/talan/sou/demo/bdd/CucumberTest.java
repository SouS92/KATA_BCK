package com.talan.sou.demo.bdd;

import com.talan.sou.demo.BankAccountsApplication;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:feature",
                 plugin ={"pretty","html:src/test/java/com/talan/sou/demo/bdd/htmlReports"})

@ContextConfiguration(
        classes = BankAccountsApplication.class,
        loader = SpringBootContextLoader.class)
@WebAppConfiguration
@SpringBootTest
public class CucumberTest  {
}
