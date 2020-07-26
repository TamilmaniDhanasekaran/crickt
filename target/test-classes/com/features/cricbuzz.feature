Feature: Feature to verify Cricbuzz schedule scenario 


@Cricbuzzschedule 
Scenario: To verify List of all matches except Saturday matches 
	Given I launch the URL 
	And I click the schedule button 
	And I able to get all the schedule match 
	And I verify the list of match to write except saturday matches 
	Then I close the browser

@Australiaseries 
Scenario: To verify all australia series 
	Given I launch the URL 
	And I click the series button
    And I verify the list of australia matches
    Then I close the browser 
    
    
@RecentScorecard
Scenario: To verify the livescore
   Given I launch the URL
   And I click the live score button
   And I click the recent button
   And I click the scorecard
   And I should get all score details
   Then I close the browser	
   