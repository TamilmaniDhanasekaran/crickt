package com.stepDefinitions;

import com.pages.CricbuzzHomePage;
import com.pages.CricbuzzSchedulePages;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CricbuzzHomeSteps extends CricbuzzHomePage  {


	
	@Given("^I launch the URL$")
	public void home_Page() throws Exception {

		launchBrowser();

		Thread.sleep(1000);

	}

	@And("^I click the schedule button$")
	public void click_button() throws Exception {
		CricbuzzHomePage home = new CricbuzzHomePage();
		home.clickSchedule();
		Thread.sleep(2000);

	}

	@And("^I able to get all the schedule match$")
	public void get_allMatch() throws Exception {
		CricbuzzHomePage home = new CricbuzzHomePage();
		home.getAllMatch();
		Thread.sleep(2000);

	}

	@And("^I verify the list of match to write except saturday matches$")
	public void get_Schedule() throws Exception {

		CricbuzzSchedulePages schPage = new CricbuzzSchedulePages();
		schPage.scheduleMatch_writeData();
		Thread.sleep(2000);

	}

	@And("^I click the series button")
	public void click_series_button() throws InterruptedException {
		CricbuzzHomePage home = new CricbuzzHomePage();
		home.clickSeries();
		Thread.sleep(1000);
	}
	
	@And("^I click the live score button$")
	public void click_livescore() throws InterruptedException {
		CricbuzzHomePage home = new CricbuzzHomePage();
		home.clickLivescore();
		Thread.sleep(1000);
		
	}
	
//	@And("^I click the recent button$")
//	public void click_recent() throws InterruptedException {
//		CricbuzzHomePage home = new CricbuzzHomePage();
//        home.clickRecent();
//        Thread.sleep(1000);
//	}
	
	
	
	@Then("^I close the browser$")
	public void closeBrowser() {
		
		driver.quit();
	}
}

