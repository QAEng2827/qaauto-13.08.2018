import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

       driver.quit();
    }
    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "qaeng2728@gmail.com", "chertopoloh2827"},
                { "QAEng2728@gmail.com", "chertopoloh2827"},

        };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfullLoginTest(String userEmail, String userPassword) {

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login(userEmail,userPassword);

        Assert.assertTrue(linkedInHomePage.isPageLoaded(), "Home page is not loaded.");
    }

    @DataProvider
    public Object[][] emptyFieldDataProvider() {
        return new Object[][]{
                { "", "chertopoloh2827"},
                { "QAEng2728@gmail.com", ""},
                { "", ""},

        };
    }
    @Test (dataProvider = "emptyFieldDataProvider")
    public void emptyUserEmailandUserPassvordTest(String userEmail, String userPassword) {

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
        LinkedInLoginPage linkedInLoginPagePage = linkedInLoginPage.login(userEmail,userPassword);
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

    }

   // @Test // done



    // negative tests

    @DataProvider
    public Object[][] invalidDataProvider() {
        return new Object[][]{
                { "a@b.com", "wrong", "Please enter a valid email address.","The password you provided must have at least 6 characters."},
//                { "QAEng2728@gmail.com", "chertopoloh2827"},
//                { "", "chertopoloh2827"},

        };
    }

    @Test (dataProvider = "invalidDataProvider")
   public void negativeloginTest(String userEmail, String userPassword, String messageLogin, String messagePassword) {

        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
        LinkedInAlertPage linkedInAlertPage = linkedInLoginPage.login(userEmail, userPassword);

        System.out.println(linkedInLoginPage.login(userEmail,userPassword));
        Assert.assertTrue(linkedInAlertPage.isPageLoaded(), "Login page is not loaded");

        linkedInAlertPage.isAlertVisible(messagePassword);

     // Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessageExtra(messageLogin),alertMessageExtraSample,"Alert message text is wrong");
    }
}


