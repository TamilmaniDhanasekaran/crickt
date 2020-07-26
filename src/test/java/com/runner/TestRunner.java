package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/dtm/Desktop/cricbuzzUI/src/test/java/com/features/cricbuzz.feature", 
		glue = {"com/stepDefinitions" },
     tags= {"@Australiaseries"})


//@Cricbuzzschedule
//@Australiaseries
//@RecentScorecard


public class TestRunner {

}


