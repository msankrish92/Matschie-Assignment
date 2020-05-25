package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "./src/test/java/", glue = {"hooks","steps"})
public class OpenWeatherRunner extends AbstractTestNGCucumberTests{

	
	
	
}
