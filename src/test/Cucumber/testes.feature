Feature: Stock Management

  Scenario: Get all stocks
    Given there are existing stocks in the system
    When I request to get all stocks
    Then the system should return a list of stocks

  Scenario: Get stock by ID
    Given there is an existing stock with ID "ABC123"
    When I request to get the stock with ID "ABC123"
    Then the system should return the stock details

  Scenario: Create a new stock
    Given I have stock data with symbol "ABC123", company name "Example Company", and price 10.0
    When I request to create a new stock
    Then the system should return the created stock details

  Scenario: Update an existing stock
    Given there is an existing stock with ID "ABC123"
    And I have updated stock data with symbol "XYZ789" and price 15.0
    When I request to update the stock with ID "ABC123" with the updated data
    Then the system should return the updated stock details

  Scenario: Delete an existing stock
    Given there is an existing stock with ID "ABC123"
    When I request to delete the stock with ID "ABC123"
    Then the stock should be deleted from the system
