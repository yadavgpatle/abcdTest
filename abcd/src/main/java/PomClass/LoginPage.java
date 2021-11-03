package PomClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

	    private WebDriver driver;
		
		@FindBy (xpath = "//input[@id='login']")
		private WebElement username;
		
		@FindBy (xpath = "//input[@id='password']")
		private WebElement pass;
		
		@FindBy (xpath = "//button[@type='submit']")
		private WebElement login;
		
		@FindBy (xpath = "//div[contains(@class,'HeaderUserName_userName')]")
		private WebElement drop;
		
		@FindBy (xpath = "//a[text()='Sign Out']")
		private WebElement logout;
		
		public LoginPage(WebDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
		
		public void UserName()
		{
			username.sendKeys("yadavpatle@gmail.com");
		}
		
		
		public void Pass()
		{
			pass.sendKeys("1SmartOk");
		}
		
		public void continueButton()
		{
			login.click();
			
		}
		
		
		public void Drop()
		{
			drop.click();
		}
		
		
		
		public void Logout() throws InterruptedException
		{
			Thread.sleep(4000);
			logout.click();
			 
			 
			
		}

}

