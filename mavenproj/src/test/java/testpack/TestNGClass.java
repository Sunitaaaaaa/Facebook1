package testpack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
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
import utils.Utility;

public class TestNGClass extends Base {
	
	private WebDriver driver;
	private LoginOrSignUppage loginOrSignUppage;
	private Messangerpage messangerpage;
	private RoomsPage roomspage;
	private SoftAssert soft;
	
	int testID;
	@Parameters("browser")
	@BeforeTest
	public void launchbrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			
			driver=openChromeBrowser();
		}
		if(browserName.equals("Firefox"))
		{
			
			driver=openFirefoxBrowser();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void createPOMObject() throws IllegalStateException, IOException {
		
		loginOrSignUppage=new LoginOrSignUppage(driver);
		messangerpage=new Messangerpage(driver);
		roomspage=new RoomsPage(driver);
		soft=new SoftAssert();
		
	}
	@BeforeMethod
	public void goToroompage() throws EncryptedDocumentException, IOException {
		driver.get("https://www.facebook.com/");
		//loginOrSignUppage.clickonmessanger();
		
	}
	
	@Test (priority=1)
	public void login() throws EncryptedDocumentException, IOException, InterruptedException {
		testID=3321;
		String data=Utility.getID( 0,0);
		loginOrSignUppage.sendUserName(data);
		String data1=Utility.getID(0,0);
		loginOrSignUppage.sendPassword(data1);
		Thread.sleep(2000);
		loginOrSignUppage.clickOnloginpage();
	}
	
	
	@Test (priority=2)
	public void VerifyContactHelpCenter()
	{
		testID=1121;
		roomspage.goBackToMessenger();
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
//		Assert.assertEquals(url, "https://www.messenger.com/","Messenger is not working");
//		Assert.assertEquals(title, "Messenger");
		soft.assertEquals(url, "https://www.messenger.com/");
		
		soft.assertEquals(title,  "Messenger");
		soft.assertAll();

		

	}
	
	@Test(priority=3)
	public void VerifyReturnToMessanger()
	{
		testID=2221;
		roomspage.contactToHelpCenter();
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
//		Assert.assertEquals(url, "https://www.messenger.com/help");
//		Assert.assertEquals(title, "Messenger Help Centre");
		soft.assertEquals(url, "https://www.messenger.com/help");
		
		
		soft.assertAll();
		

	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
	if(ITestResult.FAILURE==result.getStatus())
	{
		Utility.captureScreenshot(driver, testID);
	}
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
