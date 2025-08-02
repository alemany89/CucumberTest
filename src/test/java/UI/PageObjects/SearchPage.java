package UI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SearchPage extends CommonPage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[name='q']")
    private WebElement searchBar;

    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;

    public void clickOnSearchBar()
    {
        ClickTo(searchBar);
    }

    public void clickOnSearchButton()
    {
        ClickTo(searchButton);
    }

    public void assertSearchWebPageIsDisplayed()
    {
        WaitForElement(searchBar);
        Assert.assertTrue(searchBar.isDisplayed());
    }

    public void typeOnSearchBar(String text)
    {
        searchBar.sendKeys(text);
    }

}
