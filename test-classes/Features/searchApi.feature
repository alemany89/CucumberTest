Feature: api search of duckduckgo feature

    @api
    Scenario: Searching for Toledo gives a AbstractSource from Wikipedia
        Given the user wants to search for the term "Toledo"
        When the user sends a request to the API
        Then the response should have the field "AbstractSource" with "Wikipedia"

    @api
    Scenario: Verify successful search for "Toledo" and valid AbstractUrl
        Given the user wants to search for the term "Toledo"
        When the user sends a request to the API
        Then the response should contain a valid "AbstractURL" field with a URL
        And the user sends a GET request to the provided URL
        And the response status code should be 200


