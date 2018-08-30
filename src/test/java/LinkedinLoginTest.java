import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    WebDriver driver;


    @BeforeMethod
    public void beforeMethod(){
     //   открываем браузер и заходим на страницу
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterMethod(){

//        driver.quit(); // закрываем браузер
    }

    @Test
    public void successfullLoginTest() {

        //Navigate to linkedin.com
        //Verify that login page is loaded
        //Enter userEmail
        //Enter userPassword
        //Click on 'Sing in' button
        //Verify Home page is displayed


        // вызываем метод login

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);

        //  проверяем, загрузилась ли страница
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

       // вводим криденшелс
        linkedInLoginPage.login("qaeng2728@gmail.com","chertopoloh2827");

        LinkedInHomePage linkedInHomePage = new LinkedInHomePage(driver);
        Assert.assertTrue(linkedInHomePage.isPageLoaded(), "Home page is not loaded.");

    }
    // negative test

    @Test //done
    public void negativeloginTest() {

        //проверяем тайтл и урл и элементы на странице

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);

        //  проверяем, загрузилась ли страница
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
        linkedInLoginPage.login("a@b.com","wrong");

        LinkedInAlertPage linkedInAlertPage = new LinkedInAlertPage(driver);
        String alertMessageSample = "There were one or more errors in your submission. Please correct the marked fields below.";
        String alertMessageExtraSample = "The password you provided must have at least 6 characters.";
        WebElement alertMessagePath = driver.findElement(By.xpath("//span[@id ='session_password-login-error']"));

        Assert.assertFalse(linkedInAlertPage.isPageLoaded(),"Alert page is not loaded");
        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessage(),alertMessageSample,"Alert message text is wrong");
        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessageExtra(alertMessagePath),alertMessageExtraSample,"Alert message text is wrong");

    }

    @Test // done
    public void tooLongPswTest() {

        //проверяем тайтл и урл и элементы на странице
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);

        //  проверяем, загрузилась ли страница
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        linkedInLoginPage.login("qaeng2728@gmail.com","Home Task #1:" +
                "1) Add lines of code that will do following actions:" +
                "- Enter 'selenium' into searchField on google.com web page." +
                "- Hit 'Enter' button from keyboard (to get list of search results)" +
                "2) Describe environment setup in a separate file:" +
                "- Create file 'README.md' in a project root folder" +
                "- In this file describe a list of required actions to setup environment (which tools to download and install, any tricky setup hints)");

        LinkedInAlertPage linkedInAlertPage = new LinkedInAlertPage(driver);
        String alertMessageSample = "There were one or more errors in your submission. Please correct the marked fields below.";
        Assert.assertFalse(linkedInAlertPage.isPageLoaded(),"Alert page is not loaded");
        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessage(),alertMessageSample,"Alert message text is wrong");

        String alertMessageExtraSample = "The password you provided must have at most 400 characters.";
        WebElement alertMessagePath = driver.findElement(By.xpath("//span[@id ='session_password-login-error']"));

        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessageExtra(alertMessagePath),alertMessageExtraSample,"Alert message text is wrong");
        System.out.println(alertMessagePath);
        System.out.println("HI: " + linkedInAlertPage.getCurrentAlertMessageExtra(alertMessagePath));

        Assert.assertTrue(linkedInAlertPage.getCurrentAlertMessageExtra(alertMessagePath).contains("The password you provided must have at most 400 characters."));

        }



    @Test //done
    // логин и пароль валидные, но от разных аккаунтов
    public void noMatchesLoginPswTest() {
        //проверяем тайтл и урл и элементы на странице

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);

        //  проверяем, загрузилась ли страница
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        linkedInLoginPage.login("qaeng2728@gmail.com","Artemio2728");

        LinkedInAlertPage linkedInAlertPage = new LinkedInAlertPage(driver);
        String alertMessageSample = "There were one or more errors in your submission. Please correct the marked fields below.";
        String alertMessageExtraSample = "Hmm, that's not the right password. Please try again or request a new one.";
        WebElement alertMessagePath = driver.findElement(By.xpath("//*[@id='session_password-login-error']"));

        Assert.assertFalse(linkedInAlertPage.isPageLoaded(),"Alert page is not loaded");
        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessage(),alertMessageSample,"Alert message text is wrong");
        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessageExtra(alertMessagePath),alertMessageExtraSample,"Alert message text is wrong");

    }

    @Test // why? wtf?
    public void invalidLoginTest() {

        //проверяем тайтл и урл и элементы на странице
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);

        //  проверяем, загрузилась ли страница
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
        linkedInLoginPage.login("qaeng2728 gmail.com","something");


        LinkedInAlertPage linkedInAlertPage = new LinkedInAlertPage(driver);
        String alertMessageSample = "There were one or more errors in your submission. Please correct the marked fields below.";
        String alertMessageExtraSample = "Please enter a valid email address.";//*[@id='session_key-login-error']

        WebElement alertMessagePath = driver.findElement(By.xpath("//*[@id='session_key-login-error']")); // проверить хпас

        Assert.assertFalse(linkedInAlertPage.isPageLoaded(),"Alert page is not loaded");
        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessage(),alertMessageSample,"Alert message text is wrong");

        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessageExtra(alertMessagePath),alertMessageExtraSample,"Alert message text is wrong");



      //  Assert.assertTrue(linkedInAlertPage.getCurrentAlertMessageExtra(alertMessagePath).contains("Please enter a valid email address."));

    }

    @Test
    public void tooLongLoginTest() {

        //проверяем тайтл и урл и элементы на странице

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);

        //  проверяем, загрузилась ли страница
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        linkedInLoginPage.login("Home Task #1:" +
                        "1) Add lines of code that will do following actions:" +
                        "- Enter 'selenium' into searchField on google.com web page." +
                        "- Hit 'Enter' button from keyboard (to get list of search results)" +
                        "2) Describe environment setup in a separate file:" +
                        "- Create file 'README.md' in a project root folder" +
                        "- In this file describe a list of required actions to setup environment (which tools to download and install, any tricky setup hints)@b.com",
                "chertopoloh2827");

        LinkedInAlertPage linkedInAlertPage = new LinkedInAlertPage(driver);
        String alertMessageSample = "There were one or more errors in your submission. Please correct the marked fields below.";
        Assert.assertFalse(linkedInAlertPage.isPageLoaded(),"Alert page is not loaded");
        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessage(),alertMessageSample,"Alert message text is wrong");

        WebElement alertMessagePath = driver.findElement(By.xpath("//span[@id ='session_key-login-error']"));


        System.out.println(alertMessagePath);
        System.out.println(alertMessagePath.getText());
        System.out.println(linkedInAlertPage.getCurrentAlertMessageExtra(alertMessagePath));
        Assert.assertTrue(!linkedInAlertPage.getCurrentAlertMessageExtra(alertMessagePath).contains("The text you provided is too long (the maximum length is 128 characters"));

    }

// Одно из полей пустое и перехода на другую страницу не происходит
    @Test
    // поле логина пустое
    public void noLoginTest() {

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        linkedInLoginPage.login("","wrong");

      //  если страница не изменилась,  и кнопа неактивна, значит ошибка
        Assert.assertFalse(linkedInLoginPage.isButtonEnabled(), "Login or password is absent");

    }

    @Test
    // поле пароля пустое
    public void noPswTest() {

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        linkedInLoginPage.login("qaeng2728@gmail.com","");

        //  если страница не изменилась,  и кнопа неактивна, значит ошибка
        Assert.assertFalse(linkedInLoginPage.isButtonEnabled(), "Login or password is absent");



    }
}