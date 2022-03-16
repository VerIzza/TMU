package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class TestRun {

	@CucumberOptions(
			features = "/src/test/resources/features",
			glue = {"steps"}
			)
	public class FirstTestRunner extends AbstractTestNGCucumberTests{

	}
}
