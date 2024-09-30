@Placeholder
Feature: Placeholder

  @TC-3
  Scenario Outline: Gallery Page Functionality
    Given The user navigates to "<URL>" URL
    When The user enables AppliTools Eyes connection
    When The user navigates to "<Category>" from the Navigation Menu
    Then Verify "<Category>" page is loaded
    When The user starts Visual Test with config - "<App Name>" "<Test Name>" 1920 1080
    Then The user ends the AppliTools Eyes connection



    Examples:
      | URL                     | Category       | App Name    | Test Name  |
      | http://kristini-bg.com/ | Галерия        | TestAppName | TestName1  |