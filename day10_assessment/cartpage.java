package pom2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cartpage {

    WebDriver driver;
    WebDriverWait wait;

    public cartpage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15));

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']")
    private WebElement backpackName;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public String getBackpackName() {

        wait.until(
                ExpectedConditions.visibilityOf(backpackName));

        return backpackName.getText();
    }

    public void clickCheckout() {

        wait.until(
                ExpectedConditions.elementToBeClickable(checkoutButton));

        checkoutButton.click();

        System.out.println("Checkout button clicked");
    }
}