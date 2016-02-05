
Feature: Reject Payment

  Background:
    Given I am on home screen
    When I tap get currency
    And I choose "Germany" currency to purchase
    And I tap Get
    And I tap Checkout
    And I decline buy back
    And I fill my details as a "Rejected" customer
    And I uncheck Remember details
    And I tap continue
    And I enter a "Rejection" address


  Scenario: Payment Rejection Home Delivery
    When I tap Home Delivery
    And I choose a delivery date
    And I enter "Successful" payment details
    And I tap Complete order
    Then I should see rejection order message


  Scenario: Payment Rejection Store Collection
    And I tap Store Collection
    And I select a store
    And I choose a delivery date
    And I enter "Successful" payment details
    And I tap Complete order
    Then I should see rejection order message

