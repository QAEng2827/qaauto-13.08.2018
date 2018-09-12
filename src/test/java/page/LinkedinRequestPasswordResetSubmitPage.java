package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;


import static java.lang.Thread.sleep;

public class LinkedinRequestPasswordResetSubmitPage extends LinkedinBasePage {

    @FindBy(xpath = "//div[@class='app__content']/header")
    private WebElement headerRequestPasswordResetSubmitPage;

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
               && headerRequestPasswordResetSubmitPage.isDisplayed()
                && tryDifferentEmailButton.isDisplayed();

    }
// проверить работу
    public LinkedinPasswordResetPage navigateToLinkFromEmail() {
        try {
            sleep(400);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String messageSubject = "here's the link to reset your password";
        String messageTo = "qaeng2728@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

        String message =  gMailService.waitMessage(messageSubject, messageTo, messageFrom, 400);
        String correctResetPasswordLink = exstractResetLink(message);

        driver.get(correctResetPasswordLink);

        System.out.println("Link for reset: " + correctResetPasswordLink);

//        try {
//            sleep(400);
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return new LinkedinPasswordResetPage(driver);
    }

    private  String exstractResetLink(String message) {

        String linkSearchStringBegin =  "https://www.linkedin.com/e/";
        String incorrectLink;
        String correctLink;

        int beginResetLink = message.indexOf(linkSearchStringBegin);

        String substringBegin = message.substring(beginResetLink);
        System.out.println("LinkBegin: " + substringBegin);
        int endResetLink = substringBegin.indexOf("\"");

        incorrectLink = substringBegin.substring(0, endResetLink);

        System.out.println(incorrectLink);

        correctLink = incorrectLink.replaceAll("&amp;", "");
        System.out.println(correctLink);
        return correctLink;

    }


    public String getHeaderMessageText(){
        return headerRequestPasswordResetSubmitPage.getText();
    }


}
