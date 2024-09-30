@accountsPage

Feature: Manage Account on MoviesApp

  As a user of MoviesApp,
  I want to view my account details and membership information,
  So that I can manage my account and membership easily.

  Scenario: Viewing account page information and functionality
    Given the user is on the Accounts page
    Then the user should see the account heading displayed
    And the membership section containing the username and password fields should be visible
    And the plan details section should display the user's plan information
    And the page should end with a visible Logout button