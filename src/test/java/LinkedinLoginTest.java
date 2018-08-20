import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedinLoginTest {
    @Test
    public void successfullLoginTest() {

        //Navigate to linkedin.com
        //Verify that login page is loaded
        //Enter userEmail
        //Enter userPassword
        //Click on 'Sing in' button

        //Verify Home page is displayed

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        //проверяем тайтл и урл и элементы на странице

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "Login page URL is wrong.");
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page title is wrong.");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id = 'login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id = 'login-password']"));
        WebElement singInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(singInButton.isDisplayed(), "signIn button is not displayed on Login page.");

        // String loginEmail = "qaeng2728@gmail.com",loginPsw = "chertopoloh2827";
        userEmailField.sendKeys("qaeng2728@gmail.com" );
        userPasswordField.sendKeys("chertopoloh2827");
        singInButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home page URL is wrong.");
        Assert.assertEquals(driver.getTitle(), "LinkedIn", "Page title is wrong.");

        WebElement profileNavItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
        Assert.assertTrue(profileNavItem.isDisplayed(), "profileNavItem button is not displayed on Home Page");


    }
}
