package stepdefinitions;

import hooks.hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AccountsPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ConfigReader;

import java.time.Duration;
import java.util.Properties;

public class AccountsPageStep {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HomePage homePage;
    AccountsPage accountsPage;
    Properties properties;

    public AccountsPageStep() {
        this.driver = hooks.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        ConfigReader configReader = new ConfigReader();
        properties = configReader.init_prop();
        loginPage = new LoginPage(driver);
        loginPage.successfulLogin(properties.getProperty("userName"), properties.getProperty("password"));
        homePage = new HomePage(driver);
        homePage.accountsPageUrl();
        accountsPage = new AccountsPage(driver);
    }

    @Given("the user is on the Accounts page")
    public void the_user_is_on_the_accounts_page() {
        Assert.assertEquals(driver.getCurrentUrl(),properties.getProperty("accountsPageUrl"));
    }

    @Then("the user should see the account heading displayed")
    public void the_user_should_see_the_account_heading_displayed() {
        Assert.assertTrue(accountsPage.isAccountHeadingDisplayed());
    }

    @And("the membership section containing the username and password fields should be visible")
    public void the_membership_section_containing_the_username_and_password_fields_should_be_visible() {
        Assert.assertTrue(accountsPage.isMembershipUsernameDisplayed());
        Assert.assertTrue(accountsPage.isMembershipPasswordDisplayed());
    }

    @And("the plan details section should display the user's plan information")
    public void the_plan_details_section_should_display_the_user_s_plan_information() {
        Assert.assertTrue(accountsPage.isPlanDetailsHeadingDisplayed());
    }


    @And("the page should end with a visible Logout button")
    public void thePageShouldEndWithAVisibleLogoutButton() {
        Assert.assertTrue(accountsPage.isLogoutButtonDisplayed());
    }
}