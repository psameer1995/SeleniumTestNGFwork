package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class DataprovideConfigTC extends BaseTest{
	
	@Test(dataProvider="testdata")
	public static void LoginTest1(String username, String password) 
	{
		
		driver.findElement(By.linkText(loc.getProperty("signIn_Link"))).click();  //locators-property files
		driver.findElement(By.xpath(loc.getProperty("username_Field"))).sendKeys(username); //test data
		driver.findElement(By.id(loc.getProperty("next_Button"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath(loc.getProperty("password_Field"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("login_Button"))).click();
		driver.getTitle();
	}

	@DataProvider(name = "testdata")
	public Object[][] tData() 
	{
	 return new Object[][] {
	   { "psameer.199mail.com", "9553583547"},
	   { "pser.1995@gmail.com", "9553583547"},
	   { "psamer.1995@gmail.com", "9553547"},
	   { "psameer.1995@gmail.com", "9553583547"},
	 };
	}
	
	
	
}



