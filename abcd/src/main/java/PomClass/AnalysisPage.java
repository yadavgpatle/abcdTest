package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnalysisPage {
  
	private WebDriver driver;
	
	@FindBy (xpath = "//span[text()='Analytics']")
	private WebElement analysis;
	
	@FindBy (xpath = "//div[text()='Economic Calendar']")
	private WebElement calander;
	
	
	public AnalysisPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Analysis()
	{
		analysis.click();
	}
	
	public void Calander()
	{
		calander.click();
	}
	
	
}
