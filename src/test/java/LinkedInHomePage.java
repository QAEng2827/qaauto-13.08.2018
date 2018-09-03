import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedInHomePage extends LinkedinBasePage {


    private WebElement profileNavItem;


    // конструктор
    public LinkedInHomePage(WebDriver driver){
        this.driver = driver;
        initElements();
    }

    private void initElements() {

        profileNavItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
    }


    public boolean isPageLoaded(){
        return getCurrentUrl().equals("https://www.linkedin.com/feed/")
                && getCurrentTitle().contains("LinkedIn")
                && profileNavItem.isDisplayed();

    }
}
