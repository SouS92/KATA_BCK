Feature: Inserting new Account
  User should be able to submit POST request to insert an account

  Scenario: Should be able to create a new account
    Given I am on the add_account page
    And I fill in "accountName with "firstAccount"
    And I fill in "balance" with 1200
    When I press "Create Account"
    Then I should see "Account was successfully created."


    Scenario Outline:
      Given I am on the add_account page
      And I fill in "accountName with <accountName>
      And I fill in "balance" with <balance>
      When I press "Create Account"
      Then I should see "Account was successfully created."
      Examples:
        |accountName  | balance|
        | firstAccount|  1350  |