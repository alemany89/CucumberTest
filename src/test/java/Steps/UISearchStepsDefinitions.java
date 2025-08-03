package Steps;

import UI.PageObjects.SearchPage;
import UI.PageObjects.SearchResultsPage;
import UI.PageObjects.WikipediaPage;
import context.World;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UISearchStepsDefinitions {
    private final World world;

    public UISearchStepsDefinitions(World world) {
        this.world = world;
    }

    private static String DUCKDUCKGO_URL = "https://duckduckgo.com/";


    @Given("the user is on the DuckDuckGo homepage")
    public void the_user_is_on_the_duck_duck_go_homepage() {
        this.world.driver.get(DUCKDUCKGO_URL);
        this.world.searchPage = new SearchPage(this.world.driver);
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String termToSearch) {
        this.world.searchPage.assertSearchWebPageIsDisplayed();
        this.world.searchPage.clickOnSearchBar();
        this.world.searchPage.typeOnSearchBar(termToSearch);
        this.world.searchPage.clickOnSearchButton();
        this.world.searchResultsPage = new SearchResultsPage(this.world.driver);
    }

    @Then("the user clicks on the {string} link related to it")
    public void the_user_clicks_on_the_wikipedia_link_related_to_it(String textLinkToClick) {
        this.world.searchResultsPage.assertSearchResultsAreDisplayed();

    }

    @Then("the user should see {string} in the title inside the Wikipedia page")
    public void the_user_should_see_in_the_title_inside_the_wikipedia_page(String expectedTitle) {
        this.world.wikipediaPage.assertWikipediaArticleTitleIsDisplayed();
        this.world.wikipediaPage.assertWikipediaArticleTitleIs(expectedTitle);
    }


}
