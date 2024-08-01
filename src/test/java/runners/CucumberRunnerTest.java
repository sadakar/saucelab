package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        glue = {"hooks", "driverfactory", "pagefactory", "runners", "steps", "utilities","petstore"}, // Path to  step definition file
        //tags = "@petCreation",
        plugin = {"pretty",
                "html:target/cucumber/cucumber.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"},
        monochrome = true, // Display the console output in much readable way
        dryRun = false // To check the mapping is proper between feature file and step definition file
)

public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
    // No need to write any code here
}