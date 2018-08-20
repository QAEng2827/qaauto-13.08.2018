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

        //проверяем есть ли кнопка Sing in


        Assert.assertTrue(driver.findElement(By.xpath("//input[@class='login submit-button']")).isDisplayed());


        //лишнее, но не знаю. как еще визуализировать результат
        boolean resultSearshButton = driver.findElement(By.xpath("//input[@class='login submit-button']")).isDisplayed();

        if (resultSearshButton == true) {

            System.out.println("yes");
        } else {
            System.out.println("No");
        }
        ;
        //проверяем есть ли  поля для ввода логина  и пароля

        Assert.assertTrue(driver.findElement(By.xpath("//input[@class = 'login-email']")).isDisplayed());

        Assert.assertTrue(driver.findElement(By.xpath("//input[@class = 'login-password']")).isDisplayed());

        //вводим логин и пароль
        String loginEmail = "qaeng2728@gmail.com",loginPsw = "chertopoloh2827";

        driver.findElement(By.id("login-email")).sendKeys(loginEmail);
        driver.findElement(By.id("login-password")).sendKeys(loginPsw);
        driver.findElement(By.xpath("//input[@class='login submit-button']")).click();

        //  проверяем, выполнен ли вход на Home page
        System.out.println(driver.getCurrentUrl());

             Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Login page URL is wrong.");
        Assert.assertTrue(driver.findElement(By.xpath("//li/a[@class = 'nav-item__link nav-item__link--underline js-nav-item-link active']")).isDisplayed());
        System.out.println(driver.getCurrentUrl());


    }
}
