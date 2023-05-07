package testcase;


import org.testng.annotations.Test;
import base.BaseTest;


public class mySecondTestCaseWithFM extends BaseTest{
	
	@Test
	public static void Verifytitle() 
	{
		
		driver.getTitle();
		driver.close();
	}
	
}
	



