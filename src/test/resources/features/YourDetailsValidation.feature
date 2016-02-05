@validation @all @ios
Feature: Your Details Validation

  Background: Navigate to Your Details
    Given I am on home screen
    When I tap get currency
    And I choose "France" currency to purchase
    And I tap Get
    And I tap Checkout
    And I decline buy back


  Scenario: Title Validation
    Then I can choose any title
    |title|
    |Mr  |
    |Ms  |
    |Miss |
    |Ms  |
    |Dr  |
    |Capt. |
    |Prof.|


  Scenario: Empty Title fields
    Then  Empty title field raises the correct error message


  Scenario: Empty Input fields
    Then  Empty input fields raise the correct error message
      |empty_field   |
      |First_Name    |
      |Surname       |
      |DOB           |
      |Mobile_Number |
      |Email         |


  Scenario: Valid First and Last Name entries
    Then I can enter a valid First name and Surname
      |valid_name        |
      |exactly_50        |
      |less_than_50      |
      |with_spaces       |
      |allowed_characters|


  Scenario: Invalid special characters
    Then invalid special characters raise the correct error message
    |character|
    |@@|
    |&&|
    |))|
    |}}|
    |22|
    |..|
    |//|


  Scenario: Unwanted space removal
    Then spaces are removed from the beginning of entered names
      |name   |
      | Tester|


  Scenario: Invalid Date Format DOB
    Then an invalid date in the DOB field raises the correct error message
    |date    |
    |50041980|
    |23501980|
    |10101   |
    |101019  |
    |1010190 |
    |00000000|
    |30021980|
    |01      |
    |103     |
    |1012    |


  Scenario: Underage DOB
    Then an underage date in the DOB field raises the correct error message
      |date    |
      |10122000|


  Scenario: Overage DOB
    Then an overage date in the DOB field raises the correct error message
      |date    |
      |31121900|


  Scenario: Future DOB
    Then a future date in the DOB field raises the correct error message
      |date    |
      |10102020|


  Scenario: Valid DOB entry
    Then I can enter valid dates in the DOB field
      |date    |
      |02091981|
      |02091902|
      |02091997|


  Scenario: Invalid Email formats
    Then invalid email formats raise the correct error message
      |email_type     |
      |missing_symbol |
      |missing_domain |


  Scenario: Valid Email entry
   Then I can enter a valid email address
     |email            |
     |tester@test.com  |
     |tester@test.co.uk|
     |123@test.com     |
     |123@123.com      |


  Scenario: Invalid Mobile Numbers
    Given Entering an invalid mobile number raises the correct error message
      |number_type    |
      |less_than_11   |
      |bad_first_digit|


  Scenario: More than 11 digits in Mobile Number
    Then  I cannot enter more than 11 digits in the Mobile Number field


  Scenario: Valid Mobile Number
    Then I can enter a valid Mobile number
      |number_type   |
      |uk_mobile     |


  Scenario: Clear Field icon
    Then I can clear all text fields using the Clear icon
      |field         |
      |First_Name    |
      |Surname       |
      |DOB           |
      |Mobile_Number |
      |Email         |
