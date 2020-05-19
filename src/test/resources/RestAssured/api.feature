Feature: Addplace
 Add a place in google
  Scenario: Addplace in NL
      Given a new address
      When user enters a valid address
      Then address is added successfully