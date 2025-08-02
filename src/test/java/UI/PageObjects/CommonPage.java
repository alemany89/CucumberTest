package UI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonPage {

    protected WebDriver driver;
    private Duration timeOutInSeconds = Duration.ofSeconds(10);

    protected CommonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        waitForPageToBeLoaded();
    }

    protected void WaitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(this.driver, timeOutInSeconds);
        wait.until(d ->
        {
            try {
                return element.isDisplayed();
            } catch (Exception NoSuchElementException) {
                return false;
            }
        });
    }


    protected  void waitForPageToBeLoaded() {
        WebDriverWait wait = new WebDriverWait(this.driver, timeOutInSeconds);
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));

    }

    protected void ClickTo(WebElement element) {
        WebDriverWait wait = new WebDriverWait(this.driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

}