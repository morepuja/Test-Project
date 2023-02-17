package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

   public class Login_POM {

    WebDriver driver;
	
   @FindBy(xpath="//input[@name='username']")private WebElement username;
   @FindBy(xpath="//input[@name='password']")private WebElement password;
   @FindBy(xpath="//button[@type='submit']")private WebElement submit;
   
    public Login_POM(WebDriver driver)
    {
     this.driver=driver;
	 PageFactory.initElements(driver, this);
	}
	
    public void Username(String User)
    {
    	username.sendKeys(User);
    }
    
    public void password (String pass)
    {
    	password.sendKeys(pass);
    }
    
    public void submit()
    {
    	submit.click();
    }
   
}
