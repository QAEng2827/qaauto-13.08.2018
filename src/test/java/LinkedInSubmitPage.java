import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInSubmitPage {
    private WebDriver driver;
    @FindBy (xpath = "//span[@id='session_key-login-error']")
    private WebElement alertMessageLoginText;

    @FindBy (xpath = "//span[@id='session_password-login-error']")
    private WebElement alertMessagePasswordText;

    public LinkedInSubmitPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public String getCurrentUrl(){

        return driver.getCurrentUrl();
    }

    public String getCurrentTitle(){
        return  driver.getTitle();
    }


    public boolean isAlertMessageForCredentialsVisible(String alertMessageEmail, String alertMessagePassword){
        return getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit")
                && getCurrentTitle().equals("Sign In to LinkedIn")
                && (alertMessageLoginText.equals(alertMessageEmail) || alertMessagePasswordText.equals(alertMessagePassword));

    }
}


