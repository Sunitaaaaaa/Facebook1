package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class signup {
	//variable declaration	
	@FindBy (xpath="(//input[@class='inputtext _58mg _5dba _2ph-'])[1]")
	private WebElement firstname;
	
	@FindBy (xpath="(//input[@class='inputtext _58mg _5dba _2ph-'])[2]")
	private WebElement lastname;
	
	@FindBy (xpath="(//input[@class='inputtext _58mg _5dba _2ph-'])[3]")
	private WebElement mobilenumber;
	
	@FindBy (xpath="(//input[@class='inputtext _58mg _5dba _2ph-'])[5]")
	private WebElement newpassword;
	
	@FindBy (xpath="//select[@id='day']")
	private WebElement Day;
	
	@FindBy (xpath="//select[@id='month']")
	private WebElement Month;
	
	@FindBy (xpath="//select[@id='year']")
	private WebElement year;
	
	@FindBy (xpath="(//input[@class='_8esa'])[1]")
	private WebElement female;
	
	@FindBy (xpath="(//input[@class='_8esa'])[2]")
	private WebElement male;
	
	@FindBy (xpath="(//input[@class='_8esa'])[3]")
	private WebElement custom;
	
	@FindBy (xpath="//select[@name='preferred_pronoun']")
	private WebElement pronoum;
	
	@FindBy (xpath="//input[@name='custom_gender']")
	private WebElement optional;
	
	@FindBy (xpath="//button[text()='Sign Up']")
	private WebElement signup;
	
	//variable initalization
	public signup(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//variable use
	
	public void signuppage() throws InterruptedException  {
		firstname.sendKeys("asasfaw");
		lastname.sendKeys("asafawf");
		mobilenumber.sendKeys("sasfaw");
		newpassword.sendKeys("232424124214dwd");
		Select d=new Select(Day);
		d.selectByValue("9");
		
		Select m=new Select(Month);
		m.selectByValue("1");
		
		Select y=new Select(year);
		y.selectByValue("1996");
		
		female.click();
		signup.click();
	
		
		
	}
	
	
}
