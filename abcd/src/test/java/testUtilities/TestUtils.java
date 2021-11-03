package testUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TestUtils {
	
	public void TakeScreenshot(int a) throws IOException{
		WebDriver driver = new ChromeDriver();
		
		Date d = new Date(); ///object 

		String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";

		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 

		File dest = new File("E:\\Screen\\scr" + FileName);
		
		FileHandler.copy(source, dest);
		
		
		
		
	}

}
