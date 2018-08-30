import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class LinkedInHomePage {

    private WebDriver driver;
    private WebElement profileNavItem;
    private WebElement signInButton;

    // конструктор
    public LinkedInHomePage(WebDriver driver){
        this.driver = driver;
        initElements();
    }

    private void initElements() {

        profileNavItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
    }


    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getCurrentTitle(){
        return driver.getTitle();
    }

    public boolean isPageLoaded(){
        return getCurrentUrl().equals("https://www.linkedin.com/feed/")
                && getCurrentTitle().contains("LinkedIn")
                && profileNavItem.isDisplayed();

    }
}
