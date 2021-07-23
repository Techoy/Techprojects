# new feature
# Tags: optional

Feature: Testing My Application
@db @jiraid-TED-8780
  Scenario: Verify table data with DB
    Given User navigates to My Application homepage
    And User gets the data from UI table
  Then Verify data is matched with DB

