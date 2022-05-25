Feature: HW1 Functional Testing

   Scenario: Search for Portugal stats
   When I navigate to "http://localhost:7012/"
   And I type "Portugal" as the Country
   And I type "prt" as the ThreeLetterSymbol
   And I click on Submit
   Then I should see the message "Stats"

   Scenario: Search for United States stats
   When I navigate to "http://localhost:7012/"
   And I type "USA" as the Country
   And I type "usa" as the ThreeLetterSymbol
   And I click on Submit
   Then I should see the message "Stats"

   Scenario: Search for World stats
   When I navigate to "http://localhost:7012/"
   And I click on World Stats
   Then I should see the message "Stats"

   Scenario: Search for News
   When I navigate to "http://localhost:7012/"
   And I click on News
   Then I should see the message "News"

   Scenario: Search for invalid Country
   When I navigate to "http://localhost:7012/"
   And I type "Enterro" as the Country
   And I type "prt" as the ThreeLetterSymbol
   And I click on Submit
   Then I should see the error "Oops, something went wrong"

   Scenario: Search for invalid ISO
   When I navigate to "http://localhost:7012/"
   And I type "Portugal" as the Country
   And I type "ua" as the ThreeLetterSymbol
   And I click on Submit
   Then I should see the error "Oops, something went wrong"

   Scenario: Get Cache stats after 6 Requests and 6 Misses
   When I navigate to "http://localhost:7012/cache"
   And I see value of Requests and is "6"
   And I see value of Hits and is "0"
   And I see value of Misses and is "6"

