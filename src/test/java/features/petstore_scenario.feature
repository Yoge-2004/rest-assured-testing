Feature: Performing CRUD on Petstore API
  # Author: Yogeshwaran M
  Scenario: Create New Pet
    Given the details of the pet
    When the data are sent using POST request
    Then check whether the status code is 200

  Scenario: Read the created pet
    Given the identifier of the pet
    When the pet id is used to fetch with GET request
    Then verify the pet details

  Scenario: Update the pet details
    Given the details of the pet
    When the data are sent using PUT request
    Then check whether the status code is 200
    Then verify the pet details

    Scenario: Delete the pet
      Given the identifier of the pet
      When the pet id is used to delete using DELETE request
      Then check whether the status code is 404