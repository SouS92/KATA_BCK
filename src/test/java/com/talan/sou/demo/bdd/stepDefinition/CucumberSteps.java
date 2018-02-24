package com.talan.sou.demo.bdd.stepDefinition;

import com.talan.sou.demo.domain.Account;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class CucumberSteps {

    Account account;
    String resourceUrl = "http://localhost:8080/accounts";
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity res;
    List<Account> listOfAccounts;
    @Given("^I am on the add_account page$")
    public void i_am_on_the_add_account_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        account = new Account();
    }


    @Given("^I fill in accountName with \"([^\"]*)\"$")
    public void i_fill_in_accountName_with(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        account.setAccountName(arg1);
    }

    @Given("^I fill in balance with (\\d+)$")
    public void i_fill_in_balance_with(int arg1) throws Throwable {
       account.setBalance(arg1);
    }

    @When("^I press \"([^\"]*)\"$")
    public void i_press(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        HttpEntity<Account> request = new HttpEntity<>(account);
        res = restTemplate.postForEntity(resourceUrl,request,Account.class);
    }

    @Then("^I will get \"([^\"]*)\"$")
    public void i_will_get(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertThat(res.getStatusCode(),equalTo(HttpStatus.OK));
    }

    @When("^I open main page$")
    public void i_open_main_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        listOfAccounts = new ArrayList<>();
    }

    @Then("^I will get all accounts$")
    public void i_will_get_all_accounts() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ResponseEntity<List<Account>> rateResponse =
                restTemplate.exchange(resourceUrl,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Account>>() {
                        });

        listOfAccounts = rateResponse.getBody();
        assertTrue(listOfAccounts.size() > 0);
    }


}
