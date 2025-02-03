Feature: User API Tests

  Scenario: Retrieve list of users
    Given the API is available
    When I send a GET request to "/users?page=2"
    Then the response status should be 200
    And the response should contain a list of users

  Scenario: Create a new user
    Given the API is available
    When I send a POST request to "/users" with:
      | name   | job       |
      | John   | QA Lead   |
    Then the response status should be 201
    And the response should contain the new user data

  Scenario: Update an existing user
    Given the API is available
    When I send a PUT request to "/users/2" with:
      | name | job |
      | Jane | Senior Dev |
    Then the response status should be 200
    And the response should contain updated user data
