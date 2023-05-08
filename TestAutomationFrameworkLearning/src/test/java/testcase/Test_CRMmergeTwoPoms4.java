package testcase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import PageObjectRepository.CRMLoginpage;
import PageObjectRepository.CRMHomePage;

public class Test_CRMmergeTwoPoms4 {
	
	//define webDriver at class level, so that every method will be used.
	WebDriver driver;
	
	//constructor1 and //constructor2
	CRMLoginpage obj1;
	CRMHomePage obj2;

	
	//filereader and properties instance for whole class.
	FileReader fr;
	Properties p;

	
	@BeforeTest
	public void setUp() throws IOException {
		
		//basic logic to read properties (KeyValues) from resources properties file.
		fr = new FileReader("C:\\Users\\psame\\git\\SeleniumTestNGFwork\\TestAutomationFrameworkLearning\\src\\test\\resources\\configfiles\\POMTCDATA.properties");
		p = new Properties();
		p.load(fr);
		
		
		//Intansiation of the chrome browser	
		//Step1: below command will auto download the Chromedriver and setup for us.
		WebDriverManager.chromedriver().setup();
		//Step2: setup the browser driver.
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.get("https://classic.freecrm.com/");
		
		//read value from filereader property.
		driver.get(p.getProperty("CRMLink"));
		
	}
	
	
	
	@Test(priority = 0)
	public void loginToCRM() {
		
		//import and create object of the constructor to access the methods.
		//CRMLoginpage obj1 = new CRMLoginpage(driver); --we can also directly define at class level.
		obj1 = new CRMLoginpage(driver);
		obj1.cUsername(p.getProperty("CRM_USERNAME"));
		obj1.cPassword(p.getProperty("CRM_PASSWORD"));
		obj1.cLoginBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	
	
	@Test(priority = 1)
	public void performQuickSearch() {
		
		//import and create object of the constructor to access the methods.
		//CRMHomePage obj2 = new CRMHomePage(driver);--we can also directly define at class level.
		obj2 = new CRMHomePage(driver);
		obj2.hQickSearch("Reports"); //add the search text in the POMTCDATA.properties file
		obj2.hSearchButton();
	}
	
	
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();;
		
	}

}
