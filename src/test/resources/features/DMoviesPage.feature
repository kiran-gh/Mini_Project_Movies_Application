@moviesPage

  Feature: Movies Page functionality of MoviesApp


    Scenario: When user clicks on any particular movie, it should navigate to the movie details page
      When user clicks on any movie banner from the popular movies list will be directed to movie page
      Then user should see the movie title in movie page
      And user should see the watch-time, rating and release year of the movie along with overview and play button