package RunnerClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"Feature"},
	glue= {"TestCases"},
	plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	monochrome= true,
	publish = true,
	dryRun= false
	)
public class TestRunner {

}
