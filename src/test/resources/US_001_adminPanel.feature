Feature: US_001 Admin Login Panel

  Background:
    Given I navigate to the admin panel page

  Scenario: TC_01 User login to admin panel with a valid log in details
    When I enter valid "adminUsername" and "adminPassword"
    Then I log into the panel
    And  The "B&B Booking Management" is displayed
    When I can Logout from the page
    Then Login button is displayed
    And  I closed the page

  Scenario Outline: TC_02 User should be unable to login to admin panel with an invalid log in details
    When I enter invalid "<username>" and "<password>"
    Then I click the login
    Then The login should be displayed
    And  I closed the page

    Examples:
      | username  | password |
      | admin     | 12345    |
      | admin1123 | password |
      | faskhf    | hdka567  |
      |           | password |
      | admin     |          |
      |           |          |