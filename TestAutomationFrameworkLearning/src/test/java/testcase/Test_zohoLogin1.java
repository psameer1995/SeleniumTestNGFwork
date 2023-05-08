//Page object model 1
//keep locators in page class and implement using Import the class in the actual test


//1. first we need to import pageclass i,e: import PageObjectRepository.zohoLoginPage1;
//2.Keep WebDriver driver as the class level at top which is common for all the methods inside the class. keep as static.
//3.implement the methods inside the testmethdo
//4. call the test method into main method and run.

package testcase;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjectRepository.zohoLoginPage1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_zohoLogin1 {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		//to run the test in a main method.
		myfirstPOMTest();

	}
	
	public static void myfirstPOMTest() {
		
		//Intansiation of the chrome browser	
		//Step1: below command will auto download the Chromedriver and setup for us.
		WebDriverManager.chromedriver().setup();
		//Step2: setup the browser driver.
		driver = new ChromeDriver();
		
		//implementation on page class objects.
		//driver to link pageclass with test.
		driver.get("https://www.zoho.com/login.html");
		zohoLoginPage1.MainSignIn_button(driver).click(); 
		zohoLoginPage1.userName_textBox(driver).sendKeys("psameer.1995@gmail.com"); 
		zohoLoginPage1.next_button(driver).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		zohoLoginPage1.password_textBox(driver).sendKeys("9553583547");
		zohoLoginPage1.signIn_button(driver).click();
		//zohoLoginPage1.signIn_button(driver).sendKeys(Keys.RETURN); //which is equal to ENTER
		driver.getTitle();
		driver.close();	
	}

}
