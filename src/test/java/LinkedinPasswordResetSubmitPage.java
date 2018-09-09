import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class LinkedinPasswordResetSubmitPage  extends LinkedinBasePage {

    @FindBy(xpath = "//a[@class='nav__base--logged-in nav__button--back-to-linkedin'")
    private WebElement backToLinkedinLink;

    @FindBy(xpath = "//header[@class='content__header'")
    private WebElement hederPasswordResetSubmitPage;

    @FindBy(xpath = "//h2[@class='form__subtitle']")
    private WebElement subtitleMessage;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement goToHomepageButton;


    // конструктор
    public LinkedinPasswordResetSubmitPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("/checkpoint/rp/request-password-reset-submit")
                //&& getCurrentTitle().contains("Please check your email for reset password link | LinkedIn");

                && hederPasswordResetSubmitPage.isDisplayed()
                && subtitleMessage.isDisplayed()

                && goToHomepageButton.isDisplayed();

    }

    public LinkedInHomePage isHomePageLoaded(){
    goToHomepageButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedInHomePage(driver);

    }
}
