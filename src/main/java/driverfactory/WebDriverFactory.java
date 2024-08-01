package driverfactory;

import utilities.LogUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

/**
 * Factory class to manage WebDriver instances for different browsers.
 * <p>
 * This class provides methods to set, get, and close WebDriver instances.
 * It uses the Factory Design Pattern to create WebDriver instances based on the specified browser type,
 * and utilizes ThreadLocal to ensure each thread has its own WebDriver instance.
 */
public class WebDriverFactory {

    // Private constructor to prevent instantiation
    private WebDriverFactory() {
        // Hide the implementation
    }

    // ThreadLocal to hold WebDriver instances, ensuring one per thread
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Sets up a WebDriver instance based on the specified browser type.
     *
     * @param browserType The type of browser for which the WebDriver instance should be created (e.g., "chrome", "edge").
     * @throws WebDriverException       If there is an issue creating the WebDriver instance.
     * @throws IllegalArgumentException If the provided browser type is not supported.
     */
    public static synchronized void setDriver(String browserType) throws WebDriverException {
        Browser browser;

        // Determine which Browser implementation to use based on the browserType
        switch (browserType.toLowerCase()) {
            case "chrome":
                browser = new ChromeBrowser();
                break;
            case "edge":
                browser = new EdgeBrowser();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }

        // Create and set the WebDriver instance for the current thread
        driver.set(browser.createDriver());
    }

    /**
     * Retrieves the WebDriver instance for the current thread.
     *
     * @return The WebDriver instance associated with the current thread.
     */
    public static synchronized WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Closes and removes the WebDriver instance associated with the current thread.
     * Logs an error if there is an issue closing the WebDriver.
     */
    public static synchronized void closeDriver() {
        if (null != driver.get()) {
            try {
                driver.get().quit(); // Close the WebDriver instance
                driver.remove(); // Remove the WebDriver instance from ThreadLocal
            } catch (WebDriverException e) {
                LogUtil.error(e.getMessage()); // Log error if quitting WebDriver fails
            }
        }
    }
}
