Feature: Search and navigate to Wikipedia from DuckDuckGo
  @ui
  Scenario: Search for "Toledo" on DuckDuckGo and verify Wikipedia page
    Given the user is on the DuckDuckGo homepage
    When the user searches for "Toledo"
    And the user clicks on the "wikipedia" link related to it
    Then the user should see "Toledo" in the title inside the Wikipedia page