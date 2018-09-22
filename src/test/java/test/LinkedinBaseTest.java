package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.LinkedInLoginPage;

/**
 * LinkedinBase test class with common for other tests methods.
 */
public class LinkedinBaseTest {
    WebDriver driver;
    LinkedInLoginPage linkedInLoginPage;
    //int idBrowser = 2; // 1-firefox; 2-chrome; 3-internetExplorer
    //String browserName = "chrome";
    //String prefixCountry = "ua";



    /**
     * BeforeMethod - method executed before every Test.
     *
     * Scenario:
     * - Open Chrome browser.
     * - Navigate to test site link.
     * - Create LinkedinLoginPage.
     */

    @Parameters({"browserName","prefixCountry"})

    @BeforeMethod
    public void beforeMethod(@Optional("Chrome") String browserName, @Optional("https://ua.linkedin.com/") String prefixCountry) throws Exception {

        switch (browserName.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new Exception("Browser : " + browserName + " is not supported");

        }
      //  prefixCountry = "https://"+prefixCountry+"linkedin.com/";
        driver.get(prefixCountry);
        //driver.get("https://www.linkedin.com/");
      //  System.out.println(prefixCountry);
        linkedInLoginPage = new LinkedInLoginPage(driver);
    }



    /**
     * AfterMethod - method executed after every Test.
     *
     * Scenario:
     * -Quit from browser.
     */
    @AfterMethod (alwaysRun = true)
    public void afterMethod() {

        driver.quit();
    }

}

