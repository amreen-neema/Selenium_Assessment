package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vacancy {
	
	WebDriver driver;
	public Vacancy(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
   
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement Vname;
	
	@FindBy(xpath="//div[@class='oxd-select-text oxd-select-text--active']")
	private WebElement Jtite;
	
	@FindBy(xpath="//div[@role='option']//span[normalize-space(text())='Software Engineer']")
	private WebElement JJ;
	
	@FindBy(xpath="//textarea[@placeholder='Type description here']")
	private WebElement Desc;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement HireManager;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
	private WebElement position;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	private WebElement save;
	
	

	public void getVname(String value) {
		Vname.sendKeys(value);
	}

	public void getJtite() throws AWTException {
		  
	       Jtite.click();
	       JJ.click();
	   
		
	}

	public void getDesc(String value) {
		Desc.sendKeys(value);
	}


	public void getHireM(String value) throws AWTException, InterruptedException {
		HireManager.sendKeys(value);
		Thread.sleep(2000);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_DOWN);
        r1.keyRelease(KeyEvent.VK_DOWN);

        r1.keyPress(KeyEvent.VK_ENTER);
        r1.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	public void getPos(String value) {
		position.sendKeys(value);
	}
	
	public void getsave() {
		save.click();
	}

}
