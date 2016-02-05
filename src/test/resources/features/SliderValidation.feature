@all
Feature: Slider Order Validation

  Background: Navigate to the Slider
    Given I am on home screen
    And I tap get currency
    And I choose "France" currency to purchase


  Scenario: Below Home Delivery Threshold
    When I go to keypad
    And I enter a spend amount below the home delivery threshold
    And I tap Get
    Then I can see the "lower store collection" message


  Scenario: Above Home Delivery Threshold
    When I go to keypad
    And I enter a spend amount above the home delivery threshold
    And I tap Get
    Then I am in Your order screen


  Scenario: Above Store Delivery Threshold
    When I go to keypad
    And I enter a spend amount above the store delivery threshold
    And I tap Get
    Then I can see the "upper store collection" message


  Scenario: Below Store Delivery Threshold
    When I go to keypad
    Then I enter an amount below the store delivery threshold
    And I tap Get
    Then I am in Your order screen


  Scenario: Maximum Order Threshold on Slider
    When I go to keypad
    And I enter a spend amount above the maximum order threshold
    And I tap Get
    Then I can see the "maximum order amount" message


  Scenario: Maximum Order Threshold Multi-Currency
    When I tap Get
    And I click the Add Currency button
    And I select "USD" as a Second currency country
    And I tap Get
    And I click the Add Currency button
    And I select "AUD" as a Second currency country
    And I enter spend amount "4500"
    Then I can see the "maximum order amount" message