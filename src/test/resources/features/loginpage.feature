Feature: Login Functionality for OpenCart E-Commerce Website

  As a user of the OpenCart Website
  I want to be able to login with my account
  So that I can access my account related features and manage my orders

 Background:
   Given I am on the OpenCart Login page

 Scenario: Successful login with valid credentials
   Given I have entered a valid username and password
   When I click on the login button
   Then I should be able to login successfully

Scenario Outline: Unsuccessful login with invalid or empty credentials
  Given I have entered invalid "<username>" and "<password>"
  When I click on the login button
  Then I should see an error message indicating "<error_message>"

  Examples:
    | username  | password  | error_message                                         |
    | sathish   | sathish   | Warning: No match for E-Mail Address and/or Password. |
    | ponnusamy | ponnusamy | Warning: No match for E-Mail Address and/or Password. |

  Scenario: Navigating to the forgotten password page
   When I click on the "Forgotten Password" link
#   Then I should be redirected to the password reset page