//        linkedInLoginPage.login("a@b.com","wrong");
//
//        LinkedInAlertPage linkedInAlertPage = new LinkedInAlertPage(driver);
//        String alertMessageSample = "There were one or more errors in your submission. Please correct the marked fields below.";
//        String alertMessageExtraSample = "The password you provided must have at least 6 characters.";
//        WebElement alertMessagePath = driver.findElement(By.xpath("//span[@id ='session_password-login-error']"));
//
//        Assert.assertFalse(linkedInAlertPage.isPageLoaded(),"Alert page is not loaded");
//
//        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessage(),alertMessageSample,"Alert message text is wrong");
//        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessageExtra(alertMessagePath),alertMessageExtraSample,"Alert message text is wrong");
//
//    }
//
//    @Test // done
//    public void tooLongPswTest() {
//
//        //проверяем тайтл и урл и элементы на странице
//        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
//
//        //  проверяем, загрузилась ли страница
//        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
//
//        linkedInLoginPage.login("qaeng2728@gmail.com","Home Task #1:" +
//                "1) Add lines of code that will do following actions:" +
//                "- Enter 'selenium' into searchField on google.com web page." +
//                "- Hit 'Enter' button from keyboard (to get list of search results)" +
//                "2) Describe environment setup in a separate file:" +
//                "- Create file 'README.md' in a project root folder" +
//                "- In this file describe a list of required actions to setup environment (which tools to download and install, any tricky setup hints)");
//
//        LinkedInAlertPage linkedInAlertPage = new LinkedInAlertPage(driver);
//        String alertMessageSample = "There were one or more errors in your submission. Please correct the marked fields below.";
//        Assert.assertFalse(linkedInAlertPage.isPageLoaded(),"Alert page is not loaded");
//        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessage(),alertMessageSample,"Alert message text is wrong");
//
//        String alertMessageExtraSample = "The password you provided must have at most 400 characters.";
//        WebElement alertMessagePath = driver.findElement(By.xpath("//span[@id ='session_password-login-error']"));
//        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessageExtra(alertMessagePath),alertMessageExtraSample,"Alert message text is wrong");
//
//        Assert.assertTrue(linkedInAlertPage.getCurrentAlertMessageExtra(alertMessagePath).contains("The password you provided must have at most 400 characters."), "Есть такой текст");
//
//        }
//
//
//    @Test //done
//    // логин и пароль валидные, но от разных аккаунтов
//    public void noMatchesLoginPswTest() {
//        //проверяем тайтл и урл и элементы на странице
//
//        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
//
//        //  проверяем, загрузилась ли страница
//        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
//
//        linkedInLoginPage.login("qaeng2728@gmail.com","Artemio2728");
//
//        LinkedInAlertPage linkedInAlertPage = new LinkedInAlertPage(driver);
//        String alertMessageSample = "There were one or more errors in your submission. Please correct the marked fields below.";
//        String alertMessageExtraSample = "Hmm, that's not the right password. Please try again or request a new one.";
//        WebElement alertMessagePath = driver.findElement(By.xpath("//*[@id='session_password-login-error']"));
//
//        Assert.assertFalse(linkedInAlertPage.isPageLoaded(),"Alert page is not loaded");
//        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessage(),alertMessageSample,"Alert message text is wrong");
//        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessageExtra(alertMessagePath),alertMessageExtraSample,"Alert message text is wrong");
//
//    }
//
//    @Test // why? wtf?
//    public void invalidLoginTest() {
//
//        //проверяем тайтл и урл и элементы на странице
//        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
//
//        //  проверяем, загрузилась ли страница
//        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
//        linkedInLoginPage.login("qaeng2728 gmail.com","something");
//
//        LinkedInAlertPage linkedInAlertPage = new LinkedInAlertPage(driver);
//        String alertMessageSample = "There were one or more errors in your submission. Please correct the marked fields below.";
//        String alertMessageExtraSample = "Please enter a valid email address.";
//        WebElement alertMessagePath = driver.findElement(By.xpath("//span[@id='session_key-login-error']"));
//
//        Assert.assertFalse(linkedInAlertPage.isPageLoaded(),"Alert page is not loaded");
//        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessage(),alertMessageSample,"Alert message text is wrong");
//        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessageExtra(alertMessagePath),alertMessageExtraSample,"Alert message text is wrong");
//
//
//    }
//
//    @Test // done
//    public void tooLongLoginTest() {
//
//        //проверяем тайтл и урл и элементы на странице
//
//        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(driver);
//
//        //  проверяем, загрузилась ли страница
//        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
//
//        linkedInLoginPage.login("Home Task #1:" +
//                        "1) Add lines of code that will do following actions:" +
//                        "- Enter 'selenium' into searchField on google.com web page." +
//                        "- Hit 'Enter' button from keyboard (to get list of search results)" +
//                        "2) Describe environment setup in a separate file:" +
//                        "- Create file 'README.md' in a project root folder" +
//                        "- In this file describe a list of required actions to setup environment (which tools to download and install, any tricky setup hints)@b.com",
//                "chertopoloh2827");
//
//        LinkedInAlertPage linkedInAlertPage = new LinkedInAlertPage(driver);
//        String alertMessageSample = "There were one or more errors in your submission. Please correct the marked fields below.";
//        Assert.assertFalse(linkedInAlertPage.isPageLoaded(), "Alert page is not loaded");
//        Assert.assertEquals(linkedInAlertPage.getCurrentAlertMessage(), alertMessageSample, "Alert message text is wrong");
//
//        WebElement alertMessagePath = driver.findElement(By.xpath("//span[@id ='session_key-login-error']"));
//
//        Assert.assertTrue(!linkedInAlertPage.getCurrentAlertMessageExtra(alertMessagePath).contains("The text you provided is too long (the maximum length is 128 characters"), "Not contains");
//*/
//    }
 //   }

