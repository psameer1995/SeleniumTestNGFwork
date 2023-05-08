//Page object model 1
//keep locators in page class and implement using Import the class in the actual test


//1.Keep WebDriver driver as the class level at top which is common for all the methods inside the class. keep as static.
//2. Create a object of the constructor and import pageclass.
//first we need to import pageclass i,e: import PageObjectRepository.zohoLoginPage2;
//3.implement the page methods inside the testmethod.
//4. Pass the value for (String text) in the pageclass here.
//5. call the test method into main method and run.


package testcase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import PageObjectRepository.zohoLoginPage2;

public class Test_zohoLogin2 {
	
	//driver -available for only this class.
	private static WebDriver driver = null;

	
	
	public static void main(String[] args) {
		
		//run from main method.
		mySecondPOMTest();

	}
	
	
	public static void mySecondPOMTest() {
		
		//Intansiation of the chrome browser	
		//Step1: below command will auto download the Chromedriver and setup for us.
		WebDriverManager.chromedriver().setup();
		//Step2: setup the browser driver.
		driver = new ChromeDriver();
		
		
		//Create object of the constructor to access the pom methods of pagefile.
		//import the PageObjectRepository.zohoLoginPage2
		zohoLoginPage2 obj1 = new zohoLoginPage2(driver);
		
		driver.get("https://www.zoho.com/login.html");
		obj1.zSignInBtn();
		obj1.zUsername("psameer.1995@gmail.com");
		obj1.zuNextBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		obj1.zPassword("9553583547");
		obj1.zsLoginBtn();
		driver.getTitle();
		driver.close();
		
	}

}
