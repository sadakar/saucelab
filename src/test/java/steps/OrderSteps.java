import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class OrderSteps {
    
    private WebDriver driver;
    private HomePageActions homePageActions;
    private CartPageActions cartPageActions;
    private CheckoutPageActions checkoutPageActions;

    public OrderSteps() {
        driver = // Initialize WebDriver instance here
        homePageActions = new HomePageActions(driver);
        cartPageActions = new CartPageActions(driver);
        checkoutPageActions = new CheckoutPageActions(driver);
    }

    @Given("User is logged in and on the home page")
    public void userIsLoggedInAndOnTheHomePage() {
        // Assume we have a method to ensure the user is logged in and redirected to the home page
        // loginAndRedirectToHomePage();
    }

    @When("User clicks on the {string} button")
    public void userClicksOnTheButton(String button) {
        switch (button) {
            case "Menu":
                homePageActions.clickMenuButton();
                break;
            case "Cart":
                homePageActions.clickCartButton();
                break;
            case "Checkout":
                cartPageActions.clickCheckoutButton();
                break;
            case "Continue":
                checkoutPageActions.clickContinueButton();
                break;
            case "Finish":
                checkoutPageActions.clickFinishButton();
                break;
            default:
                Assert.fail("Button with the name " + button + " is not recognized in the steps.");
        }
    }

    @And("User clicks on {string} in the menu options")
    public void userClicksOnInTheMenuOptions(String option) {
        if ("Reset app state".equals(option)) {
            homePageActions.clickResetAppStateOption();
        } else {
            Assert.fail("Option " + option + " is not recognized in the menu options.");
        }
    }

    @And("User clicks on {string} button for a product")
    public void userClicksOnButtonForAProduct(String button) {
        if ("Add To Cart".equals(button)) {
            homePageActions.clickAddToCartButton();
        } else {
            Assert.fail("Button " + button + " is not recognized for a product.");
        }
    }

    @Then("The cart item count should increment appropriately")
    public void theCartItemCountShouldIncrementAppropriately() {
        // Assume we have a method getCartItemCount() that returns the number of items in the cart
        int itemCount = // getCartItemCount();
        Assert.assertEquals("Item count did not increment as expected.", 1, itemCount);
    }

    @Then("The cart should display the selected item")
    public void theCartShouldDisplayTheSelectedItem() {
        // Assume we have a method to verify the cart displays the selected item
        boolean isItemDisplayed = // verifyCartItem();
        Assert.assertTrue("The cart does not display the selected item.", isItemDisplayed);
    }

    @And("User enters {string} into the {string} field")
    public void userEntersIntoTheField(String value, String field) {
        switch (field) {
            case "First Name":
                checkoutPageActions.enterFirstName(value);
                break;
            case "Last Name":
                checkoutPageActions.enterLastName(value);
                break;
            case "Zip/Postal Code":
                checkoutPageActions.enterPostalCode(value);
                break;
            default:
                Assert.fail("Field " + field + " is not recognized in the checkout form.");
        }
    }

    @Then("The summary total should display {string}")
    public void theSummaryTotalShouldDisplay(String expectedTotal) {
        String actualTotal = cartPageActions.getTotalValue();
        Assert.assertEquals("The summary total does not match the expected value.", expectedTotal, actualTotal);
    }

    @Then("The {string} header should display {string}")
    public void theHeaderShouldDisplay(String header, String expectedText) {
        if ("Order Complete".equals(header)) {
            String actualText = checkoutPageActions.getOrderCompleteHeader();
            Assert.assertEquals("The order complete header does not match the expected text.", expectedText, actualText);
        } else {
            Assert.fail("Header " + header + " is not recognized.");
        }
    }
}