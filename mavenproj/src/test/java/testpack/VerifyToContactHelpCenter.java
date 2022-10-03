package testpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginOrSignUppage;
import pages.Messangerpage;
import pages.RoomsPage;

public class VerifyToContactHelpCenter {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PRASAD BANDAL\\OneDrive\\Desktop\\testing\\chromedriver_win32 (1)\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://www.facebook.com/");
		LoginOrSignUppage loginOrSignUppage=new LoginOrSignUppage(driver);
		loginOrSignUppage.clickonmessanger();
		
		Messangerpage messangerpage=new Messangerpage(driver);
		messangerpage.openRooms();
		
		RoomsPage roomsPage=new RoomsPage(driver);
		roomsPage.contactToHelpCenter();
		
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
