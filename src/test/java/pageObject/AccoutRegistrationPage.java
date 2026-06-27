package pageObject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccoutRegistrationPage extends BasePage {

	//constructor
	public AccoutRegistrationPage(WebDriver driver) throws IOException {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//locator

		@FindBy(xpath="//input[@id='input-firstname']")
		WebElement txtfirstname;
		
		@FindBy(xpath="//input[@id='input-lastname']")
		WebElement txtlastname;
		
		@FindBy(xpath="//input[@id='input-email']")
		WebElement txtemail;
		
		@FindBy(xpath="//input[@id='input-telephone']") 
		WebElement txtnumber;
		
		@FindBy(xpath="//input[@id='input-password']")
		WebElement txtpassword;
		
		@FindBy(xpath="//input[@id='input-confirm']") 
		WebElement txtconfirmpass;
		
		@FindBy(xpath="//input[@name='agree']")
		WebElement checkagree;
		
		@FindBy(xpath="//input[@value='Continue']") 
		WebElement btncontinue;
		
		@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") 
		WebElement confirMsg;

		
		//Action
		public void firstname(String name) {
			txtfirstname.sendKeys(name);
		}
		
		public void lastname(String lastname) {
			txtlastname.sendKeys(lastname);
		}
		
		public void email(String ema) {
			txtemail.sendKeys(ema);
		}
		
		public void phonenu(String num) {
			txtnumber.sendKeys(num);
		}
		
		public void password( String pass) {
			txtpassword.sendKeys(pass);
		}
		
		public void confpass(String confpass) {
			txtconfirmpass.sendKeys(confpass);
		}
		
		public void checkbox() {
			checkagree.click();
			
		}
		
		public void continued() {
			//sol1  if not work this one then use below any one
			btncontinue.click();
				
			//sol2
			//btnContinue.submit();
			
			//so13
			//Actions act=new Actions (driver);
			//act.moveToElement (btnContinue).click().perform();
			
			//so14
			//JavascriptExecutor js=(JavascriptExecutor) driver;
			//js.executeScript("arguments[0].click();", btnContinue);
			
			//Sol 5
			//btnContinue.sendKeys (Keys. RETURN);
			
			//So16
			//WebDriverWait mywait = new WebDriverWait (driver, Duration.ofSeconds (10));
			//mywait.until (Expected Conditions.elementToBeClickable (btnContinue)).click();	
			
		}
		
		public String verifymsg() {
			try {
				return (confirMsg.getText());
			}catch( Exception e) {
				return (e.getMessage());
			}
			
		
		}
}
