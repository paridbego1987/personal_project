@regression @all @ios
Feature: I want to order multiple currencies within the same order so that I don't have to
  repeatedly go through the checkout

  Background: Navigate to Your Order
    Given I am on home screen
    When I tap get currency
    And I choose "France" currency to purchase
    And I tap Get


  Scenario: Add Another Currency button visibility
    Then I can see the Add Currency button


  Scenario: Add Another Currency button functionality
    When I click the Add Currency button
    Then I can see the Currency List screen


  Scenario: Adding Another Currency to my Order
    Given I click the Add Currency button
    And I select "USD" as a Second currency country
    And I tap Get
    Then both "EUR" and "USD" are displayed in the Your Order screen
    And the subtotal includes my total spend for all currencies


#  Scenario: Adding the Same Currency to my Order
#    Given I click the Add Currency button
#    Then "Euro" currency is disabled for selection


  Scenario: Editing Currency in my Single Currency Order
    Given I tap Edit currency
    And I tap the Amend icon
    And I enter a spend amount
      |spend  |
      |900    |
    And I tap Get
    And the spend amount is updated in Your Order
    And the subtotal includes my total spend for all currencies


  Scenario: Deleting Currency from my Multi Currency Order
    Given I click the Add Currency button
    And I select "USD" as a Second currency country
    And I tap Get
    When I tap Edit currency
    And I remove one currency
    And I tap Done editing
    Then "EUR" is the only currency displayed in the Your Order screen


  Scenario: Deleting Currency from my Single Currency Order
    When I tap Edit currency
    And I remove the only currency
    Then I am returned to the Home Screen


  Scenario: Cancelling a Delete action from my Order
    When I tap Edit currency
    And I tap the Remove icon
    And I cancel the Remove alert
    Then I am returned to Your Order Screen
    And "EUR" is the only currency displayed in the Your Order screen


  Scenario: Going back from Your order screen on a single currency
    When I tap Back
    Then I go back to the slider


  Scenario: Going back from Your order screen having more than one currency
    Given I click the Add Currency button
    And I select "USD" as a Second currency country
    And I tap Get
    And both "EUR" and "USD" are displayed in the Your Order screen
    And I tap Back
    And I am presented with a confirmation prompt
    When I tap I'll stay here
    Then I am in Your order screen


  Scenario: Going back to Slider and clearing multiple currencies
    Given I click the Add Currency button
    And I select "USD" as a Second currency country
    And I tap Get
    And both "EUR" and "USD" are displayed in the Your Order screen
    And I tap Back
    And I am presented with a confirmation prompt
    When I tap Clear them
    Then I go back to the slider
