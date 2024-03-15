@Placeholder
Feature: Placeholder

  @TC-3
  Scenario Outline: Gallery Page Functionality
    Given The user navigates to "<URL>" URL
    When The user navigates to "<Category>" from the Navigation Menu
    Then Verify "<Category>" page is loaded
    Then Verify Gallery page image slider is displayed
    When The user clicks on the 3 image of the slider
    When The user clicks on the 5 image of the slider

    Examples:
      | URL                     | Category       |
      | http://kristini-bg.com/ | Галерия обекти |