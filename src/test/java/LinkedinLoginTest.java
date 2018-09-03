import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    WebDriver driver;


    @BeforeMethod
    public void beforeMethod() {
        //   открываем браузер и заходим на страницу
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterMethod() {

        driver.quit();
    }

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                {"qaeng2728@gmail.com", "chertopoloh2827"},
                {"QAEng2728@gmail.com", "chertopoloh2827"},

        };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfullLoginTest(String userEmail, String userPassword) {

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login(userEmail, userPassword);

        Assert.assertTrue(linkedInHomePage.isPageLoaded(), "Home page is not loaded.");
    }

    @DataProvider
    public Object[][] emptyFieldDataProvider() {
        return new Object[][]{
                {"", "chertopoloh2827"},
                {"QAEng2728@gmail.com", ""},
                {"", ""},

        };
    }

    @Test(dataProvider = "emptyFieldDataProvider")
    public void emptyUserEmailandUserPassvordTest(String userEmail, String userPassword) {

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
        LinkedInLoginPage linkedInLoginPagePage = linkedInLoginPage.login(userEmail, userPassword);
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

    }

    // @Test // done


    // negative tests

    @DataProvider
    public Object[][] invalidDataProvider() {
        return new Object[][]{
                {"a@b.com", "wrong", "Please enter a valid email address.", "The password you provided must have at least 6 characters."},
                { "QAEng2728 gmail com", "chertopoloh2827","Please enter a valid email address.","" },
                { "qaeng2728@gmail.com", "Home Task #1: 1) Add lines of code that will do following actions: - Enter 'selenium' into searchField on google.com web page: - Hit 'Enter' button from keyboard (to get list of search results) 2) Describe environment setup in a separate file: - Create file 'README.md' in a project root folder - In this file describe a list of required actions to setup environment (which tools to download and install, any tricky setup hints)",
                   "","The password you provided must have at most 400 characters."},
                {"Home Task #1: 1) Add lines of code that will do following actions: - Enter 'selenium' into searchField on google.com web page: - Hit 'Enter' button from keyboard (to get list of search results) 2) Describe environment setup in a separate file: - Create file 'README.md' in a project root folder - In this file describe a list of required actions to setup environment (which tools to download and install, any tricky setup hints)",
                "chertopoloh2827","The text you provided is too long (the maximum length is 128 characters", ""},
                {"qaeng2728@gmail.com","Artemio2728","", "Hmm, that's not the right password. Please try again or request a new one." }


        };
    }

    @Test(dataProvider = "invalidDataProvider")
    public void negativeloginTest(String userEmail, String userPassword, String messageLogin, String messagePassword) {
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
        linkedInLoginPage.login(userEmail, userPassword);

        LinkedInAlertPage linkedInAlertPage = new LinkedInAlertPage(driver);

        linkedInAlertPage.isAlertMessageForCredentialsVisible(messageLogin,messagePassword);
    }
}


