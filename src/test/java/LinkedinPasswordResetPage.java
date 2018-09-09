import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class LinkedinPasswordResetPage  extends LinkedinBasePage {
    @FindBy(xpath = "//div[@class='app__content']/header")
    private WebElement headerPasswordResetPage;

    @FindBy (xpath = "//nav/a[@class='nav__button--signin']")
    private WebElement sinInButton;

    @FindBy (xpath = "//nav/a[@class='nav__button--joinnow']")
    private WebElement joinNowButton;

    @FindBy(xpath = "//h2[@class='form__subtitle']")
    private WebElement subtitleMessage;

    @FindBy(xpath = "//input[@id='newPassword']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement retypeNewPasswordField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement submitButton;


    // конструктор
    public LinkedinPasswordResetPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("/checkpoint/rp/")
                //&& getCurrentTitle().contains("Please check your email for reset password link | LinkedIn");

                && headerPasswordResetPage.isDisplayed()
                && subtitleMessage.isDisplayed()
                && newPasswordField.isDisplayed()
                && retypeNewPasswordField.isDisplayed()
                && submitButton.isDisplayed();

    }

    public LinkedinPasswordResetSubmitPage isLoadedPasswordResetSubmitPage(String userNewPassword, String userNewPasswordRetype) {
        newPasswordField.sendKeys(userNewPassword);
        retypeNewPasswordField.sendKeys(userNewPasswordRetype);
        submitButton.click();

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new LinkedinPasswordResetSubmitPage(driver);

    }

    public String getHeaderMessageText(){
        return headerPasswordResetPage.getText();
    }
}
