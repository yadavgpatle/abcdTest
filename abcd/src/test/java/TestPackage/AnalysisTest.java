package TestPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BasePackage.Base;
import PomClass.AnalysisPage;
import PomClass.LoginPage;



public class AnalysisTest extends Base{
	
	private WebDriver driver;
	LoginPage loginpage;
	AnalysisPage ana;
	
	
	
	
	@BeforeTest
	@Parameters ("browser")
	public void launchBrowser(String browser) throws InterruptedException {
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = openChromeBrowser();
		}
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver = openFirefoxBrowser();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://my.exness.com/accounts/sign-in");
	}
	
	@BeforeClass
	public void createPOMobject()
	{
		loginpage = new LoginPage(driver);
		AnalysisPage ana = new AnalysisPage(driver);
		
	}
	
	@BeforeMethod
	public void loginToApplocation() throws InterruptedException
	{
		loginpage.UserName();
	    loginpage.Pass();
		loginpage.continueButton();
		ana.Analysis();
		
		
		
		
	}
	
	@Test
	public void verify()
	{
		ana.Calander();
		
	}
	
	@AfterMethod
	public void logoutApplication()
	{
		System.out.println("End");
	}
	
	@AfterClass
	public void clearPOMobject() throws InterruptedException
	{
		loginpage = null;
		
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
		driver = null;
		System.gc();
	}

}
