package Selenium_Assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assessment_testcase2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.myntra.com/");
		 Thread.sleep(3000);
		 WebElement searchBox = driver.findElement(By.className("desktop-searchBar"));
         searchBox.sendKeys("T Shirt");
         searchBox.sendKeys(Keys.ENTER);
         Thread.sleep(4000);
         WebElement firstProduct = driver.findElements(By.className("product-base")).get(0);
         WebElement wishlistButton = firstProduct.findElement(By.xpath(".//span[contains(text(),'wishlist')]"));
         wishlistButton.click();
         Thread.sleep(2000);
         System.out.println("Product added to wishlist.");




	}

}
