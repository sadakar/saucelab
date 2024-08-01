package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

/**
 * This interface defines a contract for creating WebDriver instances.
 * Implementations of this interface will provide specific WebDriver instances
 * for different browsers (e.g., Chrome, Firefox, etc.).
 * Implementing classes are responsible for providing the actual driver
 * creation logic based on the browser type.
 */
public interface Browser {

    /**
     * Creates a new WebDriver instance.
     *
     * @return a new WebDriver instance that represents the browser driver
     * @throws WebDriverException if there is an error during the creation of the WebDriver instance
     */
    WebDriver createDriver() throws WebDriverException;
}
