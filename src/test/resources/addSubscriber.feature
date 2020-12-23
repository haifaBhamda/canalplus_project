Feature: To save the subscriber with subscriber details

  Scenario: client makes call to POST  /api/createSubscriber to save the subscriber
    Given the subscriber with subscriber first name "barath" , subscriber last name "réno",streetAddress "14 rue du chateau boulogne billancourt",country "France",zipCode "92100"
    When the client calls "/api/createSubscriber" with the given details
    Then the client receives status code of 200
    And the response contains customer name "barath",subscriber last name "réno",streetAddress "14 rue du chateau boulogne billancourt",country "France",zipCode "92100"
