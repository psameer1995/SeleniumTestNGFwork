package PageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CRMLoginpage {
	
	//initialize WebDriver of this class (only for this file)
	WebDriver driver = null;
	
	
	//By  is a class in selenium. keep all the objects and locators here.
	By CRM_userName = By.xpath("//input[@placeholder='Username']");
	By CRM_Password = By.xpath("//input[@placeholder='Password']");
	By CRM_logInButton= By.xpath("//input[@value='Login']");
	
	
	//Create a constructor to call the methods from test using driver instance.
	//Here WebDriver driver is to create object in the test and access form the test.
	//constructor name should be same as class name
	public CRMLoginpage(WebDriver driver) {
		this.driver = driver;
		//this.driver is local driver and other driver is to access from the test.
		
	}
	
	//Add String text inside the method to pass the dynamic text from the test/excel/property.
	public void cUsername(String text) {
		
		driver.findElement(CRM_userName).sendKeys(text);
	}
	
	
	public void cPassword(String text) {
		
		driver.findElement(CRM_Password).sendKeys(text);
	}
	
	public void cLoginBtn() {
		
		driver.findElement(CRM_logInButton).click();
	}
	
}
