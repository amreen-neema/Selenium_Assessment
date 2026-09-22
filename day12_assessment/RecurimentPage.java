package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RecurimentPage {
	
	WebDriver driver;
	public RecurimentPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@href='/web/index.php/recruitment/viewRecruitmentModule']")
	private WebElement Rbutton;
	
	@FindBy(xpath="//a[text()='Vacancies']")
	private WebElement vacy;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement add;
	
	public WebDriver getDriver() {
		return driver;
	}

	public void getRbutton() {
		Rbutton.click();
	}

	public void getVacy() {
		vacy.click();
	}	
	
	public void getAdd() {
		add.click();
	}	
}
