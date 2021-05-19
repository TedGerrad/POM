package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Guru99ManagersPage {
	WebDriver driver;
	By managerPageMsg = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td"); 
	
	public Guru99ManagersPage(WebDriver driver){
		this.driver = driver;
	}
	
	//Get validation message from mangers page 
	
	public String getManagerPageMsg(){
		return driver.findElement(managerPageMsg).getText(); 
		
	}
	
}
