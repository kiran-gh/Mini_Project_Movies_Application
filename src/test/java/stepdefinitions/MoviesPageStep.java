package stepdefinitions;

import hooks.hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.MoviesPage;
import pages.PopularPage;
import utility.ConfigReader;

import java.time.Duration;
import java.util.Properties;

public class MoviesPageStep {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HomePage homePage;
    PopularPage popularPage;
    MoviesPage moviesPage;
    Properties properties;

    public MoviesPageStep() {
        this.driver = hooks.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        ConfigReader configReader = new ConfigReader();
        properties = configReader.init_prop();
        loginPage = new LoginPage(driver);
        loginPage.successfulLogin(properties.getProperty("userName"), properties.getProperty("password"));
        homePage = new HomePage(driver);
        homePage.popularPageUrl();
        popularPage = new PopularPage(driver);
        moviesPage = new MoviesPage(driver);
    }


    @When("user clicks on any movie banner from the popular movies list will be directed to movie page")
    public void user_clicks_on_any_movie_banner_from_the_popular_movies_list_will_be_directed_to_movie_page() {
        moviesPage.clickOnAMovie();
    }
    @Then("user should see the movie title in movie page")
    public void user_should_see_the_movie_title_in_movie_page() {
        wait.until(ExpectedConditions.visibilityOf(moviesPage.movieTitle));
        Assert.assertTrue(moviesPage.movieTitle.isDisplayed());
    }
    @And("user should see the watch-time, rating and release year of the movie along with overview and play button")
    public void user_should_see_the_watch_time_rating_and_release_year_of_the_movie_along_with_overview_and_play_button() {
      Assert.assertTrue(moviesPage.isMovieReviewContainerDisplaying());
    }
}