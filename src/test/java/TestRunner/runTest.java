package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Features/"}
		,glue={"stepDefinitions"}
		,dryRun = false
		,monochrome=true
		,plugin = {"pretty","html:test-output"
		,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		,tags= "@Master"
		)
public class runTest extends AbstractTestNGCucumberTests{

	
}
