package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedinRequestPasswordResetPage extends LinkedinBasePage {
   // private WebElement searchField;

    @FindBy(xpath = "//div[@class='app__content']/header")
    private WebElement headerFirstRequestPasswordResetPage;

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
    public LinkedinRequestPasswordResetPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        }

    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("/uas/request-password-reset")
                && getCurrentTitle().contains("Reset Password | LinkedIn")
                && emailPhoneField.isDisplayed()
                && headerFirstRequestPasswordResetPage.isDisplayed()
                && findAccountButton.isDisplayed();

    }

    public LinkedinPasswordResetSubmitPage findAccount(String userEmailOrPhone) {

        gMailService.connect();

        emailPhoneField.sendKeys(userEmailOrPhone);
             // emailPhoneField.sendKeys(Keys.ENTER);
       findAccountButton.click();

        String messageSubject = "here's the link to reset your password";
        String messageTo = "qaeng2728@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

        String message =  gMailService.waitMessage(messageSubject, messageTo, messageFrom, 400);
//        String correctResetPasswordLink = exstractResetLink(message);
//
//        driver.get(correctResetPasswordLink);
//
//        System.out.println("Link for reset: " + correctResetPasswordLink);

           return new LinkedinPasswordResetSubmitPage(driver, message);
    }

//    private  String exstractResetLink(String message) {
//        String linkSearchStringBegin =  "https://www.linkedin.com/e/";
//
//        String incorrectLink;
//        String correctLink;
//
//        int beginResetLink = message.indexOf(linkSearchStringBegin);
//
//        String substringBegin = message.substring(beginResetLink);
//        System.out.println("LinkBegin: " + substringBegin);
//        int endResetLink = substringBegin.indexOf("\"");
//
//        incorrectLink = substringBegin.substring(0, endResetLink);
//
//        System.out.println(incorrectLink);
//
//        correctLink = incorrectLink.replaceAll("&amp;", "&");
//        System.out.println("Go ahead: "+correctLink);
//        return correctLink;
//
//    }


}
