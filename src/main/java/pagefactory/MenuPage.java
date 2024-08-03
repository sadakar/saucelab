package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
    WebDriver driver;

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;

    @FindBy(id = "reset_sidebar_link")
    WebElement resetAppButton;

    @FindBy(id = "//*[@id='header_container']/div[2]/span")
    WebElement productsLabel;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openMenu() {
        menuButton.click();
    }

    public void resetApplication() {
        resetAppButton.click();
    }
}


