package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.LinkedinBasePage;

import java.util.ArrayList;
import java.util.List;

/**
 * LinkedinSearch Object Page
 */
public class LinkedInSearchPage extends LinkedinBasePage {

    private WebElement searchField;

    @FindBy(xpath = "//h3[contains(@class, 'search-results__total')]")
    private WebElement searchResultTotal; // тут массив данных

    @FindBy(xpath = "//li[contains(@class, 'search-result__occluded-item')]")
    private List<WebElement> searchResults;


    /** Costructor of LinkedinSearchPage.
     *
     * Initiate variables with Page Factory, when they are called.
     * @param driver - driver instance from tests.
     */

    public LinkedInSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementVisible(searchResultTotal, 10);
    }

    /**isPageLoaded method - checks URL, title and search results count are found as expected.
     * @return true, when everything found.
     */
    public boolean isPageLoaded(){
        return driver.getCurrentUrl().contains("search/results/")
                && getCurrentTitle().contains("| Search | LinkedIn") &&
                searchResultTotal.isDisplayed();
    }

    /**  * getSearchResultsNumber method - calculates number of found results on page.
     * @return integer size of link list
     */
    public int getSearchResultsNumber() {
      return searchResults.size();

    }

    /*** getSearchReasultList method - scroll to every found result and get it's text.
     * @return String list of text results.
     */
    public List<String> getSearchResultsList() {
        List<String> serchResultsList = new ArrayList<String>();

        for (WebElement searchResult : searchResults) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", searchResult);
            serchResultsList.add(searchResult.getText());
        }
        return serchResultsList;
    }

}
