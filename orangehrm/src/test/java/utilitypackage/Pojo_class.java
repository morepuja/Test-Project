package utilitypackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pojo_class {

	public static WebDriver launchBrowser()
	
	{
		System.setProperty("webdriver.chrome.driver","C:\\Pooja\\Projects\\eclipse-workspace\\orangehrm\\Browser1\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		
		return driver;
		
	}

}
