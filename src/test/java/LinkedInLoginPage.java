import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedInLoginPage extends LinkedinBasePage{


   @FindBy(xpath = "//input[@id = 'login-email']")
   private WebElement userEmailField;

   @FindBy(xpath = "//input[@id = 'login-password']" )
   private WebElement userPasswordField;

   @FindBy(xpath = "//input[@id='login-submit']" )
   private WebElement signInButton;

// конструктор
    public LinkedInLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); //  просто считывает значения, но не ищет

    }



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



    public boolean isPageLoaded(){
        return getCurrentUrl().equals("https://www.linkedin.com/")
                && getCurrentTitle().equals("LinkedIn: Log In or Sign Up")
                && signInButton.isDisplayed();

    }

    public boolean isButtonEnabled(){
        return getCurrentUrl().equals("https://www.linkedin.com/")
                && getCurrentTitle().equals("LinkedIn: Log In or Sign Up")
                && signInButton.isEnabled();

    }
}
