@regression @all @ios
Feature: Debit and Credit card charges

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
    And I enter a "Successful" address
    And I tap Home Delivery
    And I choose a delivery date


  Scenario: Cards charge message should be displayed for Credit
    Then I should see card charge message for the following
      |Credit Card      |
      |VISA Credit      |
      |Mastercard Credit|


  Scenario: Cards charge message should not be displayed for Debit
    Then I should not see card charge message for the following
      |Debit Card       |
      |VISA Debit       |
      |Mastercard Debit |