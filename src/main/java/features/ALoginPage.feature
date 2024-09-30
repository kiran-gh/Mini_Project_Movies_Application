@loginPage
Feature: Login Page functionality of MoviesApp
  As a registered user I am able to login to the Movies application using valid credentials.
  Background:
    Given User is on Movies application login page.


  Scenario: Login with valid credentials
    When the user enters username and password
    And clicks on the login button
    Then the user should be redirected to the home page of the movies application

  Scenario Outline: Login with invalid credentials
    When the user enters "<username>" and "<password>"
    And clicks on the login button
    Then User should see an error message "<errorMessage>"

    Examples:
      | username| password    | errorMessage                        |
      | rahull  | rahul@2022  | *invalid username                   |
      | rahul   | rahul@2022  | *username and password didn't match |
      | rahull  | rahul@2021  | *invalid username                   |
      | rahul   |             | *Username or password is invalid    |
      |         | rahul@2021  | *Username or password is invalid    |
      |         |             | *Username or password is invalid    |