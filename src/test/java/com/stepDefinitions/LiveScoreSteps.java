package com.stepDefinitions;

import com.pages.CricbuzzHomePage;
import com.pages.LiveScorePage;

import cucumber.api.java.en.And;

public class LiveScoreSteps extends CricbuzzHomePage {

	
	@And("^I click the recent button$")
	public void click_recent() throws InterruptedException {
	
		LiveScorePage.clickRecent();
        Thread.sleep(1000);
	}
	
	@And("^I click the scorecard$")
	public void click_scorecard() throws Exception {
		
		LiveScorePage home = new LiveScorePage();
		home.clickScorecard();
		Thread.sleep(1000);
	}
	

	@And("^I should get all score details$")
	public void i_should_get_all_score() throws Exception {
		Thread.sleep(1000);
		LiveScorePage.getScoreCard();

	}

}
