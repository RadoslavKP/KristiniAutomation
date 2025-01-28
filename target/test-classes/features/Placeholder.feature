@Placeholder
Feature: Placeholder

  @TC-3
  Scenario Outline: Gallery Page Functionality
    Given The user navigates to "<URL>" URL
    When The user navigates to "<Category>" from the Navigation Menu
    Then Verify "<Category>" page is loaded
    When The user clicks on the 3 image on Gallery page
    When The user clicks on "Left" arrow of the photo slider
    Then The user closes the Gallery full screen image

    Examples:
      | URL                     | Category |
      | http://kristini-bg.com/ | Галерия  |

