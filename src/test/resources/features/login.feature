Feature: Login to the page with multiple users and check button

  Scenario Outline: Login with valid credentials and check the button
    Given I am on the login page
    When I login with username "<username>" and password "<password>"
    Then I should see the button with id "<buttonId1>"

    Examples:
      | username   | password   | buttonId    |
      | user1      | pass1      | button1     |
      | user2      | pass2      | button2   |
      | user3      | pass3      | button3    |

