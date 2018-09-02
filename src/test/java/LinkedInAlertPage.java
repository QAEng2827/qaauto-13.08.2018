import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedInAlertPage {


    private WebDriver driver;
    private WebElement message;
    private WebElement alertMessageExtra;

    @FindBy(xpath = "//input[@id = 'login-email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//input[@id = 'login-password']" )
    private WebElement userPasswordField;

    @FindBy(xpath = "//input[@id='login-submit']" )
    private WebElement signInButton;

    // конструктор
    public LinkedInAlertPage(WebDriver driver){
        this.driver = driver;
        initElementsExtra();

    }
//    private void initElements() {
//
//      alertMessage = driver.findElement(By.xpath("//div[@role='alert']/*/strong"));
//
//        alertMessage.getText();
//
//        }
//
   private void initElementsExtra() {

        alertMessageExtra = driver.findElement(By.xpath("//span[@class='error']"));

        //alertMessageExtra.getText();
    }


    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getCurrentTitle(){
        return driver.getTitle();
    }

  //  public String getCurrentAlertMessage(){return alertMessage.getText();}

    public String getCurrentAlertMessageExtra(WebElement path){
        return alertMessageExtra.getText();
    }
    public boolean isAlertVisible( String messageLogin){
               message = driver.findElement(By.xpath("//span[@class='error']"));
        return getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit")
                && getCurrentTitle().equals("Sing In to LinkedIn")
                && alertMessageExtra.isDisplayed()
        && message.equals(messageLogin);

    }
    public boolean isPageLoaded(){

        return getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit")
                && getCurrentTitle().equals("Sing In to LinkedIn")
                && alertMessageExtra.isDisplayed();

    }
}
