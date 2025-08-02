package Steps;

import API.BuilderClasses.ExternalUrlBuilder;
import API.BuilderClasses.SearchBuilder;
import context.World;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

public class ApiSearchStepsDefinition {

    private final World world;

   public ApiSearchStepsDefinition(World world) {
        this.world = world;
    }

    @Given("the user wants to search for the term {string}")
    public void the_user_wants_to_search_for_the_term(String termToSearch) {
        this.world.itemToSearch = termToSearch;
        this.world.searchBuilder= new SearchBuilder();
    }

    @When("the user sends a request to the API")
    public void the_user_sends_a_request_to_the_api() {
        this.world.searchingResponse=this.world.searchBuilder.getSearchResponseSearchingBy(this.world.itemToSearch);
    }
    @Then("the response should have the field {string} with {string}")
    public void i_should_verify_that_on_the_response_the_field_is(String fieldToBeEvaluated, String fieldValueExpected) {
        String currentAbstractSource = this.world.searchingResponse.jsonPath().get(fieldToBeEvaluated);
        Assert.assertEquals(currentAbstractSource, fieldValueExpected);
    }

    @Then("the response should contain a valid {string} field with a URL")
    public void the_response_should_contain_a_valid_field_with_a_url(String abstractURLField) {
        this.world.externalUrl = this.world.searchingResponse.jsonPath().get(abstractURLField);
        Assert.assertNotNull(this.world.externalUrl);
        Assert.assertNotEquals(this.world.externalUrl,"");
    }

    @Then("the user sends a GET request to the provided URL")
    public void the_user_sends_a_get_request_to_the_provided_url() {
        this.world.externalUrlBuilder = new ExternalUrlBuilder();
        this.world.currentExternalUrlStatusCode = this.world.externalUrlBuilder.getStatusCodeFromExternalUrl(this.world.externalUrl);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCodeExpected) {
        Assert.assertEquals(this.world.currentExternalUrlStatusCode, statusCodeExpected);

    }
}

