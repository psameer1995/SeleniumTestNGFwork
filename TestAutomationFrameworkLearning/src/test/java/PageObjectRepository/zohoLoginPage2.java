//Page object model 1
//Keep locators and actions in page class and implement using constructor in the test.



package PageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class zohoLoginPage2 {
	
	//initialize WebDriver of this class (only for this file)
	WebDriver driver = null;
	
	//By  is a class in selenium. it contains so many methods.
	//create method name and assign locators to created method using BY class.
	
	//Keep all objects and xpaths here.
	By zohoLogin_mainSignInButton = By.linkText("SIGN IN");
	By zoho_userName = By.xpath("//input[@id='login_id']");
	By zoho_UNextButton = By.id("nextbtn");
	By zoho_Password = By.xpath("//input[@id='password']");
	By zoho_signInButton= By.id("nextbtn");
	
	
	
	//Create a constructor to call the methods from test using driver instance.
	//Here WebDriver driver is to create object in the test and access form the test.
	public zohoLoginPage2(WebDriver driver) {
		this.driver = driver;
		//this.driver is local driver and driver is to access from the test.
		
	}
	
	
	//Create methods to call the locator and perform the action.
	public void zSignInBtn() {
		
		driver.findElement(zohoLogin_mainSignInButton).click();
		
	}
	
	//Add String text inside the method to pass the dynamic text from the test/excel/property.
	public void zUsername(String text) {
		
		driver.findElement(zoho_userName).sendKeys(text);
	}
	
	
	public void zuNextBtn() {
		
		driver.findElement(zoho_UNextButton).click();
	}
	
	public void zPassword(String text) {
		
		driver.findElement(zoho_Password).sendKeys(text);
	}
	
	public void zsLoginBtn() {
		
		driver.findElement(zoho_signInButton).click();
	}
	
	

}
