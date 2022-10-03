package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Messangerpage {
	//Variable declaration
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy (xpath="//a[text()='Rooms']")
	private WebElement room;
	
	@FindBy (xpath="//a[text()='Features']")
	private WebElement feature;
	
	
	
	//variable initilization
	
	
	public Messangerpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		//wait=new WebDriverWait(driver,20);
		
	}
	
	
	//variable use
	public void openRooms()
	{
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(room));
		room.click();
		
	}
	public void openFeatures()
	{
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(feature));
		feature.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
