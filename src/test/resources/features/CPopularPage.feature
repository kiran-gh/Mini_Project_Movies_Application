@popularPage
Feature: Popular Page functionality of MoviesApp



  Scenario: Verify that the user can view the popular movies
    Given User is on popular page
    Then user should see the popular movies list