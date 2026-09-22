package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyInfo {
	
	WebDriver driver;
    WebDriverWait wait;

    public MyInfo(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // My Info
    By myInfo =
            By.xpath("//span[text()='My Info']");

    // First Name
    By firstName =
            By.xpath("//label[text()='First Name']/../following-sibling::div//input");

    // Last Name
    By lastName =
            By.xpath("//label[text()='Last Name']/../following-sibling::div//input");

    // Employee ID
    By employeeId =
            By.xpath("//label[text()='Employee Id']/../following-sibling::div//input");

    // Save button
    By save =
            By.xpath("//button[@type='submit']");


    public void clickMyInfo() {

        wait.until(
                ExpectedConditions.elementToBeClickable(myInfo)
        ).click();
    }


    public void enterFirstName(String name) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstName)
        ).clear();

        driver.findElement(firstName).sendKeys(name);
    }


    public void enterLastName(String name) {

        driver.findElement(lastName).clear();

        driver.findElement(lastName).sendKeys(name);
    }


    public void enterEmployeeId(String id) {

        driver.findElement(employeeId).clear();

        driver.findElement(employeeId).sendKeys(id);
    }


    public void clickSave() {

        wait.until(
                ExpectedConditions.elementToBeClickable(save)
        ).click();
    }


    public String getFirstName() {

        return driver.findElement(firstName)
                .getAttribute("value");
    }


    public String getLastName() {

        return driver.findElement(lastName)
                .getAttribute("value");
    }


    public String getEmployeeId() {

        return driver.findElement(employeeId)
                .getAttribute("value");
    }
}
