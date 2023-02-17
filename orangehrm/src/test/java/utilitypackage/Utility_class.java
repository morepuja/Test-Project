package utilitypackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility_class {
	
	public String exceldata(int row, int cell) throws EncryptedDocumentException, IOException 
	{
		String Path="C:\\Users\\bajad\\Desktop\\Book3.xlsx";
		FileInputStream File= new FileInputStream(Path);
		Sheet s=WorkbookFactory.create(File).getSheet("Sheet1");
		String value= s.getRow(row).getCell(cell).getStringCellValue();
		return value;
		
		
	}
	public void screenshot(WebDriver driver, String TestCase) throws IOException{
		TakesScreenshot ts=((TakesScreenshot)driver);
		File src= ts.getScreenshotAs(OutputType.FILE);
		
		File F= new File("C:\\Pooja\\Projects\\eclipse-workspace\\orangehrm\\Screenshot\\"+TestCase+".png");
		FileHandler.copy(src, F);
	}
	
		
		
	}
	


