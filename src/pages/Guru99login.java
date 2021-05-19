package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Guru99login {
	WebDriver driver ;
	By user99GuruName = By.name("uid");
	By password99Guru = By.name("password");
	By titleText = By.className("barone");
	By login = By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]");
	
	public Guru99login(WebDriver driver){
		this.driver = driver; 	
	}
	
	//set username in textbox 
	public void setUserName(String strUserName){
		driver.findElement(user99GuruName).sendKeys(strUserName);	
	}
	
	// set password in password textbox
	public void setPassword(String strPassword){
		driver.findElement(password99Guru).sendKeys(strPassword);
	}
	
	//Click on login button 
	public void clickLogin(){
		driver.findElement(login).click();
	}
	
	//Get the title of the login page 
	public String getLoginTitle(){
		return driver.findElement(titleText).getText();
	}
	
	public void loginToGuru99(String strUserName,String strPassword){
		//Enter username
		this.setUserName(strUserName);
		//Enter password 
		this.setPassword(strPassword);
		//Click login button 
		this.clickLogin();
	}
}
