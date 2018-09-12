package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.LinkedInHomePage;
import page.LinkedinBasePage;

import static java.lang.Thread.sleep;

public class LinkedinSuccessfulPasswordResetPage extends LinkedinBasePage {

    @FindBy(xpath = "//a[@class='nav__base--logged-in nav__button--back-to-linkedin'")
    private WebElement backToLinkedinLink;

    @FindBy(xpath = "//header[@class='content__header'")
    private WebElement headerPasswordResetSubmitPage;

    @FindBy(xpath = "//h2[@class='form__subtitle']")
    private WebElement subtitleMessage;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement goToHomepageButton;


    // конструктор
    public LinkedinSuccessfulPasswordResetPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("/checkpoint/rp/password-reset-submit")
                //&& getCurrentTitle().contains("Please check your email for reset password link | LinkedIn");

             //   && headerPasswordResetSubmitPage.isDisplayed()

                && goToHomepageButton.isDisplayed();

    }

    public LinkedInHomePage clickOnGoToHomeButton(){
    goToHomepageButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedInHomePage(driver);

    }
    public String getHeaderMessageText(){
        return headerPasswordResetSubmitPage.getText();
    }

}
