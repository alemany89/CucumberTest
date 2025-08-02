package context;

import API.BuilderClasses.ExternalUrlBuilder;
import API.BuilderClasses.SearchBuilder;
import UI.PageObjects.SearchPage;
import UI.PageObjects.SearchResultsPage;
import UI.PageObjects.WikipediaPage;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;

public class World {
    public WebDriver driver;
    public SearchPage searchPage;
    public SearchResultsPage searchResultsPage;
    public WikipediaPage wikipediaPage;
    public String itemToSearch;
    public int currentExternalUrlStatusCode;
    public SearchBuilder searchBuilder;
    public ExternalUrlBuilder externalUrlBuilder;
    public String externalUrl;

    public Response searchingResponse;
}
