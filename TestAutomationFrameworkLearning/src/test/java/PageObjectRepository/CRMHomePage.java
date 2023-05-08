package PageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CRMHomePage {
	
	//initialize WebDriver of this class (only for this file)
	WebDriver driver = null;
	
	
	//By  is a class in selenium. keep all the objects and locators here.
	By CRM_quickSearch = By.name("search");
	By CRM_searchButton = By.xpath("//input[@type='image']");
	
	
	//Create a constructor to call the methods from test using driver instance.
	//Here WebDriver driver is to create object in the test and access form the test.
	//constructor name should be same as class name
	public CRMHomePage(WebDriver driver) {
		this.driver = driver;
		//this.driver is local driver and other driver is to access from the test.
		
	}
	
	//Add String text inside the method to pass the dynamic text from the test/excel/property.
	public void hQickSearch(String text) {
		
		driver.findElement(CRM_quickSearch).click();
		//driver.findElement(CRM_quickSearch).clear();
		driver.findElement(CRM_quickSearch).sendKeys(text);
	}
	
	
	public void hSearchButton() {
		
		driver.findElement(CRM_searchButton).click();
	}
	


}
