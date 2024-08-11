Feature: Purchasing products on the website
  As a user
  I want to log in to my account
  So that I can purchasing new products

  @done
   Scenario Outline: :
    Given a logged out user is on the home page 2
    And the user clicks "Sign in" button in the upper right corner 2
    And the user fills the email and the password fields 2
    And the user clicks "SIGN IN" button 2
    And the user choose women clothes option
    And the user clicks in Hummingbird printed sweater
    And the user choose "<size>" and  "<quantity>"
    And the user add this products to cart
    And the user go to checkout option
    And the user confirms address
    And the user choose Self pick up method
    And the user choose "Pay by Check" payment method
    And the user clicks on "order with an obligation to pay"
    And the user take a screenshot with order confirmation
    And the user check the correctness of the order
     Examples:
       | size | quantity |
       |M     |5         |