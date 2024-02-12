@LGN
Feature: Login

  Background:
    Given Navigate to the website

  @LGN01
  Scenario: Successfully logged in using valid account
    When Click Login menu
    Then The "Login" page is displayed
    When Input UserName and Password fields with valid data
    And Click Login button
    Then Username is visible in Profile page

  @LGN03
  Scenario: Successfully logged in with unregistered account
    When Click Login menu
    Then The "Login" page is displayed
    When Input UserName and Password fields with unregistered account
    And Click Login button
    Then Error message is displayed saying "Invalid username or password!"

  @LGN02
  Scenario Outline: Ensure signed in is failed in several empty test scenarios
  #[THE EMPTY FIELD WILL TURN RED ON THE FORM AS THE FEEDBACK WITH NO MESSAGE]
  # 1. EMPTY USERNAME AND PASSWORD                     @LGN02
  # 2. EMPTY USERNAME                                  @LGN04
  # 3. EMPTY PASSWORD                                  @LGN05
    When Click Login menu
    Then The "Login" page is displayed
    When Input UserName and Password fields with invalid "<DataType>" data
    And Click Login button
    Then Failed to sign in

    Examples:
      | DataType      |
      | EmptyUserPass |
      | EmptyUsername |
      | EmptyPassword |

  @LGN06
  Scenario Outline: Ensure error message is displayed in several test scenario
  # 1. INVALID USERNAME                                  @LGN06
  # 2. INVALID PASSWORD                                  @LGN07
  # 3. VALID DATA WITH SPACE AT THE END OF USERNAME      @LGN08
    When Click Login menu
    Then The "Login" page is displayed
    When Input UserName and Password fields with invalid "<DataType>" data
    And Click Login button
    Then Error message is displayed saying "Invalid username or password!"

    Examples:
      | DataType        |
      | InvalidUsername |
      | InvalidPassword |
      | ValidWithSpace  |