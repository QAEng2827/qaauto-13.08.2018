package test;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LinkedInHomePage;
import page.LinkedInSearchPage;

import java.util.List;

public class LinkedInSearchTest extends  LinkedinBaseTest {

    @FindBy(xpath = ".//div[@class='blended-srp-results-js pt0 pb4 ph0 container-with-shadow']/ul/li" )
    private WebElement searchResult; // тут массив данных

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                {"qaeng2728@gmail.com", "chertopoloh2827"},
               // {"QAEng2728@gmail.com", "chertopoloh2827"},

        };
    }

    /*- Open login page
- Verify login page is loaded
- Login with valid credentials
- Verify home page is loaded
- Search for 'hr' Searchterm
- Verify Search page is loaded
- Verify 10 results displayed on search page
- Verify each result item contains searchTerm

*/

    @Test(dataProvider = "validDataProvider")
    public void basicSearchTest(String userEmail, String userPassword) {
        String searchTerm = "HR";

        Assert.assertTrue(linkedInLoginPage.isPageLoaded(), "Login page is not loaded");
        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login(userEmail, userPassword);
        Assert.assertTrue(linkedInHomePage.isPageLoaded(), "Home page is not loaded.");

        LinkedInSearchPage linkedInSearchPage = linkedInHomePage.search(searchTerm);
        Assert.assertTrue(linkedInSearchPage.isPageLoaded(), "Search page is not loaded.");

        Assert.assertEquals(linkedInSearchPage.getSearchResultsNumber(), 10, "Wrong number of searchResults on Search page.");
        List<String> searchResultsList = linkedInSearchPage.getSearchResultsList();
         for (String searchResult : searchResultsList){
             Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                     "SearchTerm "+searchTerm+" not found in:\n"+searchResult );
         }

    }
}
