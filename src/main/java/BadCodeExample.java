import com.sun.corba.se.spi.orbutil.fsm.Input;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.Keys.ENTER;

public class BadCodeExample {

    public static void main( String args[]) {

//        System.out.println("Hello world!");

      WebDriver driver = new ChromeDriver();
       // ожидание
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


//        // загружаем страницу
//
//        driver.get("https://www.google.com/");
//
//        // поиск строки поиска
//        WebElement element;
//        element = driver.findElement(By.xpath("//input[@id='lst-ib']"));
//        element.click();
//
//        //ввод слова для поиска
//        element.sendKeys("selenium");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        element.sendKeys(Keys.ENTER);
//
//        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));
//
//        System.out.println("Search results count: "+ searchResults.size());
//
//        int searchResultsCount = searchResults.size();
//
//        // распечатать все результаті поиска
//
//        for (WebElement searchResult : searchResults) {
//            String searchResultText = searchResult.getText();
//            System.out.println(searchResultText);
//
//            //  проверка есть ли искомое слово в резултатах, приводим к нижнему регистру
//
//            if (searchResultText.toLowerCase().contains("selenium")){
//
//                System.out.println("SearchTerm found");
//
//            }
//            else {
//                System.out.println("SearchTerm not found");
//            }
//        }
//
//        //проверки, что есть именно то колисчество результатов
//
//        if (searchResultsCount == 10){
//            System.out.println("Search results count is correct: " + searchResultsCount);
//
//        }
//        else {
//            System.out.println("Search results count is incorrect: " + searchResultsCount);
//        }
//
//        driver.close();


//    }

        // загружаем страницу
        driver.get("https://www.linkedin.com/");

       // Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/", "Login page URL is wrong.");
       // Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page title is wrong.");

        WebElement userEmailField = driver.findElement(By.xpath("//input[@id = 'login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id = 'login-password']"));
        WebElement singInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));

  //      Assert.assertTrue(singInButton.isDisplayed(), "signIn button is not displayed on Login page.");

        // String loginEmail = "qaeng2728@gmail.com",loginPsw = "chertopoloh2827";
        userEmailField.sendKeys("qaeng2728@gmail.com" );
        userPasswordField.sendKeys("chertopoloh2827");
        singInButton.click();

//        Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home page URL is wrong.");
//        Assert.assertEquals(driver.getTitle(), "LinkedIn", "Page title is wrong.");
//
//        WebElement profileNavItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
//        Assert.assertTrue(profileNavItem.isDisplayed(), "profileNavItem button is not displayed on Home Page");
//
//        driver.get("https://www.linkedin.com/feed/");

        // поиск строки поиска
        WebElement element;
        element = driver.findElement(By.xpath("//*/artdeco-typeahead-deprecated-input/input[@role='combobox']"));
        element.click();
        System.out.println("search field is find");

        //ввод слова для поиска
        element.sendKeys("HR");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        element.sendKeys(Keys.ENTER); //a/ancestor::div[h3]

        List<WebElement> searchResults = driver.findElements(By.xpath("//ul[@class='search-results__list list-style-none']/li"));

        System.out.println("Search results count: " + searchResults.size());

        int searchResultsCount = searchResults.size();

        // распечатать все результаті поиска

        for (WebElement searchResult : searchResults) {
            String searchResultText = searchResult.getText();
            System.out.println(searchResultText);

            //  проверка есть ли искомое слово в резултатах, приводим к нижнему регистру

            if (searchResultText.toLowerCase().contains("HR")) {

                System.out.println("SearchTerm found");

            } else {
                System.out.println("SearchTerm not found");
            }
        }

        //проверки, что есть именно то колисчество результатов

        if (searchResultsCount == 10) {
            System.out.println("Search results count is correct: " + searchResultsCount);

        } else {
            System.out.println("Search results count is incorrect: " + searchResultsCount);
        }

        driver.close();
    }
}
