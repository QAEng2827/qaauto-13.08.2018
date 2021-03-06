package test;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LinkedInHomePage;
import page.LinkedInLoginPage;
import page.LinkedInSubmitPage;


/**
 * LinkedinLogin Test class.
 */
public class LinkedinLoginTest extends LinkedinBaseTest{

    /** Set of correct cridentials
     * @return - email/password
     */
      @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                {"qaeng2728@gmail.com", "chertopoloh2827"},
                {"QAEng2728@gmail.com", "chertopoloh2827"},

        };
    }

    /**
     * Verify successful user Login.
     *
     * Preconditions:
     * - Open new browser.
     * - Navigate to linkedin.com
     *
     * Scenario:
     * - Verify that login page is loaded.
     * - Enter userEmail.
     * - Enter userPassword.
     * - Click on 'Sign in' button.
     * - Verify Home page is loaded.

     * @param userEmail - email from DataProvider
     * @param userPassword -password from DataProvider
     */
    @Test(dataProvider = "validDataProvider")
    public void successfullLoginTest(String userEmail, String userPassword) {

        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login(userEmail, userPassword);
        Assert.assertTrue(linkedInHomePage.isPageLoaded(), "Home page is not loaded.");

    }

    /** Set of cridentials with one field empty
     * @return - email/password
     */
    @DataProvider
    public Object[][] emptyFieldDataProvider() {
        return new Object[][]{
                {"", "chertopoloh2827"},
                {"QAEng2728@gmail.com", ""},
                {"", ""},
        };
    }

    /**
     * Verify user Login with empty email and/or password.
     *
     *  Preconditions:
     *  Open new browser.
     *  Navigate to linkedin.com
     *
     * Scenario:
     * - Verify that login page is loaded.
     * - Enter empty userEmail/userPassword.
     * - Verify that signIn button disabled and logon impossible
     * @param userEmail - email from DataProvider
     * @param userPassword -password from DataProvider
     */
    @Test(dataProvider = "emptyFieldDataProvider")
    public void emptyUserEmailandUserPassvordTest(String userEmail, String userPassword) {

        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
        LinkedInLoginPage linkedInLoginPagePage = linkedInLoginPage.login(userEmail, userPassword);
        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

    }


    // negative tests

    /** Set of incorrect cridentials
     * @return - email/password
     */
    @DataProvider
    public Object[][] invalidDataProvider() {
        return new Object[][]{

                {"a@b.com", "wrong", "", "The password you provided must have at least 6 characters."},
                { "QAEng2728 gmail com", "chertopoloh2827","Please enter a valid email address.","" },
                { "qaeng2728@gmail.com", "Home Task #1: 1) Add lines of code that will do following actions: - Enter 'selenium' into searchField on google.com web page: - Hit 'Enter' button from keyboard (to get list of search results) 2) Describe environment setup in a separate file: - Create file 'README.md' in a project root folder - In this file describe a list of required actions to setup environment (which tools to download and install, any tricky setup hints)",
                  "","The password you provided must have at most 400 characters."},
                {"Home Task #1: 1) Add lines of code that will do following actions: - Enter 'selenium' into searchField on google.com web page: - Hit 'Enter' button from keyboard (to get list of search results) 2) Describe environment setup in a separate file: - Create file 'README.md' in a project root folder - In this file describe a list of required actions to setup environment (which tools to download and install, any tricky setup hints)",
                "chertopoloh2827","The text you provided is too long (the maximum length is 128 characters, your text contains 428 characters).", ""},
                {"qaeng2728@gmail.com","Artemio2728","", "Hmm, that's not the right password. Please try again or request a new one." }

       };
    }

    /**
     * Verify user Login with wrong email and/or password.
     *
     *  Preconditions:
     *  Open new browser.
     *  Navigate to linkedin.com
     *
     *  Scenario:
     *  - Verify that login page is loaded.
     *  - Enter userEmail.
     *  - Enter userPassword.
     * @param userEmail - email from DataProvider
     * @param userPassword -password from DataProvider
     * @param messageLogin expected message for Login field
     * @param messagePassword expected message for Password field
     */
    @Test(dataProvider = "invalidDataProvider")
    public void negativeloginTest(String userEmail, String userPassword, String messageLogin, String messagePassword) {

        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");

        LinkedInSubmitPage linkedInSubmitPage = linkedInLoginPage.login(userEmail,userPassword);


        Assert.assertTrue(linkedInSubmitPage.isPageLoaded(), "Login submit page is not loaded");

        Assert.assertEquals(linkedInSubmitPage.getAlertMessageText(), "There were one or more errors in your submission. Please correct the marked fields below.",
                "Alert message text is wrong.");
         Assert.assertEquals(linkedInSubmitPage.getUserLoginAlertText(), messageLogin, "userEmail alert is wrong");
         Assert.assertEquals(linkedInSubmitPage.getUserPasswordlAlertText(), messagePassword, "userPassword alert message is wrong");
    }

}


