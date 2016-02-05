@validation @all @ios
Feature: Payment field validation

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
    And I enter a valid address
    And I tap Home Delivery
    And I choose a delivery date


  Scenario: Valid Card Number entries
    Then I can enter a valid Card number
      |valid_numbers    |
      |VISA Credit      |
      |VISA Debit       |
      |Mastercard Credit|
      |Mastercard Debit |
      |Solo             |
      |Maestro          |


  Scenario: Empty Card number field
    Then  Empty card number field raises the correct error message


  Scenario: Amex Card number
    Then Amex Card number raises the correct error message


  Scenario: Valid Expiry date
    Then I can enter a valid card expiry Date


  Scenario: More than 20 year Future Expiry date
    Then a card expiry date more than twenty years in the future raises the correct error message


  Scenario: Past Expiry date
    Then a past card expiry date raises the correct error message


  Scenario: Invalid Expiry dates
    Then invalid card expiry date formats raise the correct error message


  Scenario: Empty card expiry field
    Then  Empty card expiry field raises the correct error message


  Scenario: Valid CVV
    Then I can enter a valid cvv
      |valid_cvv|
      |123      |
      |1234     |


  Scenario: Empty CVV field
    Then  Empty CVV field raises the correct error message


  Scenario: Invalid CVV entries
    Then invalid cvv entries raise the correct error message
      |invalid_cvv|
      |1          |
      |12         |
