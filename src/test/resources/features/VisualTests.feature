@kristiniVisualTestCases
Feature: Visual Automation TCs for Krisitni-BG

  @TC-7 @Visual
  Scenario Outline: Gallery Page Visual Test
    Given The user navigates to "<URL>" URL
    When The user enables AppliTools Eyes connection
    When The user navigates to "<Category>" from the Navigation Menu
    Then Verify "<Category>" page is loaded
    When The user starts Visual Test with config - "<App Name>" "<Test Name>" 1000 600
    Then The user ends the AppliTools Eyes connection

    Examples:
      | URL                     | Category | App Name      | Test Name           |
      | http://kristini-bg.com/ | Галерия  | KristiniBatch | Gallery Visual Test |
