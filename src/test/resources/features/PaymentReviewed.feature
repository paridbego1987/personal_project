@all @ios
Feature: Review Customer

  Background:
    Given I am on home screen
    When I tap get currency
    And I choose "Germany" currency to purchase
    And I tap Get
    And I tap Checkout
    And I decline buy back
    And I fill my details as a "Review" customer
    And I uncheck Remember details
    And I tap continue
    And I enter a "Review" address

  Scenario: Payment Review Home Delivery
    When I tap Home Delivery
    And I choose a delivery date
    And I enter "Successful" payment details
    And I tap Complete order
    Then I should see review order message


  Scenario: Payment Review Store Collection
    And I tap Store Collection
    And I select a store
    And I choose a delivery date
    And I enter "Successful" payment details
    And I tap Complete order
    Then I should see review order message