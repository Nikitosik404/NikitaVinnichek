Feature: Home Page Test

  Scenario: Home Page interface test
    Given I'm on the Home Page
    Then The browser title is Home Page
    When I login as user epam with password 1234
    Then The user icon is displayed on the header