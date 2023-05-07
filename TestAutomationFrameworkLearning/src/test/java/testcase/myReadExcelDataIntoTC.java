package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class myReadExcelDataIntoTC extends BaseTest{

	@Test(dataProviderClass=ReadXLSdata.class, dataProvider="myexceldata1")
	public static void LoginTest2(String username, String password) throws InterruptedException
	
	{
		driver.findElement(By.linkText(loc.getProperty("signIn_Link"))).click();  //locators-property files
		driver.findElement(By.xpath(loc.getProperty("username_Field"))).sendKeys(username); //test data
		driver.findElement(By.id(loc.getProperty("next_Button"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath(loc.getProperty("password_Field"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("login_Button"))).click();
		driver.getTitle();
	}

}
