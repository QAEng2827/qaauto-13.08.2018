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

// сделать красиво для страницы хоум

        LinkedInHomePage linkedInHomePage = new LinkedInHomePage(driver);
        Assert.assertTrue(linkedInHomePage.isPageLoaded(), "Home page is not loaded.");

    }
    // negative test

    @Test
    public void negativeloginTest() {

        //проверяем тайтл и урл и элементы на странице

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);

        //  проверяем, загрузилась ли страница
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

     //   Assert.assertTrue(singInButton.isDisplayed(), "signIn button is not displayed on Login page.");

         linkedInLoginPage.login("a@b.com","wrong");

         // переделать красиво для спейдж обжект алерт

        LinkedInAlertPage linkedInAlertPage = new LinkedInAlertPage(driver);
        String alertMessageSample = "There were one or more errors in your submission. Please correct the marked fields below.";
        String alertMessageExtraSample = "The password you provided must have at least 6 characters.";
        Assert.assertFalse(linkedInAlertPage.isPageLoaded(),"Alert page is not loaded");
        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessage(),alertMessageSample,"Alert message text is wrong");
        System.out.println(linkedInAlertPage.getCurrentAlertMessage());
        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessageExtra(),alertMessageExtraSample,"Alert message text is wrong");
        System.out.println(linkedInAlertPage.getCurrentAlertMessageExtra());




    }

    @Test
    public void tooLongLoginTest() {

        //проверяем тайтл и урл и элементы на странице

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);

        //  проверяем, загрузилась ли страница
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        //   Assert.assertTrue(singInButton.isDisplayed(), "signIn button is not displayed on Login page.");

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

      //  WebElement alertMessage = driver.findElement(By.xpath("//span[@id ='session_key-login-error']"));

      // пока       Assert.assertTrue(alertMessage.getText().contains("The text you provided is too long (the maximum length is 128 characters"));

    }

    @Test
    public void tooLongPswTest() {

        //проверяем тайтл и урл и элементы на странице

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);

        //  проверяем, загрузилась ли страница
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        //   Assert.assertTrue(singInButton.isDisplayed(), "signIn button is not displayed on Login page.");

        linkedInLoginPage.login("qaeng2728@gmail.com","Home Task #1:" +
                "1) Add lines of code that will do following actions:" +
                "- Enter 'selenium' into searchField on google.com web page." +
                "- Hit 'Enter' button from keyboard (to get list of search results)" +
                "2) Describe environment setup in a separate file:" +
                "- Create file 'README.md' in a project root folder" +
                "- In this file describe a list of required actions to setup environment (which tools to download and install, any tricky setup hints)");

        // переделать красиво для спейдж обжект алерт
        LinkedInAlertPage linkedInAlertPage = new LinkedInAlertPage(driver);
        String alertMessageSample = "There were one or more errors in your submission. Please correct the marked fields below.";
        Assert.assertFalse(linkedInAlertPage.isPageLoaded(),"Alert page is not loaded");
        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessage(),alertMessageSample,"Alert message text is wrong");


        /*    WebElement alertMessage = driver.findElement(By.xpath("//span[@id ='session_password-login-error']"));

            Assert.assertEquals(alertMessage.getText(), "The password you provided must have at most 400 characters.", "Alert message text is wrong");

*/
        }

    @Test
    public void invalidLoginTest() {

        //проверяем тайтл и урл и элементы на странице

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);

        //  проверяем, загрузилась ли страница
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        //   Assert.assertTrue(singInButton.isDisplayed(), "signIn button is not displayed on Login page.");

        linkedInLoginPage.login("qaeng2728 gmail.com","something");

        // переделать красиво для спейдж обжект алерт

        LinkedInAlertPage linkedInAlertPage = new LinkedInAlertPage(driver);
        String alertMessageSample = "There were one or more errors in your submission. Please correct the marked fields below.";
        Assert.assertFalse(linkedInAlertPage.isPageLoaded(),"Alert page is not loaded");
        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessage(),alertMessageSample,"Alert message text is wrong");

        /*WebElement alertMessage = driver.findElement(By.xpath("//span[@id ='session_key-login-error']"));

        Assert.assertEquals(alertMessage.getText(), "Please enter a valid email address.", "Alert message text is wrong");
*/

    }

    @Test
    // логин и пароль валидные, но от разных аккаунтов
    public void noMatchesLoginPswTest() {
        //проверяем тайтл и урл и элементы на странице

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);

        //  проверяем, загрузилась ли страница
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        //   Assert.assertTrue(singInButton.isDisplayed(), "signIn button is not displayed on Login page.");

        linkedInLoginPage.login("qaeng2728@gmail.com","Artemio2728");  LinkedInAlertPage linkedInAlertPage = new LinkedInAlertPage(driver);
        String alertMessageSample = "There were one or more errors in your submission. Please correct the marked fields below.";
        Assert.assertFalse(linkedInAlertPage.isPageLoaded(),"Alert page is not loaded");
        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessage(),alertMessageSample,"Alert message text is wrong");



        // переделать красиво для спейдж обжект алерт

       // WebElement alertMessage = driver.findElement(By.xpath("//div[@role='alert']"));
      /* Assert.assertEquals(alertMessage.getText(),alertMessageSample,"Alert message text is wrong");
        System.out.println(alertMessage.getText());*/

    }

    @Test
    // поле логина пустое
    public void noLoginTest() {
        //проверяем тайтл и урл и элементы на странице

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);

        //  проверяем, загрузилась ли страница
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        //   Assert.assertTrue(singInButton.isDisplayed(), "signIn button is not displayed on Login page.");

        linkedInLoginPage.login("","wrong");

      // сделать красиво

        //Assert.assertFalse(singInButton.isEnabled(), "Incorrect work!");



    }
}