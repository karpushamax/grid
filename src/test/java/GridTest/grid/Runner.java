package GridTest.grid;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/test.feature"},
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"})
public class Runner {

}
