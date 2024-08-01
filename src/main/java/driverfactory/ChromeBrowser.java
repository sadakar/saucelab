package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Implementation of the Browser interface for creating a ChromeDriver instance.
 * <p>
 * This class configures and initializes a ChromeDriver with specific options and preferences.
 * It sets up various ChromeDriver options for browser behavior and performance.
 */
public class ChromeBrowser implements Browser {

    /**
     * Creates and returns a new ChromeDriver instance with configured options.
     *
     * @return A ChromeDriver instance that represents the Chrome browser.
     * @throws WebDriverException If there is an issue in creating the ChromeDriver instance,
     *                            such as an invalid path to the ChromeDriver executable or issues with ChromeDriver setup.
     */
    @Override
    public WebDriver createDriver() throws WebDriverException {
        // Set the system property for ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Tests\\chromedriver.exe");

        // Create ChromeOptions instance to set various options for ChromeDriver
        ChromeOptions options = new ChromeOptions();

        // Add arguments to configure ChromeDriver behavior
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");
        options.addArguments("--disable-gpu");

        // Initialize ChromeDriver with the configured options
        WebDriver driver = new ChromeDriver(options);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Delete all cookies for a fresh session
        driver.manage().deleteAllCookies();

        return driver;
    }
}
