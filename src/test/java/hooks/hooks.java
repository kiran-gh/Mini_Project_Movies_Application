package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.ConfigReader;
import webdriver.BaseClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;


public class hooks {
    public static WebDriver driver;
    private Properties properties;

    @Before
    public void startUp() {
        ConfigReader configReader = new ConfigReader();
        this.properties = configReader.init_prop();

        String browser = properties.getProperty("browser"); // Default to Chrome if no browser is provided
        driver = BaseClass.createDriver(browser);
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}