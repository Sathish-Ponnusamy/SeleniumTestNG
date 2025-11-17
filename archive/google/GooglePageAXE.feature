Feature: Accessibility testing google page

  As a user verify and validate the accessibility testing passing on the landing page

  Background:
    Given I am on the google home page to perform the accessibility testing using AXE

  Scenario: Successful performing accessibility testing using AXE libraries
    Given Enter the keyword for google search
    When I click on the search button