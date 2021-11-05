package TestPackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
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

import BasePackage.Base;
import PomClass.AnalysisPage;
import PomClass.LoginPage;
import testUtilities.TestUtils;



public class LoginTest extends Base{
	
	private WebDriver driver;
	LoginPage loginpage;
	AnalysisPage ana;
	int testID;
	
	
	
	
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
		ana = new AnalysisPage(driver);
		
	}
	
	@BeforeMethod
	public void loginToApplocation() throws InterruptedException, IOException
	{

		
		loginpage.UserName();
		
		loginpage.Pass();	
		
	}
	
	@Test
	public void verify() throws InterruptedException
	{
		testID =100;
		loginpage.continueButton();
		
		Thread.sleep(5000);
		
		String act = "https://my.exness.com/";
		String exp = driver.getCurrentUrl();
		System.out.println(exp);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(act, exp);
		soft.assertAll();
		
		ana.Analysis();
		ana.Calander();
		
		Thread.sleep(5000);
	}
	
	
	@AfterMethod
	public void logoutApplication(ITestResult result) throws IOException
	
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			TestUtils.TakeScreenshot(driver, testID);
		}
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
		
		driver.quit();
		driver = null;
		System.gc();
	}

}
