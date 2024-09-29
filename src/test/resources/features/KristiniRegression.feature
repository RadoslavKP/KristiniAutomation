@kristiniRegression
Feature: Automation TCs for Navigation Menu

  @TC-1
  Scenario Outline: Validate Header Link Is Clickable
    Given The user navigates to "<URL>" URL
    When The user navigates to "<Category>" from the Navigation Menu
    Then Verify "<Category>" page is loaded

    Examples:
      | URL                     | Category       |
      | http://kristini-bg.com/ | Галерия обекти |

  @TC-2
  Scenario Outline: Navigation to PLP and PDP
    Given The user navigates to "<URL>" URL
    When The user navigates to "<Category>" from the Navigation Menu
    When The user navigates to "<SubCategory>" from the Navigation Menu
    When The user navigate to Sub-Category "<ProductCategory>"
    When The user open product with name "<ProductName>"
    Then Verify PDP is opened


    Examples:
      | URL                     | Category     | SubCategory      | ProductCategory   | ProductName  |
      | http://kristini-bg.com/ | Цени Магазин | Хладилна Техника | Хладилни масла | Errecom      |

  @TC-3
  Scenario Outline: Gallery Page Functionality
    Given The user navigates to "<URL>" URL
    When The user navigates to "<Category>" from the Navigation Menu
    Then Verify "<Category>" page is loaded
    When The user clicks on the 3 image on Gallery page

    Examples:
      | URL                     | Category |
      | http://kristini-bg.com/ | Галерия  |

