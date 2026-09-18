package pom2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class productPage {

    WebDriver driver;
    WebDriverWait wait;

    public productPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15));

        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[text()='Products']")
    private WebElement productsTitle;


    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpack;


    @FindBy(className = "shopping_cart_link")
    private WebElement cart;


    public String getProductsTitle() {

        wait.until(
                ExpectedConditions.visibilityOf(
                        productsTitle));

        return productsTitle.getText();
    }


    public void addBackpack() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        backpack));

        backpack.click();

        System.out.println(
                "Sauce Labs Backpack added to cart");
    }


    public String getCartCount() {

        WebElement badge =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                By.className(
                                        "shopping_cart_badge")));

        return badge.getText();
    }


    public void clickCart() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        cart));

        cart.click();

        System.out.println(
                "Cart opened");
    }
}