package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features"
		,glue = {"stepDefinition"} //connecting cucumber scenario on gherkin with step definitions
		)

public class TestRunner {
	
}