#Explanation
#Feature File: The feature file outlines the scenario where the program iterates over users 1 to 5, checks that button1 is present, and verifies that button2 is not present for any of the users.
 # Step Definitions:
  # i_have_the_following_users:
  # Populates a HashMap with the usernames from the feature file. For simplicity,
  # it assumes all users have the same password.
  # i_login_with_each_user: Iterates over each user in the HashMap,
  # logs in, and checks for the presence of button1 and the absence of button2.

Feature: Login to the page and check button presence for multiple users

  Scenario: Check button1 is present and button2 is not present for users 1 to 5
    Given I have the following users
      | username |
      | user1    |
      | user2    |
      | user3    |
      | user4    |
      | user5    |
    When I login with each user
    Then I should see button1
    And I should not see button2
