import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinkedInSearchPage extends LinkedinBasePage{

    private WebElement searchField;


    // конструктор
    public LinkedInSearchPage(WebDriver driver){
        this.driver = driver;
        initElements();
    }

    private void initElements() {

        List<WebElement> searchResults = driver.findElements(By.xpath(".//div[@class='blended-srp-results-js pt0 pb4 ph0 container-with-shadow']/ul/li"));

        System.out.println("Search results count: "+ searchResults.size());

        int searchResultsCount = searchResults.size();

        // распечатать все результаті поиска

        for (WebElement searchResult : searchResults) {
            String searchResultText = searchResult.getText();
            System.out.println(searchResultText);

            //  проверка есть ли искомое слово в резултатах, приводим к нижнему регистру

            if (searchResultText.toLowerCase().contains("HR")){

                System.out.println("SearchTerm found");

            }
            else {
                System.out.println("SearchTerm not found");
            }
        }

        //проверки, что есть именно то колисчество результатов

        if (searchResultsCount == 10){
            System.out.println("Search results count is correct: " + searchResultsCount);

        }
        else {
            System.out.println("Search results count is incorrect: " + searchResultsCount);
        }

//        driver.close();


    }

    public boolean isPageLoaded(){

        return driver.getCurrentUrl().equals("https://www.linkedin.com/search/results/all/?keywords=HR&origin=GLOBAL_SEARCH_HEADER");


    }
}
