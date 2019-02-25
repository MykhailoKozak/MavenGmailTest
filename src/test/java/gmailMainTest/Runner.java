package gmailMainTest;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/gmailTesting.feature", glue = {"gmailMainTest.steps"})
public class Runner extends AbstractTestNGCucumberTests {

}