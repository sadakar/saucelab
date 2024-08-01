package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

/**
 * Implementation of the Browser interface for creating an EdgeDriver instance.
 * This class configures and initializes an EdgeDriver with specific options and preferences.
 * It sets up various EdgeDriver options for browser behavior and performance.
 */
public class EdgeBrowser implements Browser {

    /**
     * Creates and returns a new EdgeDriver instance with configured options.
     *
     * @return An EdgeDriver instance that represents the Microsoft Edge browser.
     * @throws WebDriverException If there is an issue in creating the EdgeDriver instance,
     *                            such as an invalid path to the EdgeDriver executable or issues with EdgeDriver setup.
     */
    @Override
    public WebDriver createDriver() throws WebDriverException {
        // Set the system property for EdgeDriver executable
        System.setProperty("webdriver.edge.driver", "C:\\Tests\\msedgedriver.exe");

        // Create an EdgeOptions instance to set various options for EdgeDriver
        EdgeOptions options = new EdgeOptions();

        // Configure EdgeDriver arguments
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless=new");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-gpu");

        // Initialize EdgeDriver with the configured options
        WebDriver driver = new EdgeDriver(options);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Delete all cookies for a fresh session
        driver.manage().deleteAllCookies();

        return driver;
    }
}
