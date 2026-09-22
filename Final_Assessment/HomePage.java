package Final_Assessment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

    By buzz = By.xpath("//span[text()='Buzz']");
    By profile = By.xpath("//span[contains(@class,'oxd-userdropdown-tab')]");
    By logout = By.xpath("//a[text()='Logout']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBuzz() {
        driver.findElement(buzz).click();
    }

    public void clickProfile() {
        driver.findElement(profile).click();
    }

    public void clickLogout() {
        driver.findElement(logout).click();
    }

}
