Feature: US_002 Contact Page

  Background:
    Given I navigate to the given url

  Scenario: TC_01 Send a Valid contact request
    Given I enter valid contact request details
    When  I submit the request
    Then  the "We'll get back to you about" message is displayed
    And   I closed the page

  Scenario Outline: TC_02 Send an invalid contact request
    Given I enter invalid contact request details with missing "<field>"
    When  I submit the request
    Then  the "<message>" message is displayed below
    And   I closed the page
    Examples:
      | field          | message                  |
      | contactName    | Name may not be blank    |
      | contactEmail   | Email may not be blank   |
      | contactPhone   | Phone may not be blank   |
      | contactSubject | Subject may not be blank |
      | contactMessage | Message may not be blank |

  Scenario Outline: TC_03 Check expected email format
    Given I enter invalid "<email>" format
    Then  I submit the request
    Then  the "<message>" is displayed
    And   I closed the page
    Examples:
      | email               | message                             |
      | sedayalcingmail.com | must be a well-formed email address |
      | sedayalcin@gmailcom | must be a well-formed email address |

  Scenario:TC_04 Check the visibility of hotel contact details
    Then the contact details of hotel are displayed
    And  I closed the page
