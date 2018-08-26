import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

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
    // negative test

    @Test
    public void negativeloginTest() {
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
        userEmailField.sendKeys("a@b.com" );
        userPasswordField.sendKeys("wrong");
        singInButton.click();

        try{ sleep(3000);}
        catch (InterruptedException e){
            e.printStackTrace();
        }

        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(alertMessage.getText(),"There were one or more errors in your submission. Please correct the marked fields below.","Alert message text is wrong");



    }

    @Test
    public void tooLongLoginTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        //проверяем тайтл и урл и элементы на странице

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "Login page URL is wrong.");
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page title is wrong.");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id = 'login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id = 'login-password']"));
        WebElement singInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(singInButton.isDisplayed(), "signIn button is not displayed on Login page.");

        userEmailField.sendKeys("Home Task #1:" +
                "1) Add lines of code that will do following actions:" +
                "- Enter 'selenium' into searchField on google.com web page." +
                "- Hit 'Enter' button from keyboard (to get list of search results)" +
                "2) Describe environment setup in a separate file:" +
                "- Create file 'README.md' in a project root folder" +
                "- In this file describe a list of required actions to setup environment (which tools to download and install, any tricky setup hints)");
        userPasswordField.sendKeys("chertopoloh2827");
        singInButton.click();

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement alertMessage = driver.findElement(By.xpath("//span[@id ='session_key-login-error']"));

             Assert.assertTrue(alertMessage.getText().contains("The text you provided is too long (the maximum length is 128 characters"));

    }
    @Test
        public void tooLongPswTest() {
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.linkedin.com/");

            //проверяем тайтл и урл и элементы на странице

            Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "Login page URL is wrong.");
            Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page title is wrong.");

            WebElement userEmailField = driver.findElement(By.xpath("//input[@id = 'login-email']"));
            WebElement userPasswordField = driver.findElement(By.xpath("//input[@id = 'login-password']"));
            WebElement singInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

            Assert.assertTrue(singInButton.isDisplayed(), "signIn button is not displayed on Login page.");


            userEmailField.sendKeys("qaeng2728@gmail.com");
            userPasswordField.sendKeys("Home Task #1:" +
                    "1) Add lines of code that will do following actions:" +
                    "- Enter 'selenium' into searchField on google.com web page." +
                    "- Hit 'Enter' button from keyboard (to get list of search results)" +
                    "2) Describe environment setup in a separate file:" +
                    "- Create file 'README.md' in a project root folder" +
                    "- In this file describe a list of required actions to setup environment (which tools to download and install, any tricky setup hints)");
            singInButton.click();

            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement alertMessage = driver.findElement(By.xpath("//span[@id ='session_password-login-error']"));

            Assert.assertEquals(alertMessage.getText(), "The password you provided must have at most 400 characters.", "Alert message text is wrong");


        }
    @Test
    public void invalidLoginTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        //проверяем тайтл и урл и элементы на странице

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "Login page URL is wrong.");
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page title is wrong.");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id = 'login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id = 'login-password']"));
        WebElement singInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(singInButton.isDisplayed(), "signIn button is not displayed on Login page.");


        userEmailField.sendKeys("qaeng2728 gmail.com");
        userPasswordField.sendKeys("something");
        singInButton.click();

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement alertMessage = driver.findElement(By.xpath("//span[@id ='session_key-login-error']"));

        Assert.assertEquals(alertMessage.getText(), "Please enter a valid email address.", "Alert message text is wrong");


    }

    @Test
    // логин и пароль валидные, но от разных аккаунтов
    public void noMatchesLoginPswTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        //проверяем тайтл и урл и элементы на странице

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "Login page URL is wrong.");
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page title is wrong.");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id = 'login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id = 'login-password']"));
        WebElement singInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(singInButton.isDisplayed(), "signIn button is not displayed on Login page.");


        userEmailField.sendKeys("qaeng2728@gmail.com");
        userPasswordField.sendKeys("Artemio2728");
        singInButton.click();

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(alertMessage.getText(),"There were one or more errors in your submission. Please correct the marked fields below.","Alert message text is wrong");

    }
    @Test
    public void noLoginTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");

        //проверяем тайтл и урл и элементы на странице

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "Login page URL is wrong.");
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page title is wrong.");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id = 'login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id = 'login-password']"));
        WebElement singInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(singInButton.isDisplayed(), "'Sign In' button is enabled");//кнопка не активна при отсутствии емейла

        // String loginEmail = "qaeng2728@gmail.com",loginPsw = "chertopoloh2827";
        userEmailField.sendKeys("" );
        userPasswordField.sendKeys("wrong");
        singInButton.click();

        try{ sleep(3000);}
        catch (InterruptedException e){
            e.printStackTrace();
        }

        Assert.assertFalse(singInButton.isEnabled(), "Incorrect work!");



    }
    }