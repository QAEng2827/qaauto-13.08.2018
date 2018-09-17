package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

/**
 * LinkedInLogin Page object class.
 */
public class LinkedInLoginPage extends LinkedinBasePage {


   @FindBy(xpath = "//input[@id = 'login-email']")
   private WebElement userEmailField;

   @FindBy(xpath = "//input[@id = 'login-password']" )
   private WebElement userPasswordField;

   @FindBy(xpath = "//input[@id='login-submit']" )
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class ='link-forgot-password']" )
    private WebElement forgotPasswordLink;

    /**
     * Constructor for linkedInLoginPage;
     *
     * @param driver -  driver instance fom test,  КС-приложение между библиотекой вебдрейверa и браузерom.
     */
    public LinkedInLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); //  просто считывает значения, но не ищет
        waitUntilElementVisible(signInButton, 10);

    }


    /**
     * User login by username/password
     *
     * @param userEmail - String with userEmail.
     * @param userPassword -String with userPassword.
     * @param <T> - generic type to return different PageObjects.
     * @return one of correcsponding PageObjects linkedInLoginPage/LinkedInHomePage/LinkedInSubmitPage/
     */
    public <T> T login(String userEmail, String userPassword){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();

        try{ sleep(3000);}
        catch (InterruptedException e){
            e.printStackTrace();
        }

        if (getCurrentUrl().contains("/feed")){
            return (T) new LinkedInHomePage(driver);
        }
        if (getCurrentUrl().contains("/login-submit")){
            return (T) new LinkedInSubmitPage(driver);
        }

        else {
            return (T) this; //PageFactory.initElements(driver,LinkedInLoginPage.class); - тоже рабочий вариант
        }

    }


    /** * isPageLoaded method. Checks URL, title and signIn Button are found as expected.
     * @return true, when everything found.
     */
    public boolean isPageLoaded(){
        return getCurrentUrl().equals("https://www.linkedin.com/")
                && getCurrentTitle().equals("LinkedIn: Log In or Sign Up")
                && signInButton.isDisplayed();

    }

    /** isButtonEnabled method. Checkup button "Sign in" is enabled
     * @return true when signInButton is enable.
     */
    public boolean isButtonEnabled(){
        return getCurrentUrl().equals("https://www.linkedin.com/")
                && getCurrentTitle().equals("LinkedIn: Log In or Sign Up")
                && signInButton.isEnabled();

    }


    /**  * clickOnForgotPasswordLink method clicks on forgotPassword button.
     *
     * @return LinkedinRequestPasswordReset Page.

     */
 public LinkedinRequestPasswordResetPage clickOnForgotPasswordLink(){
    forgotPasswordLink.click();

    return new LinkedinRequestPasswordResetPage(driver);

   }
}
