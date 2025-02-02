@kristiniAccessibilityTests
Feature: Axe Accessibility Automation TCs for Krisitni-BG

  @TC-6 @Accessibility
  Scenario Outline: Contact Us Page - Page Accessibility Scan
    Given The user navigates to "<URL>" URL
    When The user navigates to "<Category>" from the Navigation Menu
    Then Verify "<Category>" page is loaded
    And Verify that the Contact Us form is loaded
    And The user scans the current page for accessibility violations using Axe

    Examples:
      | URL                     | Category  |
      | http://kristini-bg.com/ | Контакти  |
