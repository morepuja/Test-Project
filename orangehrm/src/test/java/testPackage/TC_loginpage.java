package testPackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pom.Login_POM;
import utilitypackage.Pojo_class;
import utilitypackage.Utility_class;

public class TC_loginpage extends Pojo_class{
	
	WebDriver driver;
	Login_POM lp;
	Utility_class us;
	ExtentSparkReporter spark;
	ExtentReports er;
	ExtentTest Test;
	
	@BeforeClass
	public void setup() {
	driver= launchBrowser();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    spark= new ExtentSparkReporter("logintest.html");
    er = new ExtentReports();
    er.attachReporter(spark);
    
    
	}
	
	@BeforeMethod
	 public void object() {
	 lp= new Login_POM(driver);
	 us= new Utility_class();
		
	}
	
	@Test
    public void verifylaunch() throws EncryptedDocumentException, IOException, InterruptedException
    {
	lp.Username(us.exceldata(1, 0));
	lp.password(us.exceldata(1, 1));
	System.out.println(us.exceldata(1, 0));
	System.out.println(us.exceldata(1, 1));
	lp.submit();
	System.out.println(driver.getCurrentUrl());
	Thread.sleep(5000);
		
    }
	@AfterMethod
	public void failedTestCaseScreenshot(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)	
	  {
		Test.log(Status.FAIL,"TestCase="+result.getTestName());
		us.screenshot(driver, result.getTestName());
	  }
	}
	
	@AfterClass
	public void teardown()
	{
	 driver.quit();	
	}
}
