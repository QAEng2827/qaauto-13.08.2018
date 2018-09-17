package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.LinkedInHomePage;
import page.LinkedinBasePage;

import static java.lang.Thread.sleep;

/**
 * LinkedinSuccessfulPasswordResetPage Page object.
 */
public class LinkedinSuccessfulPasswordResetPage extends LinkedinBasePage {

    @FindBy(xpath = "//a[@class='nav__base--logged-in nav__button--back-to-linkedin'")
    private WebElement backToLinkedinLink;

    @FindBy(xpath = "//header[@class='content__header'")
    private WebElement headerPasswordResetSubmitPage;

    @FindBy(xpath = "//h2[@class='form__subtitle']")
    private WebElement subtitleMessage;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement goToHomepageButton;


    /**
     * Costructor of LinkedinSuccessfulPasswordResetPage.
     *
     * Initiate variables with Page Factory, when they are called.
     * @param driver - driver instance from tests.
     */
    public LinkedinSuccessfulPasswordResetPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementVisible(goToHomepageButton, 10);
    }

    /**  isPageLoaded method - checks URL, title and go home button are found and as expected.
     * @return true, when everything found.
     */
    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("/checkpoint/rp/password-reset-submit")
                //&& getCurrentTitle().contains("Please check your email for reset password link | LinkedIn");

             //   && headerPasswordResetSubmitPage.isDisplayed()

                && goToHomepageButton.isDisplayed();

    }

    /**Following to the link on LinkedIn Home Page
     * @return - new LinkedInHomePage
     */
    public LinkedInHomePage clickOnGoToHomeButton(){
    goToHomepageButton.click();
    return new LinkedInHomePage(driver);

    }


}
