package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LinkedInLoginPage;

/**
 * LinkedinBase test class with common for other tests methods.
 */
public class LinkedinBaseTest {
    WebDriver driver;
    LinkedInLoginPage linkedInLoginPage;

    /**
     * BeforeMethod - method executed before every Test.
     *
     * Scenario:
     * - Open Chrome browser.
     * - Navigate to test site link.
     * - Create LinkedinLoginPage.
     */
    @BeforeMethod
public void beforeMethod() {
    //   открываем браузер и заходим на страницу
    driver = new ChromeDriver();
    driver.get("https://www.linkedin.com/");
    linkedInLoginPage = new LinkedInLoginPage(driver);
}

    /**
     * AfterMethod - method executed after every Test.
     *
     * Scenario:
     * -Quit from browser.
     */
    @AfterMethod
    public void afterMethod() {

        driver.quit();
    }

}


