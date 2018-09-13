package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static java.lang.Thread.sleep;

public class LinkedinPasswordResetSubmitPage extends LinkedinBasePage {

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
    private String message;

    // конструктор
    public LinkedinPasswordResetSubmitPage(WebDriver driver, String message){
        this.driver = driver;
        this.message = message;
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
    public LinkedinSetNewPasswordPage navigateToLinkFromEmail() {

//        String messageSubject = "here's the link to reset your password";
//        String messageTo = "qaeng2728@gmail.com";
//        String messageFrom = "security-noreply@linkedin.com";
//        String message =  gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
//        System.out.println("HTML text:"+ message);
        String resetPasswordLink = exstractResetLink(message);
        System.out.println("LINK To change your LinkedIn password: " + resetPasswordLink);
        driver.get(resetPasswordLink);

        return new LinkedinSetNewPasswordPage(driver);
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

        correctLink = incorrectLink.replaceAll("&amp;", "&");
        System.out.println(correctLink);
        return correctLink;

    }

}
