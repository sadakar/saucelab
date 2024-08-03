import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPageActions {
    
    private WebDriver driver;
    
    @FindBy(id = "checkout_button")
    private WebElement checkoutButton;
    
    @FindBy(id = "total_value")
    private WebElement totalValue;
    
    public CartPageActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickCheckoutButton() {
        checkoutButton.click();
    }
    
    public String getTotalValue() {
        return totalValue.getText();
    }
    
    // Include other getters and setters as necessary
}