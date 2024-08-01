package hooks;

import driverfactory.WebDriverFactory;
import utilities.LogUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriverException;

/**
 * Cucumber Hooks class that manages WebDriver setup and teardown
 * for Cucumber test scenarios.
 * <p>
 * This class uses Cucumber's @Before and @After annotations to
 * handle actions before and after each test scenario.
 */
public class CucumberHooks {

    /**
     * Runs before each test scenario.
     * <p>
     * This method initializes the WebDriver based on the browser type
     * specified in the system properties. It logs the start of the scenario
     * and handles any exceptions that occur during WebDriver setup.
     */
    @Before(order = 0)
    public void beforeScenarioStart() {
        LogUtil.info("This runs before the Scenario");
        String browser = System.getProperty("browser", "chrome");
        try {
            WebDriverFactory.setDriver(browser); // Initialize WebDriver
        } catch (WebDriverException e) {
            LogUtil.error("Unable to get the driver: " + e.getMessage()); // Log error if WebDriver setup fails
        }
    }

    /**
     * Runs after each test scenario.
     * <p>
     * This method closes the WebDriver and performs cleanup after
     * the scenario has finished. It logs the end of the scenario and
     * handles any exceptions that occur during WebDriver teardown.
     */
    @After(order = 0)
    public void afterScenarioEnd() {
        LogUtil.info("This runs after the Scenario");
        try {
            WebDriverFactory.closeDriver(); // Close WebDriver and perform cleanup
        } catch (Exception e) {
            LogUtil.error("Unable to get the driver: " + e.getMessage()); // Log error if WebDriver teardown fails
        }
    }
}
