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



    /**
     * BeforeMethod - method executed before every Test.
     *
     * Scenario:
     * - Open Chrome browser.
     * - Navigate to test site link.
     * - Create LinkedinLoginPage.
     */

    @Parameters("browserName")
    @BeforeMethod
    public void beforeMethod(@Optional("Chrome") String browserName) throws Exception {

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

//        switch (idBrowser){
//            case 1:
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//                break;
//            case 2:
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//                break;
//            case 3:
//                WebDriverManager.iedriver().setup();
//                driver = new InternetExplorerDriver();
//                break;
//            default:
//                System.out.println("browser : " + idBrowser + " is invalid, Launching Chrome as browser of choice..");
//                driver = new ChromeDriver();
//        }
        //     driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
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

