package keywordDrive;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class keywordImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		public void launchBrowser() {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
		}
		public void openurl()
		{
			driver.get("https://demowebshop.tricentis.com/");
		}
		public void searchtf() {
			driver.findElement(By.id("small-searchterms")).sendKeys("computer");
		}
		public void searchbutton() {
			driver.findElement(By.cssSelector("[type='submit']")).click();
		}
		public void closeBrowser()
		{
			driver.quit();
		}
		

	}

}
