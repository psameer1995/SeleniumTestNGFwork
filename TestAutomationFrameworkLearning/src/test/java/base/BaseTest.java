package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class BaseTest {

	//
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;
			
	
	//Create public non void methods in the base test.
	//to use non void methods we should create a object of the class
	//or we can extends the BaseTest class.
	//public keyword before void is not mandatory.
	
	//to write the common code/functionalities.
	
	//@BeforeTest
	@BeforeMethod
	//@BeforeMethod-only to test the data provider single method with multiple sets of data
	public void setUp() throws IOException {
		
		if(driver==null) {
			//original as hardcoded.
			//FileReader fr = new FileReader("C:\\Users\\psame\\Sameer_Work\\Selenium\\SeleniumTestAutomationFramework1\\TestAutomationFrameworkLearning\\src\\test\\resources\\configfiles\\config.properties");
	        
			//remove hard code and add common for all, whether any user can use any directory doesnt matter.
			System.out.println("the common path till project of any user"+ System.getProperty("user.dir"));
			
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			prop.load(fr);
			
			FileReader fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
			loc.load(fr1);
			
		}
		
		
		//ignorecase will read anycase letters from property file.
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) 
		
		{
			//Intansiation of the chrome browser	
			WebDriverManager.chromedriver().setup();  //keep in base
			driver = new ChromeDriver();  //keep in base
			driver.get(prop.getProperty("testurl"));   //from propertyfile
		}
		
		
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
			//Intansiation of the firefox browser	
			WebDriverManager.firefoxdriver().setup();  //keep in base
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("testurl"));   //from propertyfile
		}
		
	}
	
	
	
	
	//@AfterTest
	@AfterMethod
	//@AfterMethod-only to test the data provider single method with m sets of data
	public void tearDown() {
		
		driver.close();
		System.out.println("Closed successfully");
		
	}

}
