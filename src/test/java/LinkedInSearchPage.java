import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinkedInSearchPage extends LinkedinBasePage{

    private WebElement searchField;

    @FindBy(xpath = "//h3[contains(@class, 'search-results__total')]")
    private WebElement searchResultTotal; // тут массив данных

    @FindBy(xpath = "//li[contains(@class, 'search-result__occluded-item')]")
    private List<WebElement> searchResults;


    // конструктор
    public LinkedInSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded(){
        return driver.getCurrentUrl().contains("search/results/")
                && getCurrentTitle().contains("| Search | LinkedIn") &&
                searchResultTotal.isDisplayed();
    }

    public int getSearchResultsNumber() {
      return searchResults.size();

    }

    public List<String> getSearchResultsList() {
        List<String> serchResultsList = new ArrayList<String>();

        for (WebElement searchResult : searchResults) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", searchResult);
            serchResultsList.add(searchResult.getText());
        }
        return serchResultsList;
    }

}
