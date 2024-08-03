import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;

    @Given("User is logged into SauceDemo with valid credentials")
    public void userIsLoggedIntoSauceDemoWithValidCredentials() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        productPage = new ProductPage(driver);
    }

    @When("User navigates to the product page")
    public void userNavigatesToTheProductPage() {
        // Assuming that the login action redirects to the product page
    }

    @And("User resets the application state")
    public void userResetsTheApplicationState() {
        productPage.resetApplicationState();
    }

    @And("User adds a product to the cart")
    public void userAddsAProductToTheCart() {
        productPage.addFirstProductToCart();
    }

    @And("User navigates to the cart")
    public void userNavigatesToTheCart() {
        productPage.navigateToCart();
    }

    @And("User proceeds to checkout")
    public void userProceedsToCheckout() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.proceedToCheckout();
    }

    @And("User enters first name {string}, last name {string}, and postal code {string}")
    public void userEntersFirstNameLastNameAndPostalCode(String firstName, String lastName, String postalCode) {
        checkoutPage.enterFirstName(firstName);
        checkoutPage.enterLastName(lastName);
        checkoutPage.enterPostalCode(postalCode);
    }

    @And("User completes the purchase")
    public void userCompletesThePurchase() {
        checkoutPage.completePurchase();
    }

    @Then("User should be presented with a confirmation message {string}")
    public void userShouldBePresentedWithAConfirmationMessage(String expectedMessage) {
        String actualMessage = checkoutPage.getConfirmationMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
        driver.quit();
    }
}
