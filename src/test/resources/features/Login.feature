Feature: Login scenarios to be tested

  Scenario: Login positive flow
    Given application is launched
    When username is entered as "rajkumar@testleaf.com"
    And password is entered as "Leaf@123"
    And login button is clicked
    Then Verify home page is displayed

  Scenario: Login negative flow
    Given application is launched
    When username is entered as "lokesh@testleaf.com"
    And password is entered as "Leaf@123"
    And login button is clicked
    Then Verify login page is displayed