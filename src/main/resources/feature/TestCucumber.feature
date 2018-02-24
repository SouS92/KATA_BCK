Feature: Inserting new Account
  User should be able to submit POST request to insert an account
  User should be able to retrieve all accounts

  Scenario: Should be able to create a new account
    Given I am on the add_account page
    And I fill in accountName with "firstAccount"
    And I fill in balance with 1200
    When I press "Create Account"
    Then I will get "Message Ok"

  Scenario: shout be able to retrieve all accounts
    When I open main page
    Then I will get all accounts


  Scenario Outline: Should be able to create a new account w/ examples
    Given I am on the add_account page
    And I fill in accountName with <accountName>
    And I fill in balance with <balance>
    When I press "Create Account"
    Then I will get "Message Ok"
    Examples:
      | accountName    | balance|
      | "firstAccount" |  1350  |