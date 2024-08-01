package steps;

import driverfactory.WebDriverFactory;
import pagefactory.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Step definition class for Swag Labs login behavior.
 * Uses TestNG assertions and Gherkin keywords.
 */
public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    public LoginSteps() {
        this.driver = WebDriverFactory.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("the User is on the Swag Labs login page")
    public void navigateToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("the User enters {string} into the username field")
    public void enterUsername(String username) {
        loginPage.setUsernameField(username);
    }

    @When("the User enters {string} into the password field")
    public void enterPassword(String password) {
        loginPage.setPasswordField(password);
    }

    @When("the User clicks on the Login button")
    public void clickOnLogin() {
        loginPage.clickLoginButton();
    }

    @Then("the User should see {string}")
    public void verifyExpectedResult(String expectedResult) {

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html"; // Example of the expected URL after a successful login
        if (expectedResult.equals("redirected to the products page")) {
            Assert.assertEquals(expectedUrl, currentUrl);
        } else {
            String actualErrorMessage = loginPage.getErrorMessage();
            Assert.assertTrue(actualErrorMessage.contains(expectedResult));
        }
    }
}