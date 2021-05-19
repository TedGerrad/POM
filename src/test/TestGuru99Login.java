package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Guru99ManagersPage;
import pages.Guru99login;

public class TestGuru99Login {
	String driverPath = "C:\\Users\\TED GERRAD ARIAGA\\eclipse-workspace\\software\\chromedriver4.exe";
	WebDriver driver; 
	Guru99login objLogin; 
	Guru99ManagersPage objManagersPage; 
	
	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.chrome.driver", driverPath); 
		driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.get("http://demo.guru99.com/V4/");
	} 
	
	/* The test will login to http://demo.guru99.com/V4/ 
	 * Verify that we are logged into the write page from the title
	 * Enter user credentials to log in to the Managers page
	 * Verify that the login was successful using the displayed login message
	 */
	
	@Test(priority=0)
	public void test_Correct_Home_page(){
		//Create object for the login page 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		objLogin = new Guru99login(driver); 
		//Verify login page title 
		String loginTitlePage = objLogin.getLoginTitle(); 
		Assert.assertTrue(loginTitlePage.toLowerCase().contains("guru99 bank")); 
		//login to application 
		objLogin.loginToGuru99("mngr323925", "qabugur");
		//when successfully logged in to the managers page 
		objManagersPage = new Guru99ManagersPage(driver);
		//verify Managers page 
		
		Assert.assertTrue(objManagersPage.getManagerPageMsg().toLowerCase().contains("manager id : mngr323925"));
		//Assert.assertEquals(objManagersPage.getManagerPageMsg(), "Manager Id : mngr323925");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
}
