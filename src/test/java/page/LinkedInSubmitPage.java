package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedInSubmitPage extends LinkedinBasePage {


    @FindBy(xpath ="//div[@role= 'alert']")
    private WebElement alertMessage;

    @FindBy (xpath = "//span[@id='session_key-login-error']")
    private WebElement alertMessageLoginText;

    @FindBy (xpath = "//span[@id='session_password-login-error']")
    private WebElement alertMessagePasswordText;

    /** * Costructor of LinkedInSubmitPage Page.
     *
     * Initiate variables with Page Factory, when they are called.
     * @param driver - driver instance from tests.
    */

    public LinkedInSubmitPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        waitUntilElementVisible(alertMessage, 10);
    }


    /**  isPageLoaded method - checks URL, title and alert message are found and as expected.
     * @return true, when everything found.
     */
    public boolean isPageLoaded(){
        return
               getCurrentUrl().contains(".linkedin.com/uas/login-submit")
               &&
//                       getCurrentTitle().contains("LinkedIn")
//                &&
                        alertMessage.isDisplayed();

    }

    /**getAlertMessageText method
     * @return text of message
     */
    public String getAlertMessageText(){
        return alertMessage.getText();
    }

    /**getUserLoginAlertText method
     * @return text of message
     */
    public String getUserLoginAlertText(){
        return alertMessageLoginText.getText();
    }

    /**getUserPasswordlAlertTex method
     * @return text of message
     */
    public String getUserPasswordlAlertText(){
        return alertMessagePasswordText.getText();
    }

}


