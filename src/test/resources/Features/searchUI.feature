Feature: Search and navigate to Wikipedia from DuckDuckGo
  @ui
  Scenario: Search for "Toledo" on DuckDuckGo and verify Wikipedia page
    Given the user is on the DuckDuckGo homepage
    When the user searches for "Toledo"
    Then the user clicks on the "wikipedia" link related to it
