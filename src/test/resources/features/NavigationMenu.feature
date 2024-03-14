@navigationMenu
Feature: Automation TCs for Navigation Menu

  Scenario: Navigation to each of the Menu options
    Given The user navigates to {string} URL
    When The user navigates to {string} from the Navigation Menu
    Then Verify {string} page is loaded
    When The user navigates back using the browser back button
    Then Verify the user is on the Homepage



