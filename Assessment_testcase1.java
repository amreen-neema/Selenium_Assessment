package Selenium_Assessment;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assessment_testcase1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.saucedemo.com/");
		 driver.findElement(By.id("user-name")).sendKeys("standard_user");
		 driver.findElement(By.id("password")).sendKeys("secret_sauce");
		 driver.findElement(By.id("login-button")).click();
		 Thread.sleep(2000);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 Thread.sleep(2000);
		 TakesScreenshot ts = (TakesScreenshot) driver;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 File destination = new File("screenshots/products-page.png");
		 source.renameTo(destination);
		 System.out.println("Screenshot saved successfully.");
	     driver.quit();

	}

}
