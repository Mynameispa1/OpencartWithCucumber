Feature: Check the prodcut add into cart

  @Sanity, @Master
  Scenario: Add prdocut to cart
    Given open the url in browser
    And Enter the email id "pavan999@gmail.com"
    Then Enter the password "test@123"
    Then click on the login button
    Then click on the product tablet
    And click Add to cart
    Then chck the product add confirmation
    And close the browser
