@validation @all @ios
Feature: Billing Address validation

  Background:
    Given I am on home screen
    When I tap get currency
    And I choose "France" currency to purchase
    And I tap Get
    And I tap Checkout
    And I decline buy back
    And I fill my details as a "Successful" customer
    And I uncheck Remember details
    And I tap continue


  Scenario: Valid House Number/Name entries
    Then I can enter a valid House number or name
      |valid_entry       |
      |house_number      |
      |exactly_50        |
      |less_than_50      |
      |with_spaces       |
      |allowed_characters|


  Scenario: Invalid special characters in House Number/Name
    Then invalid special characters in House Number/Name raise the correct error message
      |character|
      |@@|
      |&&|
      |))|
      |}}|
      |..|
      |//|


  Scenario: Unwanted space removal in House Number/Name
    Then spaces are removed from the beginning of entered House Numbers
      |name|
      | 41 |



  Scenario: Valid Postcode entries
    Then I can enter a valid postcode
      |postcode  |
      |SE19 2AN  |
      |SE192AN   |
      |B5 4SG    |
      |B54SG     |



  Scenario: Invalid postcode entries
    Then invalid postcode entries raise the correct error message
      |postcode |
      |B5 SG    |
      |85 4SG   |
      |BS ABG   |
      |85 123   |
      |SE1942AN |
      |//       |



  Scenario: Empty Postcode field
    Then  Empty postcode field raises the correct error message