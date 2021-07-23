@ui
Feature: Testing Etsy Web Application

  Background:
    Given User is on Etsy homepage


  @etsy1 @jiraid1234
  Scenario: Verifying title of the Etsy App

    Then User verifies homepage title "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone"


  @etsy2
  Scenario Outline: Verifying each section of etsy webPage
    When User clicks on "<section>"
    Then User verifies "<title>" of title
    Examples:
      | section               | title                         |
      | Jewelry & Accessories | Jewelry & Accessories \| Etsy |
      | Clothing & Shoes      | Clothing & Shoes \| Etsy      |
      | Home & Living         | Home & Living \| Etsy         |
      | Wedding & Party       | Wedding & Party \| Etsy       |
      | Toys & Entertainment  | Toys & Entertainment \| Etsy  |
    @etsy3
    Scenario Outline:Verify searched item displayed in search results
      When User searches for "<item>"
      Then Verify that "<item>" is displayed in search message

      Examples:
      |item|
      |macbook|
      |house  |

      @etsy4
      Scenario: Verifying that items price rage is properly displayed
        When User searches for "<laptop>"
        Then User selects over 50 price ranges
        And User verifies that result prices are over 50