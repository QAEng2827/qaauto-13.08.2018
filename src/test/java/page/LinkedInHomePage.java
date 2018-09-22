package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class LinkedInHomePage extends LinkedinBasePage {


    @FindBy(xpath = "//li[@id='profile-nav-item']" )
    private WebElement profileNavItem;

    @FindBy(xpath = "//input[@placeholder and @role='combobox']" )
    private WebElement searchField;


    /**Costructor of Linkedin Home Page.
     *
     * Initiate variables with Page Factory, when they are called.
     * @param driver - driver instance from tests.

     */

    public LinkedInHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementVisible(profileNavItem, 10);
    }


    /**
     * isPageLoaded method. Checks URL, title and Profile navigation menu are found as expected.
     * @return true, when everything found.
     *
     */
    public boolean isPageLoaded(){
        return getCurrentUrl().contains(".linkedin.com/")
                && getCurrentTitle().contains("LinkedIn")
                && profileNavItem.isDisplayed();

    }

    /** isLoadedSearchPage method. Input search word, wait, then follow to Search Page with results
     * @return - true, if search field found and Search page is loaded
     */
   public LinkedInSearchPage isLoadedSearchPage (){

      searchField.click();
       searchField.sendKeys("HR");
      //  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        searchField.sendKeys(Keys.ENTER);
        return new LinkedInSearchPage(driver);


    }

    /*** search method - insert a search word with enter.
     *
     * @param searchTerm - word is searched.
     * @return - LinkedinSearchPage with results
     *
     */
    public LinkedInSearchPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);

        return new LinkedInSearchPage(driver);
    }
}
