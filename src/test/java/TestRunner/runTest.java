package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Features/productAdd.feature"}
		,glue={"stepDefinitions"}
		,dryRun = false
		,monochrome=true
		,plugin = {"pretty","html:target/test-output","json:target/cucumber.json"
		,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		,tags= "@Master"
		)
public class runTest extends AbstractTestNGCucumberTests{

	
}
