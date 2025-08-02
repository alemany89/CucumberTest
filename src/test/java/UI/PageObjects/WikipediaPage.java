package UI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class WikipediaPage extends CommonPage{
    public WikipediaPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span.mw-page-title-main")
    private WebElement wikipediaArticleTitle;

    private String getWikipediaArticleTitle() {
        return wikipediaArticleTitle.getText();
    }

    public void assertWikipediaArticleTitleIsDisplayed() {
        WaitForElement(wikipediaArticleTitle);
    }

    public void assertWikipediaArticleTitleIs(String expectedTitle) {
        Assert.assertEquals(getWikipediaArticleTitle(), expectedTitle);
    }

}
