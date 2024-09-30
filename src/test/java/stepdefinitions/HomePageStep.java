package stepdefinitions;

import hooks.hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utility.ConfigReader;

import java.time.Duration;
import java.util.Properties;

public class HomePageStep {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HomePage homePage;
    Properties properties;

    public HomePageStep(){
        this.driver = hooks.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        ConfigReader configReader = new ConfigReader();
        properties = configReader.init_prop();
        loginPage = new LoginPage(driver);
        loginPage.successfulLogin(properties.getProperty("userName"), properties.getProperty("password"));
        homePage = new HomePage(driver);
    }



    @Given("User is on the home page of the Movies application")
    public void user_is_on_the_home_page_of_the_movies_application() {
        wait.until(ExpectedConditions.urlToBe(properties.getProperty("homePageUrl")));
        Assert.assertEquals(driver.getCurrentUrl(),properties.getProperty("homePageUrl"));
    }

    @Then("User should see the navigation bar")
    public void user_should_see_the_navigation_bar() {
        Assert.assertTrue(homePage.isNavBarLinksDisplayed());
    }

    @And("Navigation bar should contain the homepage logo")
    public void navigation_bar_should_contain_the_homepage_logo() {
        Assert.assertTrue(homePage.isHomePageLogoDisplayed());
    }

    @And("Navigation bar should contain links to other pages of the application")
    public void navigation_bar_should_contain_links_to_other_pages_of_the_application() {
        Assert.assertTrue(homePage.popularLink.isDisplayed());
        Assert.assertTrue(homePage.homePageLink.isDisplayed());
        Assert.assertTrue(homePage.avatarButton.isDisplayed());
    }

    @And("Navigation bar should contain the search button")
    public void navigation_bar_should_contain_the_search_button() {
        Assert.assertTrue(homePage.isSearchEmptyButtonDisplayed());
    }

    @And("Navigation bar should contain the user profile icon")
    public void navigation_bar_should_contain_the_user_profile_icon() {
        Assert.assertTrue(homePage.avatarButton.isDisplayed());
    }

    @And("home movie container should contain a movie title")
    public void home_movie_container_should_contain_a_movie_title() {
        Assert.assertTrue(homePage.isHomePageHeadingDisplayed());
    }

    @And("home movie container should contain a movie description")
    public void home_movie_container_should_contain_a_movie_description() {
        Assert.assertTrue(homePage.isHomePageDescriptionDisplayed());
    }

    @And("home movie container should contain a play button")
    public void home_movie_container_should_contain_a_play_button() {
        Assert.assertTrue(homePage.isHomePagePlayButtonDisplayed());
    }

    @And("Trending Now section should have a heading")
    public void trending_now_section_should_have_a_heading() {
        Assert.assertTrue(homePage.isTrendingNowHeadingDisplayed());
    }

    @Then("Originals section should have a heading")
    public void originalsSectionShouldHaveAHeading() {
        Assert.assertTrue(homePage.isOriginalsHeadingDisplayed());
    }

    @And("Originals section should display a list of movies")
    public void originalsSectionShouldDisplayAListOfMovies() throws InterruptedException {
        Assert.assertTrue(homePage.isMoviesDisplayingUnderOriginalSection());
    }

    @And("Trending Now section should display a list of movies")
    public void trending_now_section_should_display_a_list_of_movies() throws InterruptedException {
        Assert.assertTrue(homePage. isMoviesDisplayingUnderTrendingSection());
    }

    @And("search for a movie using search button")
    public void searchForAMovieUsingSearchButton() {
        homePage.movieSearch();
    }

    @Then("search result should be displayed")
    public void searchResultShouldBeDisplayed() {
        Assert.assertTrue(homePage.isSearchMovieDisplayed());
    }
}