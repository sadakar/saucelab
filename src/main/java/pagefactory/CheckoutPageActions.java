import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPageActions {
    
    private WebDriver driver;
    
    @FindBy(id = "first_name")
    private WebElement firstNameField;
    
    @FindBy(id = "last_name")
    private WebElement lastNameField;
    
    @FindBy(id = "postal_code")
    private WebElement postalCodeField;
    
    @FindBy(id = "continue_button")
    private WebElement continueButton;
    
    @FindBy(id = "finish_button")
    private WebElement finishButton;
    
    @FindBy(id = "order_complete_header")
    private WebElement orderCompleteHeader;
    
    public CheckoutPageActions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }
    
    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }
    
    public void enterPostalCode(String postalCode) {
        postalCodeField.sendKeys(postalCode);
    }
    
    public void clickContinueButton() {
        continueButton.click();
    }
    
    public void clickFinishButton() {
        finishButton.click();
    }
    
    public String getOrderCompleteHeader() {
        return orderCompleteHeader.getText();
    }
    
    // Include other getters and setters as necessary
}