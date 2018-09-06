
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LinkedInSearchTest { WebDriver driver;
    LinkedInLoginPage linkedInLoginPage;

    @FindBy(xpath = ".//div[@class='blended-srp-results-js pt0 pb4 ph0 container-with-shadow']/ul/li" )
    private WebElement searchResult; // тут массив данных

    @BeforeMethod
    public void beforeMethod() {
        //   открываем браузер и заходим на страницу
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        linkedInLoginPage = new LinkedInLoginPage(driver);
    }

    @AfterMethod
    public void afterMethod() {

     //  driver.quit();
    }

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                {"qaeng2728@gmail.com", "chertopoloh2827"},
               // {"QAEng2728@gmail.com", "chertopoloh2827"},

        };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfullSearchTest(String userEmail, String userPassword) {

        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login(userEmail, userPassword);
        Assert.assertTrue(linkedInHomePage.isPageLoaded(), "Home page is not loaded.");

        LinkedInSearchPage linkedInSearchPage = linkedInHomePage.isLoadedSearchPage();
        Assert.assertTrue(linkedInSearchPage.isPageLoaded(), "Search page is not loaded.");

    }
}
