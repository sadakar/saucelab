import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
    private WebDriver driver;

    @FindBy(className = "add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartButton;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public int getCartItemCount() {
        // Assuming there's a method to retrieve the cart item count
        return Integer.parseInt(cartButton.getText().replaceAll("[^0-9]", ""));
    }

    public void clickCartButton() {
        cartButton.click();
    }
}