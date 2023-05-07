package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class myFirstTestWOFmSetup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//Intansiation of the chrome browser	
		//Step1: below command will auto download the Chromedriver and setup for us.
		WebDriverManager.chromedriver().setup();  //keep in base
		//Step2: setup the browser driver.
		WebDriver driver = new ChromeDriver();  //keep in base
		
		
		//now we can start writing our test.
		driver.get("https://www.zoho.com/login.html"); //property files
		driver.findElement(By.linkText("SIGN IN")).click();  //locators-property files
		driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys("psameer.1995@gmail.com"); //test data
		driver.findElement(By.id("nextbtn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("9553583547");
		driver.findElement(By.xpath("//button[@id='nextbtn']//span[contains(text(),'Sign in')]")).click();
		driver.getTitle();
		
		//test case should have only Business logics /Business logic methods with data inputs.
		//Easy to maintain.
		//driver.logIntoZolo("username","password");
		
		

	}

}
