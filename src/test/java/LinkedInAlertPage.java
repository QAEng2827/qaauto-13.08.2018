import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedInAlertPage {


    private WebDriver driver;
    private WebElement alertMessage;
    private WebElement signInButton;

    // конструктор
    public LinkedInAlertPage(WebDriver driver){
        this.driver = driver;
        initElements();
    }

    private void initElements() {

      alertMessage = driver.findElement(By.xpath("//div[@role='alert']/*/strong"));

        alertMessage.getText();
    }


    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getCurrentTitle(){
        return driver.getTitle();
    }

    public String getCurrentAlertMessage(){return alertMessage.getText();}

    public boolean isPageLoaded(){
        return getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit")
                && getCurrentTitle().equals("Sing In to LinkedIn");
                //&& alertMessage.isDisplayed();

    }
}
