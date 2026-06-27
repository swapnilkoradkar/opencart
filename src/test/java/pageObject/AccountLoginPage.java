package pageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class AccountLoginPage extends BaseClass{
	
	   WebDriver driver;
	   public AccountLoginPage(WebDriver driver) throws IOException{
			super();
			
		}
	   
	@FindBy(xpath="//input[@id='input-email']") WebElement txtemail;
	@FindBy(xpath="//input[@id='input-password']") WebElement  txtpassword;
	@FindBy(xpath="//input[@value='Login']") WebElement btnlogin;
	//@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement confirmsg;
	
	
	public void textemail(String user) {
		txtemail.sendKeys(user);
	}
	
	public void textpassword(String pass) {
		txtpassword.sendKeys(pass);
	}
	
	public void loginbutton() {
		btnlogin.click();
	}


}
