Feature: End to End Money app tests


  Background:
    Given I am on home screen
    When I tap get currency
    And I choose "France" currency to purchase
    And I tap Get
    And I tap Checkout


  @regression @all
  Scenario: Home delivery End to end test (No cashback)
    When I decline buy back
    And I fill my details as a "Successful" customer
    And I uncheck Remember details
    And I tap continue
    And I enter a "Successful" address
    And I tap Home Delivery
    And I choose a delivery date
    And I enter "Successful" payment details
    And I tap Complete order
    Then I should see successful order message



  @regression @all
  Scenario: Store Collection End to end test (No cashback)
    When I decline buy back
    And I fill my details as a "Successful" customer
    And I uncheck Remember details
    And I tap continue
    And I enter a "Successful" address
    And I tap Store Collection
    And I select a store
    And I choose a delivery date
    And I enter "Successful" payment details
    And I tap Complete order
    Then I should see successful order message



  @regression @all
  Scenario: Home Delivery End to end test (cashback Added)
    When I accept buy back
    And I fill my details as a "Successful" customer
    And I uncheck Remember details
    And I tap continue
    And I enter a "Successful" address
    And I tap Home Delivery
    And I choose a delivery date
    And I enter "Successful" payment details
    And I tap Complete order
    Then I should see successful order message


  @regression @all
  Scenario: Store Collection End to end test (cashback Added)
    When I accept buy back
    And I fill my details as a "Successful" customer
    And I uncheck Remember details
    And I tap continue
    And I enter a "Successful" address
    And I tap Store Collection
    And I select a store
    And I choose a delivery date
    And I enter "Successful" payment details
    And I tap Complete order
    Then I should see successful order message


  @regression @all
  Scenario: Unlisted Address
    When I decline buy back
    And I fill my details as a "Successful" customer
    And I uncheck Remember details
    And I tap continue
    And I enter an unlisted address
    And I tap Continue with store collection
    And I select a store
    And I choose a delivery date
    And I Confirm Reservation
    And I tap Complete order
    Then I should see successful order message


  @regression @all
  Scenario: No Address Match
    When I decline buy back
    And I fill my details as a "Successful" customer
    And I uncheck Remember details
    And I tap continue
    And I enter an Unknown address
    And I tap Continue with store collection
    And I select a store
    And I choose a delivery date
    And I Confirm Reservation
    And I tap Complete order
    Then I should see successful order message