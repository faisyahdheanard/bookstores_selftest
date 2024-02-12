@CLC
Feature: Collection

  Background:
    Given Navigate to the website
    When Already logged in and on the Profile page

  @CLC01
  Scenario: Successfully added book to the collection
    And Click Go To Book Store button
    Then The "Book Store" page is displayed
    And Click "Git Pocket Guide" title
    And Click Add to your collection button
    Then Pop-up alert is displayed saying "Book added to your collection."
    When Click Profile menu
    Then The "Profile" page is displayed
    Then The following book should appear:
      | Git Pocket Guide |

  @CLC02
  Scenario: Successfully added the same book to the collection
  #THIS TEST IS PERFORMED SEQUENTIALLY FOLLOWING THE PREVIOUS TEST, WHERE THE BOOK IS ALREADY IN THE COLLECTION.
    When Click Go To Book Store button
    Then The "Book Store" page is displayed
    When Click "Git Pocket Guide" title
    And Click Add to your collection button
    Then Pop-up alert is displayed saying "Book already present in the your collection!"
    #[ALERT!] FOR TESTING PURPOSES, BOOKS THAT HAVE BEEN ADDED TO THE COLLECTION WILL BE ENTIRELY REMOVED
    And The book will be deleted for testing purposes
