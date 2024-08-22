Feature: Login to the page with multiple users and check respective buttons

  Scenario Outline: Login with valid credentials and check respective buttons
    Given I am on the login page
    When I login with username "<username>" and password "<password>"
    Then I should see the button with id "<buttonId>"

  Examples:
    | username   | password   | buttonId    |
    | user1      | pass1      | button1     |
    | user1      | pass1      | button2     |
    | user2      | pass2      | button1     |
    | user2      | pass2      | button2     |