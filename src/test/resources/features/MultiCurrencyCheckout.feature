@all
Feature: As a frequent traveller I want to view the multiple currencies I've selected, along with any fees, on a single
  checkout screen so that I can place my order for multiple currencies in one go

  Background: Navigate to Your Order
    Given I am on home screen
    And I tap get currency
    And I choose "France" currency to purchase
    And I go to keypad
    And I tap Get
    And I click the Add Currency button
    And I select "USD" as a Second currency country
    And I tap Get
    And I tap Checkout


  Scenario: Multi Currency checkout NON Buyback
    And I decline buy back
    And I fill my details as a "Successful" customer
    And I uncheck Remember details
    And I tap continue
    And I enter a "Successful" address
    And I tap Home Delivery
    And I choose a delivery date
    And I enter "Successful" payment details
    And I am on the Checkout screen
    Then buyback is not selected in the checkout screen
    And all fees are calculated correctly
    And "USD" and "EUR" currencies are displayed in order of selection


  Scenario: Multi Currency checkout WITH Buyback
    And I accept buy back
    And I fill my details as a "Successful" customer
    And I uncheck Remember details
    And I tap continue
    And I enter a "Successful" address
    And I tap Home Delivery
    And I choose a delivery date
    And I enter "Successful" payment details
    And I am on the Checkout screen
    Then buyback is selected in the checkout screen
    And the buyback correctly reflects the number of currencies I am ordering
    And all fees including Buyback are calculated correctly
    And "USD" and "EUR" currencies are displayed in order of selection
