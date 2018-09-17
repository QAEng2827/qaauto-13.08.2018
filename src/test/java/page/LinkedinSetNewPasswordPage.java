package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedinSetNewPasswordPage extends LinkedinBasePage {
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


    /*** Costructor of LinkedinSetNewPasswordPage.
     *
     * Initiate variables with Page Factory, when they are called.
     * @param driver - driver instance from tests.
     */

    public LinkedinSetNewPasswordPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementVisible(submitButton, 10);
    }

    /**  isPageLoaded method - checks URL, title,header,fields for new password and Submit button are found and as expected.
     * @return true, when everything found.
     */
    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("/checkpoint/rp/")
                //&& getCurrentTitle().contains("Please check your email for reset password link | LinkedIn");

                && headerPasswordResetPage.isDisplayed()
                && subtitleMessage.isDisplayed()
                && newPasswordField.isDisplayed()
                && retypeNewPasswordField.isDisplayed()
                && submitButton.isDisplayed();

    }

    /**    submitNewPassword method fill in anew password.
     *  @param userNewPassword -String with new password.
     *  @param userNewPasswordRetype -String with new password.
     * @return LinkedinSuccessfulPasswordResetPage.
     */

    public LinkedinSuccessfulPasswordResetPage submitNewPassword(String userNewPassword, String userNewPasswordRetype) {
        newPasswordField.sendKeys(userNewPassword);
        retypeNewPasswordField.sendKeys(userNewPasswordRetype);
        submitButton.click();
        return new LinkedinSuccessfulPasswordResetPage(driver);

    }


}
