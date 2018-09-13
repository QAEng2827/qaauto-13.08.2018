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




    // конструктор
    public LinkedInHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public boolean isPageLoaded(){
        return getCurrentUrl().equals("https://www.linkedin.com/feed/")
                && getCurrentTitle().contains("LinkedIn")
                && profileNavItem.isDisplayed();

    }

   public LinkedInSearchPage isLoadedSearchPage (){

      searchField.click();
       searchField.sendKeys("HR");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        searchField.sendKeys(Keys.ENTER);
        return new LinkedInSearchPage(driver);
    //   searchField.sendKeys(Keys.ENTER);

    }

    public LinkedInSearchPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedInSearchPage(driver);
    }
}
