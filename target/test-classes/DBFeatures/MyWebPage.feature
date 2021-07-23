
@uidb
Feature: JDBC verification


  Scenario: Post in UI and Verify in DB

  Given User navigate to "http://www.techtorialacademy.dev.cc/"
  And User authorized to make DB calls
  When User adds new post
  Then User queries the post from DB

Scenario:Post in API and Verify in DB
  When User sends post request from API
  Then status code is 201
  And User queries the post from DB

  Scenario: Post in DB and verify in DB
    Given User authorized to make DB calls
    When User creates post in DB
    Then Verify published post in DB  with results queries of DB


  Scenario: Post in DB and verify in UI
    Given User logs in DB
    When User creates post in DB
    Then Verify published post in DB  with UI posts


      Scenario: Post in UI and verify in UI
Given User navigates to UI
        When Add new posts in UI
        Then Verify UI posts with UI