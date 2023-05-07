package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class myFirstTestWithFM extends BaseTest{
	
	@Test
	public static void LoginTest() 
	{
		
		driver.findElement(By.linkText(loc.getProperty("signIn_Link"))).click();  //locators-property files
		driver.findElement(By.xpath(loc.getProperty("username_Field"))).sendKeys("psameer.1995@gmail.com"); //test data
		driver.findElement(By.id(loc.getProperty("next_Button"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath(loc.getProperty("password_Field"))).sendKeys("9553583547");
		driver.findElement(By.xpath(loc.getProperty("login_Button"))).click();
		driver.getTitle();
	}

}
