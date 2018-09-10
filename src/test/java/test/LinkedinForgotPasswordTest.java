package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;

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
               {"qaeng2728@gmail.com", "crokodile1","crokodile1"},
           //     {"", "crokodile2"},
        };
    }

/* - Open login page
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

    */
    @Test(dataProvider= "newPasswordProvider")
    public void positiveForgotPasswordTest(String userEmailOrPhone, String userNewPassword, String userNewPasswordRetype) {

        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        LinkedinFirstRequestPasswordResetPage linkedinFirstRequestPasswordResetPage =
                linkedInLoginPage.clickOnForgotPassword();
        Assert.assertTrue(linkedinFirstRequestPasswordResetPage.isPageLoaded(),
                "First request Password reset page is not loaded.");

        LinkedinRequestPasswordResetSubmitPage linkedinRequestPasswordResetSubmitPage =
                linkedinFirstRequestPasswordResetPage.findAccount(userEmailOrPhone);
        Assert.assertTrue(linkedinRequestPasswordResetSubmitPage.isPageLoaded(),
                "'Please check you email' page is not loaded.");

        LinkedinPasswordResetPage linkedinPasswordResetPage =
                linkedinRequestPasswordResetSubmitPage.checkEmail();
        Assert.assertTrue(linkedinPasswordResetPage.isPageLoaded(),
                "'Enter new password' page is not loaded.");

        LinkedinPasswordResetSubmitPage linkedinPasswordResetSubmitPage =
                linkedinPasswordResetPage.resetPassword(userNewPassword, userNewPasswordRetype);
        Assert.assertTrue(linkedinPasswordResetSubmitPage.isPageLoaded(),
                "'Your password has been changed' page is not loaded.");


        LinkedInHomePage linkedInHomePage = linkedinPasswordResetSubmitPage.isHomePageLoaded();
        Assert.assertTrue(linkedInHomePage.isPageLoaded(), "Home page is not loaded");

    }

}



