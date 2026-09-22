package Final_Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase2 {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver() ;
		driver.manage().window().maximize() ;
		driver. manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver. get("https://demoapps.qspiders.com/ui/slider");
		Thread.sleep(2000);
		WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(slider, 100, 0).perform();
		Thread.sleep(2000);
		System.out.println("Slider moved successfully");
		driver.quit();

	}

}
