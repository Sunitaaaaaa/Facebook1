package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrSignUppage {
	
	//Variable declaration
	
	@FindBy (xpath = "//input[@id='email']")
	private WebElement Username;

	@FindBy (xpath = "//input[@id='pass']")
	private WebElement Password;
	
	@FindBy (xpath = "//button[text()='Log In']")
	private WebElement Login;
	
	@FindBy (xpath = "//a[text()='Create New Account']")
	private WebElement createnewacc;

	@FindBy (xpath = "//a[text()='Messenger']")
	private WebElement Messenger;

	
	//Variable Initialization
	public LoginOrSignUppage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//variable use
	public void sendUserName(String user)
	{
		Username.sendKeys(user);
	}
	
	public void sendPassword(String password)
	{
		Password.sendKeys(password);
	}

	public void clickOnloginpage()
	{
		Login.click();
	}
	
	public void opencreatenewaccbutton()
	{
		createnewacc.click();
	}
	
	public void clickonmessanger()
	{
		Messenger.click();
	}

	//OR
	public void loginToApplication()
	{
		Username.sendKeys("Sunitadhanwate2014@gmail.com");
		Password.sendKeys("123546777");
		Login.click();
		//Messenger.click();
		//createnewacc.click();
		
		
	}



























}
