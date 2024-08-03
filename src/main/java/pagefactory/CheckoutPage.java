import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    @FindBy(id = "checkout_button")
    private WebElement checkoutButton;

    @FindBy(id = "first_name")
    private WebElement firstNameField;

    @FindBy(id = "last_name")
    private WebElement lastNameField;

    @FindBy(id = "postal_code")
    private WebElement postalCodeField;

    @FindBy(id = "continue_button")
    private WebElement continueButton;

    @FindBy(className = "summary_total")
    private WebElement summaryTotal;

    @FindBy(id = "finish_button")
    private WebElement finishButton;

    @FindBy(className = "complete-header")
    private WebElement orderConfirmationMessage;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
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

    public String getSummaryTotalText() {
        return summaryTotal.getText();
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public String getOrderConfirmationMessage() {
        return orderConfirmationMessage.getText();
    }
}