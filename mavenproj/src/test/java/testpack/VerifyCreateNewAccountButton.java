package testpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginOrSignUppage;
import pages.Messangerpage;
import pages.signup;

public class VerifyCreateNewAccountButton {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PRASAD BANDAL\\OneDrive\\Desktop\\testing\\chromedriver_win32 (1)\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://www.facebook.com/");
		LoginOrSignUppage loginOrSignUppage=new LoginOrSignUppage(driver);
		loginOrSignUppage.opencreatenewaccbutton();
		
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	signup signupp=new signup(driver);
		signupp.signuppage();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		if(url.equals(url)&&title.equals(title))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		
	}

}
