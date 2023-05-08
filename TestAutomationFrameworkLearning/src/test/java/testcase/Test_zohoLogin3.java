//Page object model 1
//keep locators in page class and implement using Import the class in the actual test


//1.Keep WebDriver driver as the class level at top which is common for all the methods inside the class. keep as static.
//2. Create a object of the constructor and import pageclass.
//first we need to import pageclass i,e: import PageObjectRepository.zohoLoginPage2;
//3.implement the page methods inside the testmethod.
//4. Pass the value for (String text) in the pageclass here.
//5. call the test method into main method and run.


package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import PageObjectRepository.zohoLoginPage2;


import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class Test_zohoLogin3 {
	
	//driver -available for only this class.
	private static WebDriver driver = null;

	
	//Main method
	public static void main(String[] args) throws IOException {
		//run from main method.
		myThirdPOM_WithPropertiesTest();
	}
	
	
	
	
	public static void myThirdPOM_WithPropertiesTest() throws IOException {
		
		//Intansiation of the chrome browser	
		//Step1: below command will auto download the Chromedriver and setup for us.
		WebDriverManager.chromedriver().setup();
		//Step2: setup the browser driver.
		driver = new ChromeDriver();
		
		//basic logic to read properties (KeyValues) from resources properties file.
		FileReader fr = new FileReader("C:\\Users\\psame\\git\\SeleniumTestNGFwork\\TestAutomationFrameworkLearning\\src\\test\\resources\\configfiles\\POMTCDATA.properties");
		Properties p = new Properties();
		p.load(fr);
		
		
		//Create object of the constructor to access the pom methods of pagefile.
		//import the PageObjectRepository.zohoLoginPage2
		zohoLoginPage2 obj1 = new zohoLoginPage2(driver);
		
		driver.get(p.getProperty("URLLINK"));
		obj1.zSignInBtn();
		
		System.out.println(p.getProperty("USERNAME"));
		obj1.zUsername(p.getProperty("USERNAME"));
		
		obj1.zuNextBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println(p.getProperty("PASSWORD"));
		obj1.zPassword(p.getProperty("PASSWORD"));
		
		obj1.zsLoginBtn();
		driver.getTitle();
		driver.close();
		
	}

}
