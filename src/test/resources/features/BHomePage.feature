@homePage
Feature: Home page functionality of Movies application

  Background:
    Given User is on the home page of the Movies application

  Scenario: Verify navigation bar elements on the home page
    Then User should see the navigation bar
    And Navigation bar should contain the homepage logo
    And Navigation bar should contain links to other pages of the application
    And Navigation bar should contain the search button
    And Navigation bar should contain the user profile icon

  Scenario: Verify home movie container on the home page
    Then home movie container should contain a movie title
    And home movie container should contain a movie description
    And home movie container should contain a play button

  Scenario: Verify trending now section on the home page
    Then Trending Now section should have a heading
    And Trending Now section should display a list of movies

  Scenario: Verify Originals section on the home page
    Then Originals section should have a heading
    And Originals section should display a list of movies


  Scenario: Verify search button on the home page
    And search for a movie using search button
    Then search result should be displayed