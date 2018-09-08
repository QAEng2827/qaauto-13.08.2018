import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.lang.Thread.sleep;

public class LinkedinFirstRequestPasswordResetPage extends LinkedinBasePage{
   // private WebElement searchField;

    @FindBy(xpath = "//div[@class='app__content']/header")
    private WebElement hederFirstRequestPasswordResetPage;

    @FindBy (xpath = "//nav/a[@class='nav__button--signin']")
    private WebElement sinInButton;

    @FindBy (xpath = "//nav/a[@class='nav__button--joinnow']")
    private WebElement joinNowButton;

    @FindBy(xpath = "//h2[@class='form__subtitle']")
    private WebElement subtitleMessage;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement emailPhoneField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement findAccountButton;

   // private List<WebElement> searchResults;


    // конструктор
    public LinkedinFirstRequestPasswordResetPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        }

    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("/uas/request-password-reset")
                && getCurrentTitle().contains("Reset Password | LinkedIn")
                && emailPhoneField.isDisplayed()
                && hederFirstRequestPasswordResetPage.isDisplayed()
                && findAccountButton.isDisplayed();

    }

    public LinkedinRequestPasswordResetSubmitPage isLoadedRequestPasswordResetSubmitPage(String userEmailOrPhone) {
        emailPhoneField.sendKeys(userEmailOrPhone);
        emailPhoneField.sendKeys(Keys.ENTER);
      //  findAccountButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinRequestPasswordResetSubmitPage(driver);

    }
}
