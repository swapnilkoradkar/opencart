package testBase;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageObject.AccountLoginPage;
import pageObject.HomePage;

public class LoginComan {
	public WebDriver driver;
	Logger logger;
	
	@BeforeClass
	public void  login() throws IOException {
		
		driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		logger=LogManager.getLogger(this.driver);
			
	logger.info("The test is start....");
	//Home Page
	HomePage hp= new HomePage(driver);
	hp.clickMyacount();
	hp.clickLogin();
	
	//LoginPage
	AccountLoginPage ag=new AccountLoginPage(driver);
    ag.textemail("swapnilkoradkar0573@gmail.com");
    ag.textpassword("swapnil@123");
    ag.loginbutton();
	}
	
	 @AfterClass
	 public void sutdown() {
		 driver.quit();
	 }
	

}
