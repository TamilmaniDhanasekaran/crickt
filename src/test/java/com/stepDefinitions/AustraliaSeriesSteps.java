package com.stepDefinitions;

import com.pages.AustraliaSeriesPage;



import cucumber.api.java.en.And;

/**
 * @author Tamilmani Dhanasekaran
 * 
 * 
 * This method is used to write steps for the features wrote
 */
public class AustraliaSeriesSteps  {
	

	
	@And("^I verify the list of australia matches$")
	public void listOfAustraliaMatches() throws Exception {
		
		AustraliaSeriesPage ss=new AustraliaSeriesPage();
		ss.writeSeries();
		
	}
	

}

