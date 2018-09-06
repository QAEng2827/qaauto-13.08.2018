
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedInSubmitPage extends LinkedinBasePage{


    @FindBy(xpath ="//div[@role= 'alert']")
    private WebElement alertMessage;

    @FindBy (xpath = "//span[@id='session_key-login-error']")
    private WebElement alertMessageLoginText;

    @FindBy (xpath = "//span[@id='session_password-login-error']")
    private WebElement alertMessagePasswordText;

    public LinkedInSubmitPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public boolean isPageLoaded(){
        return
               getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit")
               &&
                       getCurrentTitle().contains("LinkedIn")
                &&
                        alertMessage.isDisplayed();

    }
    public String getAlertMessageText(){
        return alertMessage.getText();
    }

    public String getUserLoginAlertText(){
        return alertMessageLoginText.getText();
    }
    public String getUserPasswordlAlertText(){
        return alertMessagePasswordText.getText();
    }

}


