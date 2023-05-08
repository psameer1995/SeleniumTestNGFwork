//Page object model 1
//keep locators in page class and implement using Import the class in the actual test

package PageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class zohoLoginPage1 {
	
	//here we can create method for each locator.
	//method(WebDriver driver) is to create instance from test and it is coming from test.
	//if you add directly WebDriver driver then that driver for only this class.
	
	//define WebElement element =null; as class variable so that we no need to define every time.
	//and it should be static
	private static WebElement element = null;
	
	
	public static WebElement MainSignIn_button(WebDriver driver) {
		
		element=driver.findElement(By.linkText("SIGN IN"));
		return element;	
	}
	
	
	public static WebElement userName_textBox(WebDriver driver) {
		
		element=driver.findElement(By.xpath("//input[@id='login_id']"));
		return element;	
	}
	
	public static WebElement next_button(WebDriver driver) {
		
		element=driver.findElement(By.id("nextbtn"));
		return element;	
	}
	
	public static WebElement password_textBox(WebDriver driver) {
		
		element=driver.findElement(By.xpath("//input[@id='password']"));
		return element;	
	}
	
	public static WebElement signIn_button(WebDriver driver) {
		
		element=driver.findElement(By.id("nextbtn"));
		return element;	
	}
	

}
