Feature: User Login

  Scenario: Successful login valid credential
    Given User di halaman login
    When write valid username and password
    And submit button ditekan
    Then arrive at page inventory