package UI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage extends CommonPage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "a[data-testid='result-extras-url-link']")
    private List<WebElement> urlSourcesSearchResults;



    public void clickOnResultHavingText(String text) {
        WebElement elementFound = urlSourcesSearchResults.stream().filter(e -> e.getText().contains(text)).findFirst().get();
        ClickTo(elementFound);
    }

    public void assertSearchResultsAreDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> !urlSourcesSearchResults.isEmpty());
        WaitForElement(urlSourcesSearchResults.get(0));
        Assert.assertTrue(urlSourcesSearchResults.get(0).isDisplayed());
    }


}
