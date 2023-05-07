package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadpropertyFile {

	public static void main(String[] args) throws IOException {
		
		//Basic logic to read the property file.
		//using Filereader we can create an object to access the config.properties file.
		
		FileReader fr = new FileReader("C:\\Users\\psame\\Sameer_Work\\Selenium\\SeleniumTestAutomationFramework1\\TestAutomationFrameworkLearning\\src\\test\\resources\\configfiles\\config.properties");
        
		Properties p = new Properties();
		
		p.load(fr);
		
		//to verify propeties are loaded & accessed or not
		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("testurl"));
		
	}

}
