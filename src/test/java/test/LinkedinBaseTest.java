package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LinkedInLoginPage;

public class LinkedinBaseTest {
    WebDriver driver;
    LinkedInLoginPage linkedInLoginPage;

    @BeforeMethod
public void beforeMethod() {
    //   открываем браузер и заходим на страницу
    driver = new ChromeDriver();
    driver.get("https://www.linkedin.com/");
    linkedInLoginPage = new LinkedInLoginPage(driver);
}

    @AfterMethod
    public void afterMethod() {

        driver.quit();
    }
}
