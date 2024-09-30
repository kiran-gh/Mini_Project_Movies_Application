package stepdefinitions;

import hooks.hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import pages.LoginPage;
import utility.ConfigReader;

import java.time.Duration;
import java.util.Properties;

public class LoginPageStep {
    WebDriver driver;
    public WebDriverWait wait;
    LoginPage loginPage;
    Properties properties;

    public LoginPageStep() {
        this.driver = hooks.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        ConfigReader configReader = new ConfigReader();
        properties = configReader.init_prop();
        loginPage = new LoginPage(driver);
    }

    @Given("User is on Movies application login page.")
    public void user_is_on_movies_application_login_page() {
        driver.get(properties.getProperty("loginPageUrl"));
        wait.until(ExpectedConditions.urlToBe(properties.getProperty("loginPageUrl")));
        Assert.assertEquals(driver.getCurrentUrl(),properties.getProperty("loginPageUrl"));
    }
    @When("the user enters username and password")
    public void the_user_enters_username_and_password() {
        loginPage.usernameInputEle.sendKeys(properties.getProperty("userName"));
        loginPage.passwordInputEle.sendKeys(properties.getProperty("password"));
    }
    @When("clicks on the login button")
    public void clicks_on_the_login_button() {
        loginPage.loginButtonEle.click();
    }
    @Then("the user should be redirected to the home page of the movies application")
    public void the_user_should_be_redirected_to_the_home_page_of_the_movies_application() {
        wait.until(ExpectedConditions.urlToBe(properties.getProperty("homePageUrl")));
        Assert.assertEquals(driver.getCurrentUrl(),properties.getProperty("homePageUrl"));
    }


    @When("the user enters {string} and {string}")
    public void theUserEntersAnd(String username, String password) {
        loginPage.usernameInputEle.sendKeys(username);
        loginPage.passwordInputEle.sendKeys(password);

    }

    @Then("User should see an error message {string}")
    public void userShouldSeeAnErrorMessage(String errorMessage) {
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginErrorEle));
        String expectedError = loginPage.loginErrorEle.getText();
        Assert.assertEquals(expectedError,errorMessage);
    }



}