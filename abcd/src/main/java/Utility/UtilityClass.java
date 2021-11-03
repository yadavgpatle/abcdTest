package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UtilityClass {
	
	public void ExelSheet() throws EncryptedDocumentException, IOException 
	{
		
		String path ="F:\\Book1.xlsx";
		
		FileInputStream  file = new FileInputStream (path);
		
		String value = WorkbookFactory.create(file).getSheet("Sheet1").getRow(2).getCell(2).getStringCellValue();
		
	    
	    System.out.println(" " + value);

		
		System.out.println(value);
		
	}

}
