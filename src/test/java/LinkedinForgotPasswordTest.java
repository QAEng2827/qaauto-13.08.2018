import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LinkedinForgotPasswordTest {
    WebDriver driver;
    LinkedInLoginPage linkedInLoginPage;


    @BeforeMethod
    public void beforeMethod() {
        //   открываем браузер и заходим на страницу
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        linkedInLoginPage = new LinkedInLoginPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
      //  driver.quit();
    }

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                {"qaeng2728@gmail.com",""},
                 {"QAEng2728@gmail.com", ""},
        };
    }

    @DataProvider
    public Object[][] newPasswordProvider() {
        return new Object[][]{
               {"", "crokodile1"},
           //     {"", "crokodile2"},
        };
    }

///* - Open login page
//- Verify login page is loaded - done
//
//- Press "Forgot password?"
//
//- Verify 'https://www.linkedin.com/uas/request-password-reset?trk=uno-reg-guest-home-forgot-password' page is loaded
//
// Positive test
//- Search field for 'email or phone' and 'Find account' button
//- input valid email in it and click on 'Find account' button
//- Verify https://www.linkedin.com/checkpoint/rp/request-password-reset-submit page is loaded
//- sleep 12 000 (2 min)
//- enter new link from e-mail
//- Verify "https://www.linkedin.com/checkpoint/rp/password-reset?requestSubmissionId" page ( messages "Finally, choose a new password." and
//"Password must include at least 8 characters including at least 1 number or 1 special character.", 'new password' field and
//'Retype new password'field and 'Submit' button)
//- Input new password in the fields an click on 'Submit'-button
//- Verify https://www.linkedin.com/checkpoint/rp/password-reset-submit page is loaded (message "Your password has been changed successfully",
//"Go to homepage" button)
//- click on "Go to homepage" button
//- Verify home page is loaded
//
//     Negativ test
//
//     - input ivalid email in it and click on 'Find account' button
//- Verify https://www.linkedin.com/checkpoint/rp/request-password-reset-submit page is loaded
//-
//
//
//    */
    @Test(dataProvider= "newPasswordProvider")
    public void positiveForgotPasswordTest(String userEmail, String userNewPassword) {

        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
        LinkedinFirstRequestPasswordResetPage linkedinFirstRequestPasswordResetPage = linkedInLoginPage.isLoadFirstRequestPasswordResetPage();
//    Assert.assertTrue(linkedinFirstRequestPasswordResetPage.isPageLoaded(), "First request Password reset page is not loaded.");
//    LinkedinRequestPasswordResetSubmitPage linkedinRequestPasswordResetSubmitPage = linkedinFirstRequestPasswordResetPage.isLoadedRequestPasswordResetSubmitPage();
//    Assert.assertTrue();

    }

}
