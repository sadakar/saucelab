import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class OrderProcessSteps {
    private WebDriver driver;
    private MenuPage menuPage;
    private InventoryPage inventoryPage;
    private CheckoutPage checkoutPage;

    public OrderProcessSteps() {
        // Assuming driver initialization code is here
        menuPage = new MenuPage(driver);
        inventoryPage = new InventoryPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Given("User has logged into the application")
    public void userHasLoggedIn() {
        // Assuming login code is here
    }

    @When("User clicks on the {string} button")
    public void userClicksOnButton(String buttonName) {
        switch (buttonName) {
            case "Menu":
                menuPage.clickMenuButton();
                break;
            case "Cart":
                inventoryPage.clickCartButton();
                break;
            case "Checkout":
                checkoutPage.clickCheckoutButton();
                break;
            case "Continue":
                checkoutPage.clickContinueButton();
                break;
            case "Finish":
                checkoutPage.clickFinishButton();
                break;
            default:
                // Log error or throw exception
                break;
        }
    }

    @When("User clicks on {string} in the menu")
    public void userClicksOnInTheMenu(String menuItem) {
        if ("Reset App State".equals(menuItem)) {
            menuPage.clickResetAppState();
        }
    }

    @When("User clicks on {string} button for an item")
    public void userClicksOnAddToCartButtonForAnItem(String button) {
        if ("Add to Cart".equals(button)) {
            inventoryPage.clickAddToCartButton();
        }
    }

    @Then("The item count in the cart should increment")
    public void theItemCountInTheCartShouldIncrement() {
        int itemCount = inventoryPage.getCartItemCount();
        Assert.assertEquals("The cart item count did not increment as expected.", 1, itemCount);
    }

    @Then("The cart should display the added item")
    public void theCartShouldDisplayTheAddedItem() {
        // Assuming there is a method to verify the cart contains the item
    }

    @When("User enters {string} in the {string} field")
    public void userEntersInTheField(String value, String fieldName) {
        switch (fieldName) {
            case "First Name":
                checkoutPage.enterFirstName(value);
                break;
            case "Last Name":
                checkoutPage.enterLastName(value);
                break;
            case "Postal Code":
                checkoutPage.enterPostalCode(value);
                break;
            default:
                // Log error or throw exception
                break;
        }
    }

    @Then("The {string} should display {string}")
    public void theShouldDisplay(String elementName, String expectedValue) {
        String actualValue = "";
        switch (elementName) {
            case "Summary Total":
                actualValue = checkoutPage.getSummaryTotalText();
                break;
            case "Order Confirmation":
                actualValue = checkoutPage.getOrderConfirmationMessage();
                break;
            default:
                // Log error or throw exception
                break;
        }
        Assert.assertEquals("The displayed value is not as expected.", expectedValue, actualValue);
    }
}