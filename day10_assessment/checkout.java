package pom2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkout {

    WebDriver driver;
    WebDriverWait wait;

    public checkout(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(15));

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className = "complete-header")
    private WebElement thankYouMessage;

    public void enterFirstName(String fname) {

        wait.until(
                ExpectedConditions.visibilityOf(firstName));

        firstName.sendKeys(fname);
    }

    public void enterLastName(String lname) {

        wait.until(
                ExpectedConditions.visibilityOf(lastName));

        lastName.sendKeys(lname);
    }

    public void enterPostalCode(String postal) {

        wait.until(
                ExpectedConditions.visibilityOf(postalCode));

        postalCode.sendKeys(postal);
    }

    public void clickContinue() {

        wait.until(
                ExpectedConditions.elementToBeClickable(continueButton));

        continueButton.click();
    }

    public String getPageTitle() {

        wait.until(
                ExpectedConditions.visibilityOf(pageTitle));

        return pageTitle.getText();
    }

    public void clickFinish() {

        wait.until(
                ExpectedConditions.elementToBeClickable(finishButton));

        finishButton.click();
    }

    public String getThankYouMessage() {

        wait.until(
                ExpectedConditions.visibilityOf(thankYouMessage));

        return thankYouMessage.getText();
    }
}