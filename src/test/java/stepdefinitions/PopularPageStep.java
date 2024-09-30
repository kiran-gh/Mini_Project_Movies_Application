package stepdefinitions;

import hooks.hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.PopularPage;
import utility.ConfigReader;

import java.time.Duration;
import java.util.Properties;

public class PopularPageStep {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HomePage homePage;
    PopularPage popularPage;
    Properties properties;

    public PopularPageStep(){
        this.driver = hooks.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        ConfigReader configReader = new ConfigReader();
        properties = configReader.init_prop();
        loginPage = new LoginPage(driver);
        loginPage.successfulLogin(properties.getProperty("userName"), properties.getProperty("password"));
        homePage = new HomePage(driver);
        homePage.popularPageUrl();
        popularPage = new PopularPage(driver);
    }


    @Given("User is on popular page")
    public void user_is_on_popular_page() {
        wait.until(ExpectedConditions.urlToBe(properties.getProperty("popularPageUrl")));
        Assert.assertEquals(driver.getCurrentUrl(), properties.getProperty("popularPageUrl"));
    }

    @Then("user should see the popular movies list")
    public void userShouldSeeThePopularMoviesList() {
        Assert.assertTrue(popularPage.moviesList());
    }

//    @When("user clicks on any movie banner from the popular movies list")
//    public void userClicksOnAnyMovieBannerFromThePopularMoviesList() {
//        popularPage.clickOnAMovie();
//    }
//
//    @Then("user should be navigated to the movie details page")
//    public void userShouldBeNavigatedToTheMovieDetailsPage() {
//        Assert.assertTrue(popularPage.isMoviePageLoaded());
//    }
//
//    @And("user should see the movie title")
//    public void userShouldSeeTheMovieTitle() {
//        Assert.assertTrue(popularPage.movieTitle.isDisplayed());
//    }
//
//
//
//    @And("user should see the watch-time, rating and release year of the movie")
//    public void userShouldSeeTheWatchTimeRatingAndReleaseYearOfTheMovie() {
//        Assert.assertTrue(popularPage.isMovieReviewContainerDisplaying());
//    }
//
//    @And("user should see the watch-time, rating and release year of the movie along with overview and play button")
//    public void userShouldSeeTheWatchTimeRatingAndReleaseYearOfTheMovieAlongWithOverviewAndPlayButton() {
//    }
}