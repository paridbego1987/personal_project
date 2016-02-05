Feature: Edit and Close options on Basket screen


  Background:
    Given I am on home screen
    When I tap get currency
    And I choose "France" currency to purchase
    And I tap Get
    And I tap continue
    And I decline buy back
    And I fill my details as a "Successful" customer
    And I uncheck Remember details
    And I tap continue
    And I enter a "Successful" address
    And I tap Home Delivery
    And I choose a delivery date


    Scenario: Close Button on basket screen
      When I tap basket icon
      And I tap close
      Then I should be on Payment screen


    Scenario: Edit Button on basket screen
      When I tap basket icon
      And I tap edit
      Then I should be on Slider screen
