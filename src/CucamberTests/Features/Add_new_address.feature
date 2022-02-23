Feature: Adding address to user
  Scenario Outline: As a not registered user login and add address
    Given user is on Sing in page
    When user entered "<email>","<password>" and click sing in button
    And user click at the ADD FIRST ADDRESS button
    And user entered "<alias>", "<address>", "<PostalCode>", "<city>", "<country>", "<phone>" click SAVE button
    Then user is on Your addresses site added address is visible "<alias>", "<address>", "<PostalCode>", "<city>", "<country>", "<phone>"
    And user click delete
    And added address disappear


    Examples:
      |email                       |password|alias|address      |PostalCode|city      |country       |phone    |
      |ffgizcyofqgrmyixeg@nthrw.com|roman   |Pan  |Romantyczna  |22-220    |Lublin    |United Kingdom|888888888|
