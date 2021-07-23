Feature: Testing WebOrder Application
  @orders1
  Scenario: Verifying create order module
    Given User logs in with credential username "Tester" password "test"
    Then User click on Order
    Then User create order
      | Quantity | Customer | Street | City        | Zip    | Card | Card NR          | Expire Date |
      | 1        | James    | York   | Chicago     | 60001  | Visa | 12344555         | 01/22       |
      | 1        | Chris    | Devon  | Des Plaines | 8000   | Visa | 97t698043769     | 03/24       |
      | 2        | Sarah    | Clark  | New York    | 734587 | Visa | 9045094759043275 | 09/22       |

    Then User click on View Orders
    And User verifies that orders are created
    |Customer name|
    |James        |
    |Chris        |
    |Sarah        |
