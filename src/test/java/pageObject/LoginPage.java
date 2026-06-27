package pageObject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );
		
	}
	
	By textmail=By.xpath("//input[@id='input-email']");
	By textpassword =By.xpath("//input[@id='input-password']");
	By btnlogin=By.xpath("//input[@value='Login']");
	By confimsg =By.xpath("//h2[normalize-space()='My Account']");
	//By btnlogout= By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']");

	public  void email(String user) {
		driver.findElement(textmail).sendKeys(user);
		
	}
	
	public void pass(String pass) {
		driver.findElement(textpassword).sendKeys(pass);
	}
	
	public void clickLgn() {
		driver.findElement(btnlogin).click();
	}
	
	
	public boolean confirmsg() {
	    try {  
	    	boolean confirmmsg =driver.findElement(confimsg).isDisplayed();
	    return confirmmsg;
	    }catch(Exception e) {
	    	return false;
	    }
	    
	}}
	


