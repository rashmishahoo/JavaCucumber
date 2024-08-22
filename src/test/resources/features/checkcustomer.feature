Feature: Login to the page and check button presence for different users

  Scenario Outline: Login with valid credentials of a customer and check buttons
    Given I am on the login page
    When I login with username "<username>" and password "<password>"
    Then I should see the button1
    And I should see the button2 only if I am user2

    Examples:
      | username   | password   |
      | user1      | pass1      |
      | user2      | pass2      |
