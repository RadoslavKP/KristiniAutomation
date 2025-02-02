@kristiniRegression
Feature: Automation Regression TCs for Kristini-BG

  @TC-1
  Scenario Outline: Validate Header Link Is Clickable
    Given The user navigates to "<URL>" URL
    When The user navigates to "<Category>" from the Navigation Menu
    Then Verify "<Category>" page is loaded

    Examples:
      | URL                     | Category |
      | http://kristini-bg.com/ | Галерия  |

  @TC-2
  Scenario Outline: Navigation to PLP and PDP
    Given The user navigates to "<URL>" URL
    When The user navigates to "<Category>" from the Navigation Menu
    When The user navigates to "<SubCategory>" from the Navigation Menu
    When The user open product with name "<ProductName>"
    Then Verify PDP is opened

    Examples:
      | URL                     | Category     | SubCategory      | ProductName  |
      | http://kristini-bg.com/ | Цени магазин | Хладилна техника | Dixell       |

  @TC-3 #TC will fail due to product bug with slider arrows!
  Scenario Outline: Gallery Page Functionality
    Given The user navigates to "<URL>" URL
    When The user navigates to "<Category>" from the Navigation Menu
    Then Verify "<Category>" page is loaded
    When The user clicks on the 3 image on Gallery page
    When The user clicks on "Left" arrow of the photo slider
    When The user clicks on "Right" arrow of the photo slider
    Then The user closes the Gallery full screen image

    Examples:
      | URL                     | Category |
      | http://kristini-bg.com/ | Галерия  |

  @TC-4
  Scenario Outline: Contact Us Page - Form Functionality
    Given The user navigates to "<URL>" URL
    When The user navigates to "<Category>" from the Navigation Menu
    Then Verify "<Category>" page is loaded
    And Verify that the Contact Us form is loaded
    When The user submits the Contact Us Form
    Then Verify Contact Us validation is triggered for mandatory fields
    When The user populates the Contact Us form
    When The user submits the Contact Us Form
    Then Verify Contact Us form is submitted

    Examples:
      | URL                     | Category  |
      | http://kristini-bg.com/ | Контакти  |

  @TC-5
  Scenario Outline: Search Functionality
    Given The user navigates to "<URL>" URL
    When The user opens the Search bar
    When The user types "Dixell" in the Search bar and submits
    Then Verify search page is loaded

    Examples:
      | URL                     |
      | http://kristini-bg.com/ |

  @TC-6
  Scenario Outline: Contact Us Page - Page Accessibility Scan
    Given The user navigates to "<URL>" URL
    When The user navigates to "<Category>" from the Navigation Menu
    Then Verify "<Category>" page is loaded
    And Verify that the Contact Us form is loaded
    And The user scans the current page for accessibility violations using Axe

    Examples:
      | URL                     | Category  |
      | http://kristini-bg.com/ | Контакти  |