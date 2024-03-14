@Placeholder
Feature: Placeholder

  Scenario: Validate Header Link Is Clickable
    Given The user navigates to "http://kristini-bg.com/" URL
    When The user navigates to "Галерия обекти" from the Navigation Menu
    Then Verify "Галерия обекти" page is loaded