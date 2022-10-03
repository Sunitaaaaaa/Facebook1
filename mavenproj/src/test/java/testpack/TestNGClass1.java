package testpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browserSetup.Base;
import pages.LoginOrSignUppage;
import pages.Messangerpage;
import pages.RoomsPage;

public class TestNGClass1 extends Base {
	private WebDriver driver;
	private LoginOrSignUppage loginOrSignUppage;
	private Messangerpage messangerpage;
	private RoomsPage roomspage;
	private SoftAssert soft;
	@Parameters("browser")
	@BeforeTest
	public void launchbrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		if(browserName.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void createPOMObject() {
		
		loginOrSignUppage=new LoginOrSignUppage(driver);
		
		messangerpage=new Messangerpage(driver);
		roomspage=new RoomsPage(driver);
		soft=new SoftAssert();
		
	}
	@BeforeMethod
	public void goToroompage() {
		driver.get("https://www.facebook.com/");
		loginOrSignUppage.clickonmessanger();
		messangerpage.openRooms();
	}
	
	@Test 
	public void VerifyContactHelpCenter()
	{
		roomspage.goBackToMessenger();
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
//		Assert.assertEquals(url, "https://www.messenger.com/","Messenger is not working");
//		Assert.assertEquals(title, "Messenger");
		soft.assertEquals(url, "https://www.messenger.com/");
		
		soft.assertEquals(title,  "Messenger");
		soft.assertAll();

		

	}
	
	@Test
	public void VerifyReturnToMessanger()
	{
		
		roomspage.contactToHelpCenter();
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
//		Assert.assertEquals(url, "https://www.messenger.com/help");
//		Assert.assertEquals(title, "Messenger Help Centre");
		soft.assertEquals(url, "https://www.messenger.com/help");
		
		soft.assertEquals(title, "Messenger Help Centre");
		soft.assertAll();
		

	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class");
	}
	
	@AfterClass
	public void removeObjects() {
		loginOrSignUppage=null;
		messangerpage=null;
		roomspage=null;
	}
	@AfterTest
	public void closeBrowser()
	{
		System.out.println("After Test");
		driver.close();
		driver=null;
		System.gc();      //Garbage Collector
	}


}
