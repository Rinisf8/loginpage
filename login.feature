Feature: Login Swag Labs

  Scenario: Login Success
    Given login page swag labs
    When user input username
    And user input password
    And click login button
    Then user in on dashboard page

  Scenario: Failed Login
    Given login page swag labs
    When user input username
    And user input invalid password
    And click login button
    Then user get error message




