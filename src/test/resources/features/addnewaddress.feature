Feature: Adding a new address to user account
  As a user
  I want to log in to my account
  So that I can add new address

#@done
  Scenario Outline: Successfully add a new user address
    Given a logged out user is on the home page
    And the user clicks "Sign in" button in the upper right corner
    And the user fills the email and the password fields
    And the user clicks "SIGN IN" button
    And the user is on the Addresses page
    And the user click in "Create new address" button
    And the user correctly fills required fields "<Alias>", "<Address>", "<City>", "<Zip_code>", "<Country>", "<Phone>"
    And the user clicks "SAVE"
    Then my addresses page should include the new address, the account page should display message "Address successfully added!"
    Examples:
      | Alias | Address | City | Zip_code | Country | Phone |
      |CodersUser | 15 main street | London | 00-000 | United Kingdom | 123456789 |