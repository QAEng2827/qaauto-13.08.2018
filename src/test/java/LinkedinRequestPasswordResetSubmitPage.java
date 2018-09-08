import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class LinkedinRequestPasswordResetSubmitPage extends LinkedinBasePage {

    @FindBy(xpath = "//div[@class='app__content']/header")
    private WebElement hederRequestPasswordResetSubmitPage;

    @FindBy (xpath = "//nav/a[@class='nav__button--signin']")
    private WebElement sinInButton;

    @FindBy (xpath = "//nav/a[@class='nav__button--joinnow']")
    private WebElement joinNowButton;

    @FindBy(xpath = "//h2[@class='form__subtitle']")
    private WebElement subtitleMessage;

    @FindBy(xpath = "//button[@id='resend-url']")
    private WebElement resendLinkButton;

    @FindBy(xpath = "//a[contains(@class, 'different__email--desktop')]")
    private WebElement tryDifferentEmailButton;

    // конструктор
    public LinkedinRequestPasswordResetSubmitPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("/checkpoint/rp/request-password-reset-submit")
                //&& getCurrentTitle().contains("Please check your email for reset password link | LinkedIn");
                && resendLinkButton.isDisplayed()
               && hederRequestPasswordResetSubmitPage.isDisplayed()
                && tryDifferentEmailButton.isDisplayed();

    }
// проверить работу
    public LinkedinPasswordResetPage isLoadedPasswordResetPage() {

        try {
            sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new LinkedinPasswordResetPage(driver);

    }
}
