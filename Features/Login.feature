Feature: Check the login feature of the application

  Background: Commom steps for all scenario
    Given open the url in browser

  @Sanity
  Scenario: Logging into thr application
    And Enter the email id "pavan999@gmail.com"
    Then Enter the password "test@123"
    Then click on the login button
    Then check the my account page is displayed or not
    And close the browser

  @Regression, @Master
  Scenario Outline: Login with multiple data
    And Enter the email id "<emailid>"
    Then Enter the password "<password>"
    Then click on the login button
    Then check the my account page is displayed or not
    And close the browser

    Examples: 
      | emailid            | password |
      | pavan999@gmail.com | test@123 |
      | pavan145@gmail.com | abc@123  |
