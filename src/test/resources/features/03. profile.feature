@PRF
Feature: Profile

  Background:
    Given Navigate to the website

  @PRF01
  Scenario: Ensure there is no profile visible when not logged in
    Then The "Profile" page is displayed
    And Displayed a message guiding the user to log in or register before accessing profile information

  @PRF02
  Scenario: Validation of the Previous and Next buttons is functioning
    And Already logged in and on the Profile page
    When Click Go To Book Store button
    Then The "Book Store" page is displayed
    When Add the following books to the collection:
      | Git Pocket Guide |
      | Learning JavaScript Design Patterns |
      | Speaking JavaScript                 |
      | You Don't Know JS                   |
      | Programming JavaScript Applications |
      | Eloquent JavaScript, Second Edition |
    And Click Profile menu
    Then The "Profile" page is displayed
    And Click Next button
    Then The following book should appear:
      | Eloquent JavaScript, Second Edition |
    When Click Previous button
    Then The following book should appear:
      | Git Pocket Guide                    |
      | Learning JavaScript Design Patterns |
      | Speaking JavaScript                 |
      | You Don't Know JS                   |
      | Programming JavaScript Applications |
    #[ALERT!] FOR TESTING PURPOSES, BOOKS THAT HAVE BEEN ADDED TO THE COLLECTION WILL BE ENTIRELY REMOVED
    #[AUTOMATION TEST] THE 'DELETE ALL' BUTTON BECOMES INVISIBLE AND CANNOT BE CLICKED EVEN THOUGH THE PAGE HAS BEEN SCROLLED DOWN
    #[AS A SOLUTION] CLICK 'NEXT' BUTTON, AND FINALLY, CLICK 'DELETE ALL'
    When Click Next button
    And All books will be deleted for testing purposes

  @PRF03
  Scenario: Validation of the Search feature is functioning
    And Already logged in and on the Profile page
    When Click Go To Book Store button
    Then The "Book Store" page is displayed
    When Add the following books to the collection:
      | Git Pocket Guide |
    And Click Profile menu
    Then The "Profile" page is displayed
    When Input "Git Pocket Guide" in search box
    Then The following book should appear:
      | Git Pocket Guide |
    #[ALERT!] FOR TESTING PURPOSES, BOOKS THAT HAVE BEEN ADDED TO THE COLLECTION WILL BE ENTIRELY REMOVED
    And All books will be deleted for testing purposes

  @PRF04
  Scenario: Validation of the jump to page feature is functioning
    And Already logged in and on the Profile page
    When Click Go To Book Store button
    Then The "Book Store" page is displayed
    When Add the following books to the collection:
      | Git Pocket Guide |
      | Learning JavaScript Design Patterns |
      | Speaking JavaScript                 |
      | You Don't Know JS                   |
      | Programming JavaScript Applications |
      | Eloquent JavaScript, Second Edition |
    And Click Profile menu
    Then The "Profile" page is displayed
    When Input "2" in page box
    Then The following book should appear:
      | Eloquent JavaScript, Second Edition |
    And All books will be deleted for testing purposes

  @PRF05
  Scenario: Validation of the row selection is functioning
    And Already logged in and on the Profile page
    When Click Go To Book Store button
    Then The "Book Store" page is displayed
    When Add the following books to the collection:
      | Git Pocket Guide |
      | Learning JavaScript Design Patterns |
      | Speaking JavaScript                 |
      | You Don't Know JS                   |
      | Programming JavaScript Applications |
      | Eloquent JavaScript, Second Edition |
    And Click Profile menu
    Then The "Profile" page is displayed
    When Select "10" dropdown
    Then The following book should appear:
      | Git Pocket Guide |
      | Learning JavaScript Design Patterns |
      | Speaking JavaScript                 |
      | You Don't Know JS                   |
      | Programming JavaScript Applications |
      | Eloquent JavaScript, Second Edition |
    #[ALERT!] FOR TESTING PURPOSES, BOOKS THAT HAVE BEEN ADDED TO THE COLLECTION WILL BE ENTIRELY REMOVED
    #[AUTOMATION TEST] AFTER USING THE 'ROWS' FUNCTION, THE 'DELETE ALL' BUTTON BECOMES INVISIBLE AND CANNOT BE CLICKED EVEN THOUGH THE PAGE HAS BEEN SCROLLED DOWN
    #[AS A SOLUTION] CLICK 'RETURN TO 5 ROWS', THEN CLICK 'NEXT' BUTTON, AND FINALLY, CLICK 'DELETE ALL'
    When Select "5" dropdown
    And Click Next button
    And All books will be deleted for testing purposes

  @PRF06
  Scenario: Successfully removed a book
    And Already logged in and on the Profile page
    When Click Go To Book Store button
    Then The "Book Store" page is displayed
    When Add the following books to the collection:
      | Git Pocket Guide |
    And Click Profile menu
    Then The "Profile" page is displayed
    And Click Remove button
    And Click OK button
    Then Pop-up alert is displayed saying "Book deleted."
    And The following book has been deleted:
      | Git Pocket Guide |

  @PRF07
  Scenario: Successfully removed all books (one book)
    And Already logged in and on the Profile page
    When Click Go To Book Store button
    Then The "Book Store" page is displayed
    When Add the following books to the collection:
      | Git Pocket Guide |
      | Learning JavaScript Design Patterns |
    And Click Profile menu
    Then The "Profile" page is displayed
    And Click Delete All Books button
    And Click OK button
    Then Pop-up alert is displayed saying "All Books deleted."
    And The following book has been deleted:
      | Git Pocket Guide |
      | Learning JavaScript Design Patterns |

  @PRF08
  Scenario: Ensure error message is displayed when there are no books to delete
    And Already logged in and on the Profile page
    When Click Delete All Books button
    And Click OK button
    Then Pop-up alert is displayed saying "No books available in your's collection!"

  @PRF09
  Scenario: Successfully removed all books (five books)
    And Already logged in and on the Profile page
    When Click Go To Book Store button
    Then The "Book Store" page is displayed
    When Add the following books to the collection:
      | Git Pocket Guide |
      | Learning JavaScript Design Patterns |
      | Speaking JavaScript                 |
      | You Don't Know JS                   |
      | Programming JavaScript Applications |
    And Click Profile menu
    Then The "Profile" page is displayed
    And Click Delete All Books button
    And Click OK button
    Then Pop-up alert is displayed saying "All Books deleted."
    And The following book has been deleted:
      | Git Pocket Guide |
      | Learning JavaScript Design Patterns |
      | Speaking JavaScript                 |
      | You Don't Know JS                   |
      | Programming JavaScript Applications |

  Scenario: [TEST PURPOSES NEEDED, IGNORE IF IT FAILS] Manually delete the entire book collection due to the failure of the preceding scenario.
#  IGNORE IF IT FAILS [INTENDED SOLELY FOR THE DELETION OF THE ENTIRE BOOK]    And Already logged in and on the Profile page
    And Removed all book collections

  @PRF10
  Scenario: Successfully logged out
    And Already logged in and on the Profile page
    When Click Log out button
    Then The "Login" page is displayed

  @PRF11
  Scenario: Successfully deleted the account
    And Already logged in and on the Profile page
    When Click Delete Account button
    When Click OK button
    Then Pop-up alert is displayed saying "User Deleted."
    And The "Login" page is displayed