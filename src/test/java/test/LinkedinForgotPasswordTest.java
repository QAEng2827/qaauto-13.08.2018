package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;

import static java.lang.Thread.sleep;

/**
 * LinkedinSuccessfulPasswordResetTest class
 */
public class LinkedinForgotPasswordTest extends LinkedinBaseTest{

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
               {"qaeng2728@gmail.com", "chertopoloh2827","chertopoloh2827"},
           //    {"qaeng2728@gmail.com", "crocodile2","crocodile2"},
        };
    }

    /**
     * Verify successfull Password Forgot
     *
     * - Open login page
     - Verify login page is loaded - done

     - Press "Forgot password?" - done

     - Verify 'https://www.linkedin.com/uas/request-password-reset?trk=uno-reg-guest-home-forgot-password' page is loaded -done

     Positive test
     - Search field for 'email or phone' and 'Find account' button - done
     - input valid email in it and click on 'Find account' button - done
     - Verify https://www.linkedin.com/checkpoint/rp/request-password-reset-submit page is loaded - done
     - sleep 60 0000 (1 min)- done
     - enter new link from e-mail - done
     - Verify "https://www.linkedin.com/checkpoint/rp/password-reset?requestSubmissionId" page - done
     - Input new password in the fields an click on 'Submit'-button - done
     - Verify https://www.linkedin.com/checkpoint/rp/password-reset-submit page is loaded - done
     - Verify home page is loaded-done

     * @param userEmailOrPhone
     * @param userNewPassword
     * @param userNewPasswordRetype
     * @throws InterruptedException
     */

    @Test(dataProvider= "newPasswordProvider")
    public void positiveForgotPasswordTest(String userEmailOrPhone, String userNewPassword, String userNewPasswordRetype) throws InterruptedException {

        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage =
                linkedInLoginPage.clickOnForgotPasswordLink();
      //  Assert.assertTrue(linkedinRequestPasswordResetPage.isPageLoaded(),
             //   "First request Password reset page is not loaded.");

        LinkedinPasswordResetSubmitPage linkedinPasswordResetSubmitPage =
                linkedinRequestPasswordResetPage.findAccount(userEmailOrPhone);

        //   Assert.assertTrue(linkedinPasswordResetSubmitPage.isPageLoaded(),
     //           "'Please check you email' page is not loaded.");

        LinkedinSetNewPasswordPage linkedinSetNewPasswordPage =
                linkedinPasswordResetSubmitPage.navigateToLinkFromEmail();
      //  Assert.assertTrue(linkedinSetNewPasswordPage.isPageLoaded(),
        //        "'Enter new password' page is not loaded.");

        LinkedinSuccessfulPasswordResetPage linkedinSuccessfulPasswordResetPage =
                linkedinSetNewPasswordPage.submitNewPassword(userNewPassword, userNewPasswordRetype);
     //   Assert.assertTrue(linkedinSuccessfulPasswordResetPage.isPageLoaded(),
            //    "'Your password has been changed' page is not loaded.");


        LinkedInHomePage linkedInHomePage = linkedinSuccessfulPasswordResetPage.clickOnGoToHomeButton();
     //   Assert.assertTrue(linkedInHomePage.isPageLoaded(), "Home page is not loaded");

    }

}



